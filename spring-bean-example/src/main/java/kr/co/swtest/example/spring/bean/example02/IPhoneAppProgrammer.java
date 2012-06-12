/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.example02;

import kr.co.swtest.example.spring.bean.example01.Programmer;

/**
 * ������ �� ���α׷���
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class IPhoneAppProgrammer extends Programmer {

    /** ��ǻ�� */
    private Computer computer;

    /**
     * ������
     *
     * @param computer ��ǻ��
     */
    public IPhoneAppProgrammer(Computer computer) {
        super();
        this.computer = computer;
    }

    /**
     * ������
     *
     * @param workTime �۾��ð�
     * @param computer ��ǻ��
     */
    public IPhoneAppProgrammer(int workTime, Computer computer) {
        super(workTime);
        this.computer = computer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void work() {
        super.work();
        System.out.println(this.computer.name() + "���� ���� �մϴ�.");
    }

}
