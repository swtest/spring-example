/*******************************************************************************
 * Copyright(c) 2012 SWTEST. All rights reserved.
 * This software is the proprietary information of SWTEST.
 *******************************************************************************/
package kr.co.swtest.example.spring.database.example04;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.sql.DataSource;

import kr.co.swtest.example.spring.database.example01.dao.CustomerDao;
import kr.co.swtest.example.spring.database.example01.dto.CustomerDto;

import org.hsqldb.jdbc.JDBCDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.test.jdbc.JdbcTestUtils;

/**
 * Example04Test <br/>
 * SimpleJdbcDaoSupport ����
 *
 * @author <a href="mailto:scroogy@swtest.co.kr">�ֿ���</a>
 * @since 2012. 6. 14.
 */
@SuppressWarnings("deprecation")
public class Example04Test {

    /** ��DAO */
    private CustomerDao customerDao;

    /**
     * DB �ʱⵥ���� ����(�ʿ�� ���̺� create) �� �׽�Ʈ ��� ����
     */
    @Before
    public void before() {
        // 1. DB �ʱⵥ���� ����(�ʿ�� ���̺� create)
        DataSource dataSource = new SimpleDriverDataSource(new JDBCDriver(), "jdbc:hsqldb:mem:test", "SA", "");
        JdbcTemplate template = new JdbcTemplate(dataSource);
        Resource resource = new ClassPathResource("/script/test-script.sql");
        JdbcTestUtils.executeSqlScript(template, resource, true);

        // 2. �׽�Ʈ ��� ����
        ApplicationContext ctx = new ClassPathXmlApplicationContext("example04-applicationContext.xml");
        this.customerDao = (CustomerDao) ctx.getBean("simpleJdbcDaoSupportCustomerDao");
    }

    /**
     * �׽�Ʈ�� DB ������ rollback(�ʿ�� ���̺� drop)
     */
    @After
    public void after() {
        // �׽�Ʈ�� DB ������ rollback(�ʿ�� ���̺� drop)
    }

    // -------------------------------------------------------------------------
    // Test Method
    // -------------------------------------------------------------------------

    /** Customer ��� �׽�Ʈ */
    @Test
    public void testCreateCustomer() {
        int customerId = 3;

        // 1. ��� �� Ȯ��
        CustomerDto customer = this.customerDao.readCustomerById(customerId);
        assertNull(customer);

        // 2. ���
        customer = new CustomerDto(customerId, "scroogy3", "scroogy3@swtest.co.kr");
        this.customerDao.createCustomer(customer);

        // 3. ����
        CustomerDto result = this.customerDao.readCustomerById(customerId);
        assertCustomer(customer, result);
    }

    /** Customer ��ȸ Test */
    @Test
    public void testReadCustomerById() {
        int customerId = 1;
        CustomerDto result = this.customerDao.readCustomerById(customerId);

        assertCustomer(new CustomerDto(customerId, "scroogy", "scroogy@swtest.co.kr"), result);
    }

    /** Customer ������ȸ Test */
    @Test
    public void testReadCustomersByCondition() {
        CustomerDto condition = new CustomerDto();
        condition.setName("s%");

        List<CustomerDto> customers = this.customerDao.readCustomersByCondition(condition);
        assertEquals(2, customers.size());
        assertCustomer(new CustomerDto(1, "scroogy", "scroogy@swtest.co.kr"), customers.get(0));
        assertCustomer(new CustomerDto(2, "scroogy2", "scroogy2@swtest.co.kr"), customers.get(1));
    }

    /** Customer ���� Test */
    @Test
    public void testUpdateCustomer() {
        // 1. ���� �� Ȯ��
        int customerId = 2;
        CustomerDto customer = this.customerDao.readCustomerById(customerId);
        assertCustomer(new CustomerDto(customerId, "scroogy2", "scroogy2@swtest.co.kr"), customer);

        // 2. ����
        customer.setName("newName");
        customer.setEmail("newEmail@swtest.co.kr");
        this.customerDao.updateCustomer(customer);

        // 3. ����
        CustomerDto result = this.customerDao.readCustomerById(customerId);
        assertEquals("newName", result.getName());
        assertEquals("newEmail@swtest.co.kr", result.getEmail());
    }

    /** Customer ���� Test */
    @Test
    public void testDeleteCustomer() {
        // 1. ���� �� Ȯ��
        int customerId = 1;
        CustomerDto customer = this.customerDao.readCustomerById(customerId);
        assertNotNull(customer);

        // 2. ����
        this.customerDao.deleteCustomerById(customerId);

        // 3. ���� �� Ȯ��
        assertNull(this.customerDao.readCustomerById(customerId));
    }

    // -------------------------------------------------------------------------
    // Private Method
    // -------------------------------------------------------------------------

    /**
     * �� ���� <br/>
     * ������� : ID, ����, �̸���
     *
     * @param expected ����ϴ� �� ����
     * @param actual ���� �� ����
     */
    private void assertCustomer(CustomerDto expected, CustomerDto actual) {
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
    }

}
