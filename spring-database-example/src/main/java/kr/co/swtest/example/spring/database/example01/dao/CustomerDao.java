/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.database.example01.dao;

import java.util.List;

import kr.co.swtest.example.spring.database.example01.dto.CustomerDto;

/**
 * CustomerDao interface
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 14.
 */
public interface CustomerDao {

    /**
     * �� ���
     *
     * @param customer ��
     */
    public void createCustomer(CustomerDto customer);

    /**
     * �� ��ȸ
     *
     * @param customerId ��ID
     * @return ��. ���� ��� <code>null</code>�� �����Ѵ�.
     */
    public CustomerDto readCustomerById(int customerId);

    /**
     * ����� ��ȸ : ���ǰ˻� <br/>
     * �˻����� : ����(like), �̸���(like) <br/>
     * �������� : ����, ��ID
     *
     * @param customer �˻�����
     * @return ���ǿ� �ش��ϴ� �����. ���� ��� ����(Empty List)�� �����Ѵ�.
     */
    public List<CustomerDto> readCustomersByCondition(CustomerDto customer);

    /**
     * �� ����
     *
     * @param customer ������ ��
     */
    public void updateCustomer(CustomerDto customer);

    /**
     * �� ����
     *
     * @param customerId ��ID
     */
    public void deleteCustomerById(int customerId);

}
