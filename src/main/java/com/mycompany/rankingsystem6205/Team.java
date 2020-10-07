/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rankingsystem6205;

import java.util.Comparator;

/**
 *
 * @author siyuanzhang
 */
public class Team {
    private String name;
    private int homeMatchNum;
    private int awayMatchNum;
    private float[] homeGoalsRecord;
    private float[] awayGoalsRecord;
    
    public Team(String name,int homeMatchNum, int awayMatchNum, float[] homeGoalsRecord, float[] awayGoalsRecord){
        this.name = name;
        this.homeGoalsRecord = homeGoalsRecord;
        this.awayGoalsRecord = awayGoalsRecord;
        this.homeMatchNum = homeMatchNum;
        this.awayMatchNum = awayMatchNum;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float[] getHomeGoalsRecord() {
        return homeGoalsRecord;
    }

    public void setHomeGoalsRecord(float[] homeGoalsRecord) {
        this.homeGoalsRecord = homeGoalsRecord;
    }

    public float[] getAwayGoalsRecord() {
        return awayGoalsRecord;
    }

    public void setAwayGoalsRecord(float[] awayGoalsRecord) {
        this.awayGoalsRecord = awayGoalsRecord;
    }
    
    private float probabilityWinHome() {
        float f = 0;
        for (int i = 0; i < homeGoalsRecord.length; i++)
            f += homeGoalsRecord[i];
        return f;
            
    }
    
     private float probabilityWinAway() {
        float f = 0;
        for (int i = 0; i < homeGoalsRecord.length; i++)
            f += homeGoalsRecord[i];
        return f;
            
    }
     
     private float probabilityWin(){
        float f = 0;
        f = (this.probabilityWinHome()*(homeMatchNum/(homeMatchNum+awayMatchNum)) + (this.probabilityWinAway()*(awayMatchNum/(homeMatchNum+awayMatchNum))));
        return f;         
     }
     

    public static class ByprobabilityWinHome implements Comparator<Team>
    {
    public int compare(Team v, Team w)
    {         
        return Float.compare(v.probabilityWinHome(), w.probabilityWinHome()); }
    }
    
    public static class ByprobabilityWinAway implements Comparator<Team>
    {
    public int compare(Team v, Team w)
    {         
        return Float.compare(v.probabilityWinAway(), w.probabilityWinAway()); }
    }
    
     public static class ByprobabilityWin implements Comparator<Team>
    {
    public int compare(Team v, Team w)
    {         
        return Float.compare(v.probabilityWin(), w.probabilityWin()); }
    }
    
    
    
    
  
    
    
    
}
