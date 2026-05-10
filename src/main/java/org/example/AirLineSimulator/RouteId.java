package org.example.AirLineSimulator;

import java.util.Objects;

public class RouteId {
    private String initSeq;
    private Integer mainId;
    private Integer subId;
    private String routeIdString;


    public RouteId(String initSeq, Integer mainId, Integer subId, String routeIdString) {
        this.initSeq = initSeq;
        this.mainId = mainId;
        this.subId = subId;
        this.routeIdString = routeIdString;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RouteId routeId = (RouteId) o;
        return Objects.equals(initSeq, routeId.initSeq) && Objects.equals(mainId, routeId.mainId) && Objects.equals(subId, routeId.subId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(initSeq, mainId, subId);
    }
}
