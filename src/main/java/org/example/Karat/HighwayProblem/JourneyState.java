package org.example.Karat.HighwayProblem;

public class JourneyState {
    LogEntry last;
    int segments120OrMore;
    boolean flagged;


    public JourneyState(LogEntry start) {
        this.last = start;
        this.segments120OrMore = 0;
        this.flagged = false;
    }
}
