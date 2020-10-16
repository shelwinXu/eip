/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.action;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * @author KSC
 */
public class CollectionBean {
    private List teamList;
    private Set teamSet;
    private Map teamMap;

    public void setTeamList(List teamList) {
        this.teamList = teamList;
    }

    public List getTeamList() {
        System.out.println("List Elements:" + teamList);
        return teamList;
    }

    public void setTeamSet(Set teamSet) {
        this.teamSet = teamSet;
    }

    public Set getTeamSet() {
        System.out.println("Set Elements:" + teamSet);
        return teamSet;
    }

    public void setTeamMap(Map teamMap) {
        this.teamMap = teamMap;
    }

    public Map getTeamMap() {
        System.out.println("Map Elements:" + teamMap);
        return teamMap;
    }
}
