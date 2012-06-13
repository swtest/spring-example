/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example01.service.logic;

import kr.co.swtest.example.spring.aop.example01.service.CustomerService;
import kr.co.swtest.example.spring.aop.example01.util.AuthorityUtil;

/**
 * �� ���� ����ü
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class CustomerServiceLogic implements CustomerService {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean someProcess(int customerLevel) {
        // 1. ����ó��
        if (!AuthorityUtil.check(customerLevel)) {
            System.out.println("������ �����ϴ�.");
            return false;
        }

        // 2. ���� ���μ��� ó��
        System.out.println("�� ���μ��� ó��");
        return true;
    }

}
