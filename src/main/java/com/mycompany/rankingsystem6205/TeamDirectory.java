/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rankingsystem6205;

import java.util.ArrayList;

/**
 *
 * @author Keyu Liu
 */
public class TeamDirectory {
        private ArrayList<Team> teamList;
    
    public TeamDirectory(){
        this.teamList = new ArrayList<>();
    }
    
    public Team addMatchInfo(String name, int homeMatchNum, int awayMatchNum, float[] homeGoalsRecord, float[] awayGoalsRecord){
        
        Team team = new Team(name,homeMatchNum, awayMatchNum, homeGoalsRecord,awayGoalsRecord);
        
        this.teamList.add(team);
        
        return team; 
    }

    public ArrayList<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(ArrayList<Team> teamList) {
        this.teamList = teamList;
    }
    
    
}
