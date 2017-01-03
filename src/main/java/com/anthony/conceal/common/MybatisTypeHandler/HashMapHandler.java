package com.anthony.conceal.common.MybatisTypeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by CHENDONG239 on 2017-01-03.
 */
@MappedTypes(HashMap.class)
public class HashMapHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        System.out.println("PreparedStatement:" + ps);
        System.out.println("i:" + i);
        System.out.println("parameter:" + parameter);
        System.out.println("JdbcType:" + jdbcType);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
//        System.out.println("111"+columnName);
//        System.out.println(rs.);
//        while (rs.next())
//        {
        System.out.println(rs.getString("column_desc"));
//        }
        return null;
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        System.out.println("456");
        return null;
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        System.out.println("789");
        return null;
    }
}
