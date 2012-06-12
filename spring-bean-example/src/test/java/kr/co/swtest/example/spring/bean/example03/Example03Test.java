/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.example03;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example01Test <br/>
 * ���丮 �޼��带 �̿��� �� ����
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class Example03Test {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example03-applicationContext.xml");

        ServiceFactory serviceFactory = (ServiceFactory) ctx.getBean("serviceFactory");
        assertNotNull(serviceFactory);
    }

}
