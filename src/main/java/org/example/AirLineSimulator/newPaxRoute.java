package org.example.AirLineSimulator;


import java.util.Objects;

public class newPaxRoute {
    private RouteId routeId;
    private String base;
    private String source;
    private String stopOver;
    private String destination;
    private Integer demY;
    private Integer demJ;
    private Integer demF;
    private Long leg1 = 0L;
    private Long leg2 = 0L;

    public newPaxRoute(RouteId routeId, String base, String source, String stopOver, String destination, Integer demY, Integer demJ, Integer demF, Long leg1, Long leg2) {
        this.routeId = routeId;
        this.base = base;
        this.source = source;
        this.stopOver = stopOver;
        this.destination = destination;
        this.demY = demY;
        this.demJ = demJ;
        this.demF = demF;
        this.leg1 = leg1;
        this.leg2 = leg2;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        newPaxRoute that = (newPaxRoute) o;
        return routeId.equals(that.routeId) && source.equals(that.source) && stopOver.equals(that.stopOver) && destination.equals(that.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(routeId, source, stopOver, destination);
    }

    public RouteId getRouteId() {
        return routeId;
    }

    public void setRouteId(RouteId routeId) {
        this.routeId = routeId;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getStopOver() {
        return stopOver;
    }

    public void setStopOver(String stopOver) {
        this.stopOver = stopOver;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getDemY() {
        return demY;
    }

    public void setDemY(Integer demY) {
        this.demY = demY;
    }

    public Integer getDemJ() {
        return demJ;
    }

    public void setDemJ(Integer demJ) {
        this.demJ = demJ;
    }

    public Integer getDemF() {
        return demF;
    }

    public void setDemF(Integer demF) {
        this.demF = demF;
    }

    public Long getLeg1() {
        return leg1;
    }

    public void setLeg1(Long leg1) {
        this.leg1 = leg1;
    }

    public Long getLeg2() {
        return leg2;
    }

    public void setLeg2(Long leg2) {
        this.leg2 = leg2;
    }

    public Long getTotalDist(){
        return (leg1 == null ? 0L : leg1) +
                (leg2 == null ? 0L : leg2);
    }
}
