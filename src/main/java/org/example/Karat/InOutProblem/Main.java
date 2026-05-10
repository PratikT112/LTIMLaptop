package org.example.Karat.InOutProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> logList = List.of(
                "1000 M1 IN",
                "1010 M2 IN",
                "1020 M1 OUT",
                "1022 M4 IN",
                "1025 M4 OUT",
                "1030 M1 IN",
                "1040 M1 OUT",
                "1050 M2 OUT",
                "1060 M3 OUT"
        );

        List<MovementRecord> recordList = new ArrayList<>();

        for(String rec: logList){
            String[] fieldArr = rec.split(" ");
            MovementRecord record = new MovementRecord(Long.parseLong(fieldArr[0]), fieldArr[1], fieldArr[2]);
            recordList.add(record);
        }

        List<String> recordListString = recordList.stream().map(x -> x.toString()).toList();


        System.out.println(recordListString);

        List<String> inPerson = new ArrayList<>();
        Set<String> inPerson2 = new HashSet<>();

        int count = 0;

        for(MovementRecord rec: recordList){
            String direction = rec.getDirection();

            switch (direction){
                case "IN":
                    inPerson2.add(rec.getPerson());
                    break;

                case "OUT":
                    if(inPerson2.contains(rec.getPerson())){
                        inPerson2.remove(rec.getPerson());
                        count++;
                    }
                    break;
            }
        }
        System.out.println(count);
    }


}
