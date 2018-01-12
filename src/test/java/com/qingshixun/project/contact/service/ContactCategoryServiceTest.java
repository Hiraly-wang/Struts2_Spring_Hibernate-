package com.qingshixun.project.contact.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.qingshixun.project.contact.core.BaseTransactionalJUnit4SpringContextTests;
import com.qingshixun.project.contact.model.ContactCategoryModel;
import com.qingshixun.project.contact.model.ContactModel;

@ContextConfiguration(locations = { "/applicationContext4Test.xml" })
public class ContactCategoryServiceTest extends BaseTransactionalJUnit4SpringContextTests {

    @Autowired
    private ContactCategoryService contactCategoryService;

    @Autowired
    private ContactService contactService;

    @Test
    public void testGetAllContactCategorys() throws Exception {
        List<ContactCategoryModel> contactCategorys = contactCategoryService.getAllContactCategorys();
        List<ContactModel> list = contactService.getAllContacts();
        assertThat(contactCategorys).hasSize(5);
        assertThat(contactCategorys.get(0).getId()).isEqualTo(1);
    }

    @Before
    public void setUp() throws Exception {
        logger.debug("Before Test...");
    }

    @After
    public void tearDown() throws Exception {
        logger.debug("After Test...");
    }
}
