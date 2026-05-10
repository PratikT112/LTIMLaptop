package org.example.Karat.HighwayProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class LogFile {
    /*
     * Represents a file containing a number of log lines, converted to LogEntry
     * objects.
     */
    List<LogEntry> logEntries;
    public LogFile(BufferedReader reader) throws IOException {
        this.logEntries = new ArrayList<>();
        String line = reader.readLine();
        while (line != null) {
            LogEntry logEntry = new LogEntry(line.strip());
            this.logEntries.add(logEntry);
            line = reader.readLine();
        }
    }
    public LogEntry get(int index) {
        return this.logEntries.get(index);
    }
    public int size() {
        return this.logEntries.size();
    }

    public int countJourneys(){
        int journeyCount = 0;
        Set<String> active = new HashSet<>();
        for(LogEntry e: logEntries){
            String type = e.getBoothType();
            String key = e.getLicensePlate() + "|" + e.getDirection();

            if("ENTRY".equals(type)){
                active.add(key);
            } else if("EXIT".equals(type)){
                if(active.remove(key)){
                    journeyCount++;
                }
            }
        }
        return journeyCount;
    }
/*
    public List<String> speeders(){
        Map<String, List<LogEntry>> collect = logEntries.stream().collect(Collectors.groupingBy(x->x.getLicensePlate() + "|" + x.getDirection()));
        List<String> result = new ArrayList<>();
        for(String candidate: collect.keySet()){
            List<Double> speedsInSections = new ArrayList<>();
            for(int i = 0; i < collect.get(candidate).size(); i++){
                for(int j = i+1; j < collect.get(candidate).size(); j++){
                    double t1 = collect.get(candidate).get(i).getTimestamp();
                    double t2 = collect.get(candidate).get(j).getTimestamp();
                    double duration = t2-t1;
                    int distance = collect.get(candidate).get(j).getLocation() - collect.get(candidate).get(i).getLocation();
                    double speed = (distance / duration) * 3600;
                    if(speed > 130){
                        result.add(candidate);
                    }
                    speedsInSections.add(speed);
                }
            }
            if(speedsInSections.stream().filter(x->x > 120).count() >= 2){
                speeders().add(candidate);
            }
        }


        return result;

    }


 */
    public List<String> catchSpeeders(){
        List<String> speeders = new ArrayList<>();
        Map<String, JourneyState> active = new HashMap<>();

        for(LogEntry e: logEntries){
            String type = e.getBoothType();
            String key = e.getLicensePlate() + "|" + e.getDirection();

            if("ENTRY".equals(type)){
                active.put(key, new JourneyState(e));
                continue;
            }

            JourneyState state = active.get(key);
            if(state == null){
                continue;
            }

            double dt = e.getTimestamp() - state.last.getTimestamp();
            int distanceKm = Math.abs(e.getLocation() - state.last.getLocation());
            state.last = e;

            if(dt <= 0 || distanceKm <= 0){

            } else {
                int segments = distanceKm / 10;
                if(segments > 0){
                    double speedKmh = (3600.0 * distanceKm) / dt;
                    if(speedKmh >= 130.0){
                        state.flagged = true;
                    }
                    if(speedKmh >= 120.0){
                        state.segments120OrMore += segments;
                        if(state.segments120OrMore >= 2){
                            state.flagged = true;
                        }
                    }
                }
            }

            if("EXIT".equals(type)){
                if(state.flagged){
                    speeders.add(e.getLicensePlate());
                }
                active.remove(key);
            }
        }
        return speeders;
    }


}
