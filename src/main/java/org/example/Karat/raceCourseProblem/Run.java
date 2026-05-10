package org.example.Karat.raceCourseProblem;

import javax.print.attribute.standard.JobState;
import java.util.ArrayList;
import java.util.List;

public class Run {
    public Course course;
    public boolean complete;
    public List<Integer> obstacleTimes;

    public Run(Course course, boolean complete, List<Integer> obstacleTimes) {
        this.course = course;
        this.complete = complete;
        this.obstacleTimes = new ArrayList<>();
    }

    public Run(Course runCourse) {
        course = runCourse;
        complete = false;
        obstacleTimes = new ArrayList<>();
    }

    public void addObstacleTime(int obstacleTime){
        if(complete){
            throw new IllegalStateException("Cannot add obstacle to complete run");
        }
        obstacleTimes.add(obstacleTime);
        if(obstacleTimes.size() == course.obstacleCount){
            complete = true;
        }
    }

    public int getRunTime(){
        return obstacleTimes.stream().mapToInt(Integer::intValue).sum();
    }
}
