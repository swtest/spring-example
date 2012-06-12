/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.example02;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example02_2Test <br/>
 * �����ڷ� ��ü ���۷��� �����ϱ�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class Example02_2Test {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example02_2-applicationContext.xml");

        IPhoneAppProgrammer iPhoneAppProgrammer = (IPhoneAppProgrammer) ctx.getBean("iPhoneAppProgrammer");
        iPhoneAppProgrammer.work();
    }

}
