/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.database.example02.dao.template;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.swtest.example.spring.database.example02.dao.mapper.JdbcTemplateResultMapper;

/**
 * JDBC ���ø� <br/>
 * JDBC �ڵ忡�� �ݺ��Ǵ� DB Connection, Transaction, �ڿ���ȯ, ����ó���� ���� �ڵ带 ó���ϱ� ���� Ŭ����.
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 14.
 */
public class JdbcTemplate {

    /** Connection */
    private Connection connection;

    /** PreparedStatement */
    private PreparedStatement preparedStatement;

    /** ResultSet */
    private ResultSet resultSet;

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * �������� (select, �ܰ���ȸ)
     *
     * @param mapper ��ü���θ���
     * @param sql ����(preparedStatement �뵵)
     * @param params preparedStatement�� �� �Ķ���Ͱ� ���
     * @return �����. ���� ��� <code>null</code>�� �����Ѵ�.
     */
    protected final <T> T getSingleResult(JdbcTemplateResultMapper<T> mapper, String sql, Object... params) {
        try {
            this.connection = createConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);

            int parameterIndex = 1;
            for (Object param : params) {
                this.preparedStatement.setObject(parameterIndex++, param);
            }

            this.resultSet = this.preparedStatement.executeQuery();

            T t = null;
            if (resultSet.next()) {
                t = mapper.mapping(this.resultSet);
            }
            return t;
        } catch (Exception e) {
            // ����ó�� �ʿ�
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    /**
     * �������� (select, �ܰ���ȸ)
     *
     * @param mapper ��ü���θ���
     * @param sql ����(preparedStatement �뵵)
     * @param params preparedStatement�� �� �Ķ���Ͱ� ���
     * @return �����. ���� ��� ������ �����Ѵ�.
     */
    protected final <T> List<T> getResults(JdbcTemplateResultMapper<T> mapper, String sql, Object... params) {
        try {
            this.connection = createConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);

            int parameterIndex = 1;
            for (Object param : params) {
                this.preparedStatement.setObject(parameterIndex++, param);
            }

            this.resultSet = this.preparedStatement.executeQuery();

            List<T> results = new ArrayList<T>();
            while (resultSet.next()) {
                T t = mapper.mapping(this.resultSet);
                results.add(t);
            }
            return results;
        } catch (Exception e) {
            // ����ó�� �ʿ�
            throw new RuntimeException(e);
        } finally {
            close();
        }
    }

    /**
     * �������� (insert, update, delete)
     *
     * @param sql ����(preparedStatement �뵵)
     * @param params preparedStatement�� �� �Ķ���Ͱ� ���
     */
    protected final void executeUpdate(String sql, Object... params) {
        try {
            this.connection = createConnection();
            this.preparedStatement = this.connection.prepareStatement(sql);

            int parameterIndex = 1;
            for (Object param : params) {
                this.preparedStatement.setObject(parameterIndex++, param);
            }

            this.preparedStatement.executeUpdate();
        } catch (Exception e) {
            // ����ó�� �ʿ�
        } finally {
            close();
        }
    }

    /**
     * autoCommit ����
     * @param autoCommit ����Ŀ�Կ���
     */
    protected final void setAutoCommit(boolean autoCommit) {
        try {
            this.connection.setAutoCommit(autoCommit);
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        }
    }

    /**
     * commit
     */
    protected final void commit() {
        try {
            this.connection.commit();
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        }
    }

    /**
     * rollback
     */
    protected final void rollback() {
        try {
            this.connection.rollback();
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        }
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * connection ����
     *
     * @return connection
     */
    private Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        return DriverManager.getConnection("jdbc:hsqldb:mem:test", "SA", "");
    }

    /**
     * close
     */
    private void close() {
        closeResultSet();
        closePreparedStatement();
        closeConnection();
    }

    /**
     * ResultSet close
     */
    private void closeResultSet() {
        if (this.resultSet == null) return;

        try {
            this.resultSet.close();
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        } finally {
            this.resultSet = null;
        }
    }

    /**
     * PreparedStatement close
     */
    private void closePreparedStatement() {
        if (this.preparedStatement == null) return;

        try {
            this.preparedStatement.close();
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        } finally {
            this.preparedStatement = null;
        }
    }

    /**
     * Connection close
     */
    private void closeConnection() {
        if (this.connection == null) return;

        try {
            this.connection.close();
        } catch (SQLException e) {
            // ����ó�� �ʿ�
        } finally {
            this.connection = null;
        }
    }

}
