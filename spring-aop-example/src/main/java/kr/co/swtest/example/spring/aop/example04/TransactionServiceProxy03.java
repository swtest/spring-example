/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example04;

import kr.co.swtest.example.spring.aop.example02.proxy.ServiceProxy;

/**
 * Ʈ����� ���� ���Ͻ� <br/>
 * ���� ȣ��� Ʈ������� �������ش�.
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class TransactionServiceProxy03 implements ServiceProxy {

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void before() {
        System.out.println("transaction start");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void after() {
        System.out.println("transaction end");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterReturning() {
        System.out.println("commit");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterThrowing() {
        System.out.println("rollback");
    }

}
