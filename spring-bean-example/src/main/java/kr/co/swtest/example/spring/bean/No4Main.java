package kr.co.swtest.example.spring.bean;

/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/

import kr.co.swtest.example.spring.bean.no4.Ticket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * No4 Main <br/>
 * �� ��ȿ���� ����
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class No4Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("no4-context.xml");

        // 1. singleton
        // 1.1. ticket 1_1 Ȯ��
        Ticket ticket1_1 = (Ticket) ctx.getBean("ticket1");
        System.out.println("ticket1_1 : " + ticket1_1.getId());

        // 1.2. ticket 1_1 id ����
        int newId = 99;
        ticket1_1.setId(newId);
        System.out.println("ticket1_1 id�� " + newId + "�� ����");

        // 1.3. ticket 1_2 Ȯ��
        Ticket ticket1_2 = (Ticket) ctx.getBean("ticket1");
        System.out.println("ticket1_2 : " + ticket1_2.getId());

        // 2. prototype
        // 2.1. ticket 2_1 Ȯ��
        Ticket ticket2_1 = (Ticket) ctx.getBean("ticket2");
        System.out.println("ticket2_1 : " + ticket2_1.getId());

        // 2.2. ticket 2_1 id ����
        ticket2_1.setId(newId);
        System.out.println("ticket2_1 id�� " + newId + "�� ����");

        // 2.3. ticket 2_2 Ȯ��
        Ticket ticket2_2 = (Ticket) ctx.getBean("ticket2");
        System.out.println("ticket2_2 : " + ticket2_2.getId());
    }

}
