/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rankingsystem6205;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author siyuanzhang
 */
public class Analyst {
    public Analyst(){
        
    }
    
    public String[] findAllTeams(ArrayList<MatchInfo> matchInfoList){
        
        String[] repeatedTeamNameList = new String[matchInfoList.size()];
        int i = 0;
        for (MatchInfo matchInfo : matchInfoList){  
           repeatedTeamNameList[i] = matchInfo.getHomeTeam();
           i++;
        }
        Arrays.sort(repeatedTeamNameList);
        System.out.println(repeatedTeamNameList[0]);
        System.out.println(repeatedTeamNameList[1]);
        System.out.println(repeatedTeamNameList[2]);
        System.out.println(repeatedTeamNameList[3]);
        
        Queue<String> unrepeatedTeamName = new LinkedList<String>();
        String temp = repeatedTeamNameList[0];
        unrepeatedTeamName.offer(temp);
        for (int j = 0; j<=repeatedTeamNameList.length; j++){
            if (temp.equals(repeatedTeamNameList[j]))
                j++;
            else{
                    unrepeatedTeamName.offer(repeatedTeamNameList[j]);
                    temp = repeatedTeamNameList[j];
                    j++;
            }
         }   
            String[] unrepeatedName = new String[unrepeatedTeamName.size()];
            int z = 0;
            for(String q : unrepeatedTeamName){
                System.out.println(q);
                unrepeatedName[z++] = q;
            }
            return unrepeatedName;
            
         }
    
    public int[] countHomeGoals(String name,ArrayList<MatchInfo> matchInfoList){
        int[] count = new int[10];
        for (MatchInfo matchInfo: matchInfoList){
            if (matchInfo.getHomeTeam().equals(name)){
                count[matchInfo.getHomeTeamGoals()] +=1;
            }
        }
        return count;
    }
    
     public int[] countAwayGoals(String name,ArrayList<MatchInfo> matchInfoList){
        int[] count = new int[10];
        for (MatchInfo matchInfo: matchInfoList){
            if (matchInfo.getAwayTeam().equals(name)){
                count[matchInfo.getAwayTeamGoals()] +=1;
            }
        }
        return count;
    }
     
     public int getHomeMatchNum(String name,ArrayList<MatchInfo> matchInfoList) {
         int i = 0;
        for (MatchInfo matchInfo: matchInfoList){
            if (matchInfo.getHomeTeam().equals(name)){
                i +=1;
            }
        }
        return i;         

     }
     
     public int getAwayMatchNum(String name,ArrayList<MatchInfo> matchInfoList) {
         int i = 0;
        for (MatchInfo matchInfo: matchInfoList){
            if (matchInfo.getAwayTeam().equals(name)){
                i +=1;
            }
        }
        return i;         

     }     
    
     public float[]  probabilityDensityFunction(int [] count){
         float[] pdf = new float[10];
         for(int i = 0; i<pdf.length; i++)
            pdf[i] = Division(count[i],count[0]+count[1]+count[2]+count[3]+count[4]);
         return pdf;
     }
     
     private float Division(int a,int b) {
		//“0.00000000”define accuracy
//		DecimalFormat dF = new DecimalFormat("0.000000");
//		return dF.format((float)a/b);
                  return (float)a/b; 
    }
     
     public float[] teamFightPdf(Team home, Team away, TeamDirectory td) {
         float[] result = new float[10];
         float[] homeGoals = home.getHomeGoalsRecord();
         float[] awayGoals = away.getAwayGoalsRecord();
         
         for (int i = 0; i < 10; i++){
             for (int j = 0 ; j< 10; j++){
                 result[i-j] += homeGoals[i]*awayGoals[j];
             }
         }
         
         return result;
     }
     
     
     

    
    
}    
//     public int[] insertElement(String[] original, String element, int index){
//        int length = original.length;
//        int destination[] = new int[length + 1];
//        System.arraycopy(original, 0, destination, 0, index);
//        destination[index] = element;
//        System.arraycopy(original, index, destination, index + 1, length - index);
//        
//        return destination;
//    }
   
        
    
//        Collections.sort(matchInfoList, new Comparator<MatchInfo>(){
//            @Override
//            public int compareTo(MatchInfo m1, MatchInfo m2){
//                
//                return m1.getHomeTeam().hashcode()- m2;
//            }
//        });                            
       // String[] allTeams = new String[];               
//    }

