package org.example.Karat.InOutProblem;

public class MovementRecord {
    private Long timeStamp;
    private String person;
    private String direction;

    public MovementRecord(Long timeStamp, String person, String direction) {
        this.timeStamp = timeStamp;
        this.person = person;
        this.direction = direction;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "MovementRecord{" +
                "timeStamp=" + timeStamp +
                ", person='" + person + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }
}
