/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author KSC
 */
@Component
@Lazy
public class CollectionBean {
    private List<String> teamList;
    private Set<String> teamSet;
    private Map<String,Integer> teamMap;

    @Autowired
    public void setTeamList(List<String> teamList) {
        this.teamList = teamList;
    }

    public List<String> getTeamList() {
        System.out.println("List Elements:" + teamList);
        return teamList;
    }
    @Autowired
    public void setTeamSet(Set<String> teamSet) {
        this.teamSet = teamSet;
    }

    public Set<String> getTeamSet() {
        System.out.println("Set Elements:" + teamSet);
        return teamSet;
    }

    @Autowired
    public void setTeamMap(Map<String,Integer> teamMap) {
        this.teamMap = teamMap;
    }

    public Map<String,Integer> getTeamMap() {
        System.out.println("Map Elements:" + teamMap);
        return teamMap;
    }
}
