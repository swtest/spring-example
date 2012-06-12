package kr.co.swtest.example.spring.bean;

/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/

import kr.co.swtest.example.spring.bean.no6.AndroidAppProgrammer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * No6_1 Main <br/>
 * �� ������Ƽ�� �����ϱ�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class No6_1Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("no6-1-context.xml");

        AndroidAppProgrammer androidAppProgrammer = (AndroidAppProgrammer) ctx.getBean("androidAppProgrammer");
        androidAppProgrammer.work();
    }

}
