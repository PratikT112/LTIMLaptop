package org.example.Karat.videoStreamingProblem;

public class EventRecord {
    public Long timeStamp;
    public String userId;
    public String event;
    public Long durationMs;

    public EventRecord(Long timeStamp, String userId, String event, Long durationMs) {
        this.timeStamp = timeStamp;
        this.userId = userId;
        this.event = event;
        this.durationMs = durationMs;
    }

    public EventRecord(Long timeStamp, String userId, String event) {
        this.timeStamp = timeStamp;
        this.userId = userId;
        this.event = event;
        this.durationMs = 0L;
    }
}
