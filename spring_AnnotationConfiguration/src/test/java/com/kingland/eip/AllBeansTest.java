/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip;

import com.kingland.eip.action.CollectionBean;
import com.kingland.eip.action.ConstructorBean;
import com.kingland.eip.action.QualifierBean;
import com.kingland.eip.action.SetBean;
import com.kingland.eip.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
/**
 * @author KSC
 */
@DisplayName("use annotation test all beans")
public class AllBeansTest {

    static ApplicationContext applicationContext;

    @BeforeAll
    public static void init() {
        applicationContext = new AnnotationConfigApplicationContext("com.kingland.eip");
    }

    @DisplayName("test bean use constructor")
    @Test
    public void testBean1() {
        ConstructorBean constructorBean = applicationContext.getBean(ConstructorBean.class);
        assertNotNull(constructorBean);
    }

    @DisplayName("test bean use set method")
    @Test
    public void testBean2() {
        SetBean setBean = applicationContext.getBean(SetBean.class);
        assertNotNull(setBean);
    }

    @DisplayName("test collections bean")
    @Test
    public void testBean3() {
        CollectionBean collectionBean = applicationContext.getBean(CollectionBean.class);
        assertNotNull(collectionBean);
        assertNotNull(collectionBean.getTeamList());
        assertNotNull(collectionBean.getTeamMap());
        assertNotNull(collectionBean.getTeamSet());
    }

    @DisplayName("test basic type value bean")
    @Test
    public void testBean4() {
        Employee employeeBean = applicationContext.getBean(Employee.class);
        assertNotNull(employeeBean);
        assertNotNull(employeeBean.getAge());
        assertNotNull(employeeBean.getName());
        assertNotNull(employeeBean.isActive());
    }

    @DisplayName("test qua  bean")
    @Test
    public void testBean5() {
        QualifierBean qualifierBean = applicationContext.getBean(QualifierBean.class);
        qualifierBean.check();
        assertNotNull(qualifierBean);
    }
}
