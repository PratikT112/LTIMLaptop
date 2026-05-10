package org.example.CitiCI;

public class Produce {
    private String status;
    private String date;
    private Long count;

    public Produce(String status, String date, Long count) {
        this.status = status;
        this.date = date;
        this.count = count;
    }


    public Produce() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
