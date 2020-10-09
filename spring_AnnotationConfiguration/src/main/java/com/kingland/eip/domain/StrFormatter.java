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
@Qualifier("strFormatter")
public class StrFormatter implements IFormatter{
    @Override
    public String format() {
        return "str";
    }
}
