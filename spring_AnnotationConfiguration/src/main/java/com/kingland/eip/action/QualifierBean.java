/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import com.kingland.eip.domain.IFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author KSC
 */
@Component
public class QualifierBean {
    @Autowired
    @Qualifier("strFormatter")
    private IFormatter iFormatter;

    public void check() {
        System.out.println(iFormatter.format());
    }
}
