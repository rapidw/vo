package io.rapidw.utils.vo.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ListStringTypeHandler implements TypeHandler<List<String>> {
    @Override
    public void setParameter(PreparedStatement ps, int i, List<String> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    @Override
    public List<String> getResult(ResultSet rs, String columnName) throws SQLException {
        // separator is ,
        String resultString = rs.getString(columnName);
        if (resultString != null && !resultString.isEmpty()) {
            return List.of(resultString.split(","));
        }
        return null;
    }

    @Override
    public List<String> getResult(ResultSet rs, int columnIndex) throws SQLException {
        String resultString = rs.getString(columnIndex);
        if (resultString != null && !resultString.isEmpty()) {
            return List.of(resultString.split(","));
        }
        return null;
    }

    @Override
    public List<String> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String resultString = cs.getString(columnIndex);
        if (resultString != null && !resultString.isEmpty()) {
            return List.of(resultString.split(","));
        }
        return null;
    }
}

