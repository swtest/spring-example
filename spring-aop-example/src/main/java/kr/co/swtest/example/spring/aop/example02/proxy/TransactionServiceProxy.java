/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example02.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Ʈ����� ���� ���Ͻ� <br/>
 * ���� ȣ��� Ʈ������� �������ش�.
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class TransactionServiceProxy implements ServiceProxy, InvocationHandler {

    /** ���� ȣ�� ��� */
    private Object targetService;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * private ������
     *
     * @param targetService ���� ȣ�� ���
     */
    private TransactionServiceProxy(Object targetService) {
        this.targetService = targetService;
    }

    // -------------------------------------------------------------------------
    // Public Method
    // -------------------------------------------------------------------------

    /**
     * ���� ȣ�� ���(targetService)�� ���Ͻ� �ν��Ͻ� ����
     *
     * @param targetService ���� ȣ�� ���
     * @return ���� ȣ�� ���(targetService)�� ���Ͻ� �ν��Ͻ�
     */
    public static Object newInstance(Object targetService) {
        return Proxy.newProxyInstance(targetService.getClass().getClassLoader(), targetService.getClass().getInterfaces(),
                new TransactionServiceProxy(targetService));
    }

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

    /**
     * {@inheritDoc}
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();

        Object result = null;
        try {
            result = method.invoke(this.targetService, args);
            afterReturning();
        } catch (Exception e) {
            afterThrowing();
        }

        after();
        return result;
    }

}
