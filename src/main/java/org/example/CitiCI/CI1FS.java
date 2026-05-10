package org.example.CitiCI;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CI1FS {
    public static void main(String[] args) {
        Produce p1 = new Produce("FRESH", "11-02-2001", 23L);
        Produce p2 = new Produce("ALM_EXP", "12-02-2001", 24L);
        Produce p3 = new Produce("FRESH", "13-02-2001", 33L);
        Produce p4 = new Produce("ALM_EXP", "14-02-2001", 43L);
        Produce p5 = new Produce("FRESH", "15-02-2001", 63L);
        Produce p6 = new Produce("ALM_EXP", "16-02-2001", 83L);
        Produce p7 = new Produce("ALM_EXP", "17-02-2001", 1L);
        Produce p8 = new Produce("ALM_EXP", "18-02-2001", 123L);
        Produce p9 = new Produce("FRESH", "19-02-2001", 323L);

        List<Produce> produceList = new ArrayList<>();
        produceList.add(p1);
        produceList.add(p2);
        produceList.add(p3);
        produceList.add(p4);
        produceList.add(p5);
        produceList.add(p6);
        produceList.add(p7);
        produceList.add(p8);
        produceList.add(p9);

        System.out.println(produceList);
        produceList.stream().filter(x-> x.getStatus() == "ALM_EXP").forEach(x->x.setStatus("FOR_SALE"));

        System.out.println(produceList);

    }
}
