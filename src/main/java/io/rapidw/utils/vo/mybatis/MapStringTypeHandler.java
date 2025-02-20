package io.rapidw.utils.vo.mybatis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MapStringTypeHandler implements TypeHandler<Map<String, Map<String, String>>> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setParameter(PreparedStatement ps, int i, Map<String, Map<String, String>> parameter, JdbcType jdbcType) throws SQLException {
        try {
            String jsonString = objectMapper.writeValueAsString(parameter);
            ps.setString(i, jsonString);
        } catch (JsonProcessingException e) {
            throw new SQLException("Error converting Map to JSON", e);
        }
    }

    @Override
    public Map<String, Map<String, String>> getResult(ResultSet rs, String columnName) throws SQLException {
        return handleResult(rs.getString(columnName));
    }

    @Override
    public Map<String, Map<String, String>> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return handleResult(rs.getString(columnIndex));
    }

    @Override
    public Map<String, Map<String, String>> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return handleResult(cs.getString(columnIndex));
    }

    private Map<String, Map<String, String>> handleResult(String resultString) throws SQLException {
        if (resultString != null && !resultString.isEmpty()) {
            try {
                return objectMapper.readValue(resultString, new TypeReference<HashMap<String, Map<String, String>>>() {});
            } catch (JsonProcessingException e) {
                throw new SQLException("Error converting JSON to Map", e);
            }
        }
        return null;
    }
}
