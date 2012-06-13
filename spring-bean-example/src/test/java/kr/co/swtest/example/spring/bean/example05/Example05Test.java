/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.example05;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Example05Test <br/>
 * ���� �ʱ�ȭ�� ���� �۾�
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class Example05Test {

    /** ClassPathXmlApplicationContext */
    private ClassPathXmlApplicationContext ctx;

    @Before
    public void before() {
        this.ctx = new ClassPathXmlApplicationContext("example05-applicationContext.xml");
    }

    @After
    public void after() {
        this.ctx.close();
    }

    @Test
    public void test() {
        assertTrue(this.ctx.getBean("room") instanceof Room);
    }

}
