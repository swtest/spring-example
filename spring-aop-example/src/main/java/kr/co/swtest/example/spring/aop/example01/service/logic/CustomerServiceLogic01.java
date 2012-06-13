/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example01.service.logic;

import kr.co.swtest.example.spring.aop.example01.service.CustomerService;

/**
 * �� ���� ����ü(01)
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class CustomerServiceLogic01 implements CustomerService {

    /**
     * {@inheritDoc}
     */
    @Override
    public void someProcess(int customerLevel) {
        System.out.println("transaction start");

        try {
            if (customerLevel < 2) {
                throw new RuntimeException();
            }

            System.out.println("�� ���μ��� ó��");
            System.out.println("commit");
        } catch (Exception e) {
            System.out.println("rollback");
        }

        System.out.println("transaction end");
    }

}
