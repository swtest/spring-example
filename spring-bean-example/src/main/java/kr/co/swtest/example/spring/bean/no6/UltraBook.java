/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.bean.no6;

import kr.co.swtest.example.spring.bean.no2.Computer;

/**
 * ��Ʈ���
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 12.
 */
public class UltraBook implements Computer {

    /**
     * {@inheritDoc}
     */
    @Override
    public String name() {
        return "��Ʈ���";
    }

}
