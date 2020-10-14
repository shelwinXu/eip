package com.kingland.eip.domain;

import java.io.Serializable;
import java.util.Arrays;

public class RecordModel implements Serializable {
    private String teamName;
    private int championTimes;
    private int runnerUpTimes;
    private String[] championYears;
    private String[] runnerUpYears;
    private int ranks;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getChampionTimes() {
        return championTimes;
    }

    public void setChampionTimes(int championTimes) {
        this.championTimes = championTimes;
    }

    public int getRunnerUpTimes() {
        return runnerUpTimes;
    }

    public void setRunnerUpTimes(int runnerUpTimes) {
        this.runnerUpTimes = runnerUpTimes;
    }


    public String[] getRunnerUpYears() {
        return runnerUpYears;
    }

    public String[] getChampionYears() {
        return championYears;
    }

    public void setChampionYears(String[] championYears) {
        this.championYears = championYears;
    }

    public void setRunnerUpYears(String[] runnerUpYears) {
        this.runnerUpYears = runnerUpYears;
    }

    public int getRanks() {
        return ranks;
    }

    public void setRanks(int ranks) {
        this.ranks = ranks;
    }

    @Override
    public String toString() {
        return "RecordModel{" +
                "teamName='" + teamName + '\'' +
                ", championTimes=" + championTimes +
                ", runnerUpTimes=" + runnerUpTimes +
                ", championYears=" + Arrays.toString(championYears) +
                ", runnerUpYears=" + Arrays.toString(runnerUpYears) +
                ", ranks=" + ranks +
                '}';
    }
}
