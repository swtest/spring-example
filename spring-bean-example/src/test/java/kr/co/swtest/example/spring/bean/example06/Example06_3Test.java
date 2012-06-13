/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.example06;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example06_3Test <br/>
 * �� ������Ƽ�� �����ϱ�(���� �� ����)
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class Example06_3Test {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example06_3-applicationContext.xml");

        AndroidAppProgrammer androidAppProgrammer = (AndroidAppProgrammer) ctx.getBean("androidAppProgrammer");
        androidAppProgrammer.work();
    }

}
