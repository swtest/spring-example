package kr.co.swtest.example.spring.bean;

/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * No5 Main <br/>
 * ���� �ʱ�ȭ�� ���� �۾�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class No5Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("no5-context.xml");
        ctx.close();
    }

}
