/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.no3;

/**
 * ServiceFactory
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class ServiceFactory {

    /**
     * private ������
     */
    private ServiceFactory() {
        // �ƹ��ϵ� ���� ����
    }

    /**
     * ServiceFactorySingletonHolder <br/>
     * �ʿ� ������ �ʱ�ȭ�ϴ� Ȧ��(initialization on demand holer) ���
     *
     * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
     * @since 2012. 6. 12.
     */
    private static class ServiceFactorySingletonHolder {
        static ServiceFactory INSTANCE = new ServiceFactory();
    }

    /**
     * @return ServiceFactory �ν��Ͻ�. <code>not null</code> ����.
     */
    public static ServiceFactory getInstance() {
        return ServiceFactorySingletonHolder.INSTANCE;
    }

}
