/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.no6;

import kr.co.swtest.example.spring.bean.example01.Programmer;
import kr.co.swtest.example.spring.bean.example02.Computer;

/**
 * �ȵ���̵� �� ���α׷���
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class AndroidAppProgrammer extends Programmer {

    /** ��ǻ�� */
    private Computer computer;

    /** �߰� �۾��ð� */
    private int addWorkTime;

    /**
     * {@inheritDoc}
     */
    @Override
    public void work() {
        super.work();
        System.out.println(this.addWorkTime + "�ð� �� ���� �մϴ�.");
        System.out.println(this.computer.name() + "���� ���� �մϴ�.");
    }

    /**
     * @return ��ǻ��
     */
    public Computer getComputer() {
        return computer;
    }

    /**
     * @param computer ��ǻ��
     */
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    /**
     * @return �߰� �۾��ð�
     */
    public int getAddWorkTime() {
        return addWorkTime;
    }

    /**
     * @param addWorkTime �߰� �۾��ð�
     */
    public void setAddWorkTime(int addWorkTime) {
        this.addWorkTime = addWorkTime;
    }

}
