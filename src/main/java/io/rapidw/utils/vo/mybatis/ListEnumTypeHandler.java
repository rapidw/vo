package io.rapidw.utils.vo.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.lang.reflect.ParameterizedType;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListEnumTypeHandler<T extends Enum<T>> implements TypeHandler<List<T>> {
    @SuppressWarnings("unchecked")
    private final T[] constants = ((Class<T>)((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getEnumConstants();

    @Override
    public void setParameter(PreparedStatement ps, int i, List<T> parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.stream().map(Enum::ordinal).map(String::valueOf).collect(Collectors.joining(",")));
    }

    @Override
    public List<T> getResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getString(columnName));
    }

    @Override
    public List<T> getResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getString(columnIndex));
    }

    @Override
    public List<T> getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getString(columnIndex));
    }

    private List<T> get(String resultString) {
        if (resultString != null && !resultString.isEmpty()) {
            return Arrays.stream(resultString.split(","))
                    .map(Integer::parseInt)
                    .map(v-> constants[v])
                    .toList();
        }
        return null;
    }
}
