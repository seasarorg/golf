package org.seasar.golf.uexample.ldb.allcommon.s2dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.seasar.extension.jdbc.impl.BasicStatementFactory;
import org.seasar.framework.exception.SQLRuntimeException;


/**
 * Statement factory.
 * 
 * @author DBFlute(AutoGenerator)
 */
public class S2DaoStatementFactory extends BasicStatementFactory {

    public PreparedStatement createPreparedStatement(Connection con, String sql) {
        try {
            return con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            throw new SQLRuntimeException(e);
        }
    }

}
