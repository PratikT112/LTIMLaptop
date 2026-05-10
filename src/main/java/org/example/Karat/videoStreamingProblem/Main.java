package org.example.Karat.videoStreamingProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        List<String> eventData =
                List.of(
                        "100 U1 PLAY -",
                        "130 U1 STOP -",
                        "200 U2 PLAY -",
                        "240 U2 STOP -"
                );

        List<EventRecord> eventClassList = new ArrayList<>();
//        eventData.add("100 U1 PLAY -");
//        eventData.add("110 U1 BUFFER 2000");
//        eventData.add("120 U1 BUFFER 200");
//        eventData.add("130 U1 STOP -");
//        eventData.add("200 U2 PLAY -");
//        eventData.add("210 U2 BUFFER 2000");
//        eventData.add("220 U2 STOP -");
//        eventData.add("300 U1 PLAY -");
//        eventData.add("310 U1 BUFFER 0000");
//        eventData.add("320 U1 STOP -");
//        eventData.add("300 U2 PLAY -");
//        eventData.add("310 U2 BUFFER 4000");
//        eventData.add("310 U2 BUFFER 2000");
//        eventData.add("320 U2 STOP -");

        for(String event: eventData){
            String[] s = event.split(" ");
            if(Objects.equals(s[3], "-")){
                EventRecord rec = new EventRecord(Long.parseLong(s[0]), s[1], s[2]);
                eventClassList.add(rec);
            } else {
                EventRecord rec = new EventRecord(Long.parseLong(s[0]), s[1], s[2], Long.parseLong(s[3]));
                eventClassList.add(rec);
            }
        }

        List<String> badUsers = new ArrayList<>();
        HashMap<String, Long> sessionBuffer = new HashMap<>();
        HashMap<String, Long> totalBuffer = new HashMap<>();

        for(EventRecord rec: eventClassList){
            String userId = rec.userId;
            if(badUsers.contains(userId)){
                continue;
            }

            switch (rec.event){
                case "PLAY":
                    sessionBuffer.put(userId, 0L);
                    totalBuffer.putIfAbsent(userId, 0L);
                    break;

                case "BUFFER":
                    if(!sessionBuffer.containsKey(userId)) break;

                    long sess = sessionBuffer.get(userId) + rec.durationMs;
                    long total = totalBuffer.get(userId) + rec.durationMs;

                    sessionBuffer.put(userId, sess);
                    totalBuffer.put(userId, total);

                    if(sess > 3000 || total > 5000){
                        badUsers.add(userId);
                    }
                    break;

                case "STOP":
                    sessionBuffer.put(userId, 0L);
                    break;
            }

        }

        System.out.println(badUsers);
        System.out.println(sessionBuffer);
        System.out.println(totalBuffer);

    }
}
