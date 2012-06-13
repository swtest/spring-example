/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example02.proxy;

/**
 * ���� ���Ͻ�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public interface ServiceProxy {

    /**
     * ���� ȣ�� �� ����
     */
    public void before();

    /**
     * ���� ȣ�� �� ����
     */
    public void after();

    /**
     * ���������� ���� ȣ�� �Ϸ�� ����
     */
    public void afterReturning();

    /**
     * ���� ȣ�� �� ���ܹ߻��� ����
     */
    public void afterThrowing();

}
