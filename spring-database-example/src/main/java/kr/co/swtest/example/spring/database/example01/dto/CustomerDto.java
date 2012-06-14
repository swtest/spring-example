/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.database.example01.dto;

import java.io.Serializable;

/**
 * CustomerDto
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 14.
 */
public class CustomerDto implements Serializable {

    /** UID */
    private static final long serialVersionUID = 7163216786886274057L;

    /** ID */
    private Integer id;

    /** ���� */
    private String name;

    /** �̸��� */
    private String email;

    // -------------------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------------------

    /**
     * ������
     */
    public CustomerDto() {
        // �ƹ��ϵ� ���� ����
    }

    /**
     * ������
     *
     * @param id ID
     * @param name ����
     * @param email �̸���
     */
    public CustomerDto(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // -------------------------------------------------------------------------
    // Getter and Setter
    // -------------------------------------------------------------------------

    /**
     * @return ID
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * @param id ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return ����
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name ����
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return �̸���
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param email �̸���
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
