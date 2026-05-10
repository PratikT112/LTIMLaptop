package org.example.Karat.raceCourseProblem;

import java.util.Objects;

public class Course {
    public String title;
    public int obstacleCount;

    public Course(String title, int obstacleCount) {
        this.title = title;
        this.obstacleCount = obstacleCount;
    }

    @Override
    public int hashCode() {
        return (this.title == null ? 0 : title.hashCode()) * obstacleCount;
    }

    @Override
    public boolean equals(Object obj) {
        if(getClass() != obj.getClass()) return false;
        Course that = (Course) obj;
        return Objects.equals(this.title, that.title)  &&
                this.obstacleCount == that.obstacleCount;
    }
}
