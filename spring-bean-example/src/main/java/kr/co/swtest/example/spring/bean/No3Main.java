package kr.co.swtest.example.spring.bean;

/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/

import kr.co.swtest.example.spring.bean.no3.ServiceFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * No3 Main <br/>
 * ���丮 �޼��带 �̿��� �� ����
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class No3Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("no3-context.xml");

        ServiceFactory serviceFactory = (ServiceFactory) ctx.getBean("serviceFactory");
        System.out.println(serviceFactory != null);
    }

}
