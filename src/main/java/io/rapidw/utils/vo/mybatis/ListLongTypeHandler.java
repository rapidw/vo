package io.rapidw.utils.vo.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes(List.class)
public class ListLongTypeHandler implements TypeHandler<List<Long>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<Long> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    @Override
    public List<Long> getResult(ResultSet rs, String columnName) throws SQLException {
        String resultString = rs.getString(columnName);
        if (resultString != null && !resultString.isEmpty()) {
            return Arrays.stream(resultString.split(","))
                    .map(Long::parseLong)
                    .toList();
        }
        return null;
    }

    @Override
    public List<Long> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String resultString = rs.getString(columnIndex);
        if (resultString != null && !resultString.isEmpty()) {
            return Arrays.stream(resultString.split(","))
                    .map(Long::parseLong)
                    .toList();
        }
        return null;
    }

    @Override
    public List<Long> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String resultString = cs.getString(columnIndex);
        if (resultString != null && !resultString.isEmpty()) {
            return Arrays.stream(resultString.split(","))
                    .map(Long::parseLong)
                    .toList();
        }
        return null;
    }
}
