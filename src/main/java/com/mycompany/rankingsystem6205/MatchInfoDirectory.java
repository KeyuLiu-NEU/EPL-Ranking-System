/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rankingsystem6205;

import java.util.ArrayList;

/**
 *
 * @author siyuanzhang
 */
public class MatchInfoDirectory {
    private ArrayList<MatchInfo> matchInfoList;
    
    public MatchInfoDirectory(){
        this.matchInfoList = new ArrayList<>();
    }
    
    public MatchInfo addMatchInfo(){
        MatchInfo matchInfo = new MatchInfo();
        
        this.matchInfoList.add(matchInfo);
        
        return matchInfo; 
    }
    
    public int countSize(){
        return this.matchInfoList.size();
    }

    public ArrayList<MatchInfo> getMatchInfoList() {
        return matchInfoList;
    }

    public void setMatchInfoList(ArrayList<MatchInfo> matchInfoList) {
        this.matchInfoList = matchInfoList;
    }
    
}
