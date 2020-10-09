/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
/**
 * @author KSC
 */
@Component
@Qualifier("intFormatter")
public class IntFormatter implements IFormatter{

    @Override
    public String format() {
        return "int";
    }
}
