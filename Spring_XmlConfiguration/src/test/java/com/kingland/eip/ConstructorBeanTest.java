package com.kingland.eip;

import com.kingland.eip.action.CollectionBean;
import com.kingland.eip.action.ConstructorBean;

import com.kingland.eip.action.SetBean;
import com.kingland.eip.domain.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("test all beans use XML")
public class ConstructorBeanTest {

    static ApplicationContext applicationContext;

    @BeforeAll
    public static void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationConfig.xml");
    }

    @DisplayName("test bean use constructor")
    @Test
    public void testBean1() {
        ConstructorBean constructorBean = applicationContext.getBean(ConstructorBean.class);
        constructorBean.save();
    }

    @DisplayName("test bean use set method")
    @Test
    public void testBean2() {
        SetBean setBean = applicationContext.getBean(SetBean.class);
        setBean.finish();
    }

    @DisplayName("test collections bean")
    @Test
    public void testBean3() {
        CollectionBean collectionBean = applicationContext.getBean(CollectionBean.class);
        collectionBean.getTeamList();
        collectionBean.getTeamSet();
        collectionBean.getTeamMap();
    }

    @DisplayName("test null value bean")
    @Test
    public void testBean4() {
        Employee employeeBean = applicationContext.getBean(Employee.class);
        assertEquals(null,employeeBean.getName());
    }
}
