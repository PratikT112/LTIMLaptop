package org.example.Karat.raceCourseProblem;

public class Solution {
    public static void main(String[] args) {
        testRun();
        testRunCollection();
        System.out.println("PAss");
    }

    public static void testRun(){
        Course testCourse = new Course("Test course", 2);
        Run testRun = new Run(testCourse);
        testRun.addObstacleTime(3);
        testRun.addObstacleTime(5);

        assert testRun.complete: "Run should be complete";
        assert testRun.getRunTime() == 9;
//        if(testRun.complete){
//            System.out.println("TestRun is complete. Passed");
//        } else {
//            System.out.println("Run should be complete");
//        }
//        if(testRun.getRunTime() == 8){
//            System.out.println("Runtime is 8. Passed");
//        } else {
//            System.out.println("Runtime test failed");
//        }

    }

    public static RunCollection makeRunCollection(Course course, int[][] obstacleData){
        RunCollection runCollection = new RunCollection(course);
        for(int[] runData: obstacleData){
            Run run = new Run(course);
            for(int obstacleTime: runData){
                run.addObstacleTime(obstacleTime);
            }
            runCollection.addRun(run);
        }
        return runCollection;
    }

    public static void testRunCollection(){
        int[][] obstacleData = new int[][]{
                {3,4,5,6},
                {4,4,5},
                {4,5,4,6},
                {5,5}
        };

        Course testCourse = new Course("Test course", 4);
        RunCollection runCollection = makeRunCollection(testCourse, obstacleData);
        assert runCollection.getNumRuns() == 4;
        System.out.println("Best of bests: " + runCollection.bestOfBests());
        System.out.println("Personal Be" + "st: " + runCollection.personalBest());
        System.out.println("Chance of best: " + runCollection.chanceOfPersonalBest(runCollection.runs.get(0)));
    }
}
