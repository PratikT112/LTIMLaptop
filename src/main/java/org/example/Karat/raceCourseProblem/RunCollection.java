package org.example.Karat.raceCourseProblem;

import java.util.ArrayList;
import java.util.List;

public class RunCollection {
    public Course course;
    public List<Run> runs;

    public RunCollection(Course collectionCourse) {
        this.course = collectionCourse;
        this.runs = new ArrayList<>();
    }

    public int getNumRuns(){
        return runs.size();
    }

    public void addRun(Run run){
        if(!run.course.equals(course)){
            throw new IllegalArgumentException("Run's course is not the same as runCollection");
        }
        runs.add(run);
    }

    public int personalBest(){
        return runs.stream().filter(x->x.complete).mapToInt(Run::getRunTime).min().orElse(Integer.MAX_VALUE);
    }

    public int bestOfBests(){
        int bestOfBests = 0;

        for(int i = 0; i < course.obstacleCount; i++){
            int bestObsTime = Integer.MAX_VALUE;
            for(Run indRun: runs){
                if(i < indRun.obstacleTimes.size()){
                    bestObsTime = Math.min(bestObsTime, indRun.obstacleTimes.get(i));
                }
            }
            bestOfBests += bestObsTime;
        }
        return bestOfBests;
    }

    public double chanceOfPersonalBest(Run testRun) {
        int personalBest = personalBest();
        List<List<Integer>> combinations = new ArrayList<List<Integer>>();
        for(int i=testRun.obstacleTimes.size();i< course.obstacleCount;i++){
            List<Integer> combination = new ArrayList<>();
            for(int j = 0;j<runs.size();j++){
                Run run = runs.get(j);
                if(i< run.obstacleTimes.size()){
                    combination.add(run.obstacleTimes.get(i));
                }
            }
            combinations.add(combination);
        }
        double totalCombination =  combinations.stream().map(l->l.size()).reduce((a,b)->a*b).get();
        double possibleCombinationCount = 0.00;
        int possiblePersonalBest;
        //System.out.println("combinations :"+combinations);
        List<List<Integer>> possibleCombinations   = findPossibleCombination(combinations,new ArrayList<List<Integer>>(),0,new ArrayList<>());
        //System.out.println("total combinations :"+possibleCombinations);
        for(int i =0;i<possibleCombinations.size();i++){
            possiblePersonalBest = testRun.getRunTime();
            //System.out.println("initial obstacle time sum :"+possiblePersonalBest);
            possiblePersonalBest+=possibleCombinations.get(i).stream().mapToInt(Integer::intValue).sum();
            //System.out.println("possible personal best : "+ possiblePersonalBest);
            if(possiblePersonalBest <= personalBest){
                possibleCombinationCount++;
            }
        }
        System.out.println("chances of personnel best : "+(possibleCombinationCount/totalCombination));
        if(totalCombination > 0 ){
            return  possibleCombinationCount/totalCombination;
        }
        return 0.0;
    }

    public List<List<Integer>> findPossibleCombination(List<List<Integer>> combinations,List<List<Integer>> possibleCombinations,int idx,
                                                       List<Integer> possibleCombination){
        if(idx == combinations.size()){
            //System.out.println("comb :"+possibleCombination);
            possibleCombinations.add(new ArrayList<Integer>(possibleCombination));
            return possibleCombinations;
        }

        for(int i =0;i<combinations.get(idx).size();i++){
            List<Integer> newCombination = new ArrayList<>(possibleCombination);
            newCombination.add(combinations.get(idx).get(i));

            findPossibleCombination(combinations,possibleCombinations,idx+1,new ArrayList<>(newCombination));
        }
        return possibleCombinations;
    }

}
