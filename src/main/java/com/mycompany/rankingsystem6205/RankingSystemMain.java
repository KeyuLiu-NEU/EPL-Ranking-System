/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rankingsystem6205;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;




/**
 *
 * @author siyuanzhang
 */
public class RankingSystemMain {
    private static MatchInfoDirectory matchInfoDirectory;
    private static TeamDirectory teamDirectory;
    
    public RankingSystemMain(){
        this.matchInfoDirectory = new MatchInfoDirectory();
        this.teamDirectory = new TeamDirectory();
    }
    
    public static void main(String args[]){
        RankingSystemMain rankingSystemMain = new RankingSystemMain();
        Analyst analyst = new Analyst();
        //Read data from csv files and store them into arrayList
        rankingSystemMain.readEPLDataCsv();
        
        //Read and record all participating teams this year
        String[] teamName = analyst.findAllTeams(matchInfoDirectory.getMatchInfoList());
        //Count each team's home/away goals
        
        for (String name: teamName){
            int homeMatchNum = analyst.getHomeMatchNum(name, matchInfoDirectory.getMatchInfoList());
            int awayMatchNum = analyst.getAwayMatchNum(name, matchInfoDirectory.getMatchInfoList());
            float[] homeGoalsRecord = analyst.probabilityDensityFunction(analyst.countHomeGoals(name, matchInfoDirectory.getMatchInfoList()));
            float[] awayGoalsRecord = analyst.probabilityDensityFunction(analyst.countAwayGoals(name, matchInfoDirectory.getMatchInfoList()));
            teamDirectory.addMatchInfo(name,homeMatchNum,awayMatchNum,homeGoalsRecord, awayGoalsRecord);        
        }
        //Calculatae probability density functions and record them into
        Collections.sort(teamDirectory.getTeamList(), new Team.ByprobabilityWinHome());
        
        Collections.sort(teamDirectory.getTeamList(), new Team.ByprobabilityWin());
        
        
        

    }
    
    public void readEPLDataCsv(){
        try {
            BufferedReader br=null;
            br = new BufferedReader(new FileReader("src/datasets/2019-2020.csv"));
            String line = "";
            
            br.readLine();//Skip fisrt line of title
            while ((line = br.readLine()) != null) {
                String[] split=line.split(","); 
                
                MatchInfo matchInfo = matchInfoDirectory.addMatchInfo();
                matchInfo.setHomeTeam(split[3]);
                matchInfo.setAwayTeam(split[4]);
                matchInfo.setHomeTeamGoals(Integer.parseInt(split[5]));
                matchInfo.setAwayTeamGoals(Integer.parseInt(split[6]));
                matchInfo.setResult(split[7]);
                
            }
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public MatchInfoDirectory getMatchInfoDirectory() {
        return matchInfoDirectory;
    }

    public void setMatchInfoDirectory(MatchInfoDirectory matchInfoDirectory) {
        this.matchInfoDirectory = matchInfoDirectory;
    }
    
    
}
