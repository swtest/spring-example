/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.database.example02.dao.mapper;

import java.sql.ResultSet;

/**
 * JdbcTemplateResultMapper <br/>
 * JDBC ResultSet�� ���ϴ� ���Ÿ������ ��ȯ�ϴ� �������̽�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 14.
 */
public interface JdbcTemplateResultMapper<T> {

    /**
     * ResultSet ����� ���ϴ� ���Ÿ������ ��ȯ
     *
     * @param resultSet ResultSet
     * @return ���ϴ� ���Ÿ��
     */
    T mapping(ResultSet resultSet);

}
