/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.no1;

/**
 * ���α׷���
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class Programmer implements ProjectMember {

    /** �۾��ð� */
    private int workTime = 8;

    /**
     * �⺻ ����
     */
    public Programmer() {
    }

    /**
     * ������
     *
     * @param workTime �۾���
     */
    public Programmer(int workTime) {
        this.workTime = workTime;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void work() {
        System.out.println(this.workTime + "�ð� ���α׷��� �۾��� �մϴ�.");
    }

}
