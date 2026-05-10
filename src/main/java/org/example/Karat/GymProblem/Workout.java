package org.example.Karat.GymProblem;

public class Workout {

    private int workoutId;
    private long startTime;
    private long endTime;

    public Workout(int workoutId, long startTime, long endTime) {
        this.workoutId = workoutId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getWorkoutId() {
        return workoutId;
    }

    public void setWorkoutId(int workoutId) {
        this.workoutId = workoutId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getWorkoutDuration(){
        return endTime - startTime;
    }
}
