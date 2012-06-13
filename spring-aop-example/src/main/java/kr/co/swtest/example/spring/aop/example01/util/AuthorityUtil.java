/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.aop.example01.util;

/**
 * ���� ��ƿ
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 13.
 */
public class AuthorityUtil {

    /**
     * private ������
     */
    private AuthorityUtil() {
        // �ƹ��ϵ� ���� ����
    }

    /**
     * ���� üũ <br/>
     *
     * @param customerLevel ������
     * @return �������� 2�̻��̸� <code>true</code>, �ƴϸ� <code>false</code>�� �����Ѵ�.
     */
    public static boolean check(int customerLevel) {
        if (customerLevel < 2) return false;
        return true;
    }

}
