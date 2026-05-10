package org.example.AirLineSimulator;

import java.util.Objects;

public class PaxPlane {
    private PlaneId id;
    private String base;
    private Integer maxPaxCap;
    private Integer cfgY;
    private Integer cfgJ;
    private Integer cfgF;
    private newPaxRoute currentRoute;
    private Long range;

    public PaxPlane(PlaneId id, String base, Integer maxPaxCap, Integer cfgY, Integer cfgJ, Integer cfgF, newPaxRoute currentRoute, Long range) {
        this.id = id;
        this.base = base;
        this.maxPaxCap = maxPaxCap;
        this.cfgY = cfgY;
        this.cfgJ = cfgJ;
        this.cfgF = cfgF;
        this.currentRoute = currentRoute;
        this.range = range;
    }

    public PlaneId getId() {
        return id;
    }

    public void setId(PlaneId id) {
        this.id = id;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Integer getMaxPaxCap() {
        return maxPaxCap;
    }

    public void setMaxPaxCap(Integer maxPaxCap) {
        this.maxPaxCap = maxPaxCap;
    }

    public Integer getCfgY() {
        return cfgY;
    }

    public void setCfgY(Integer cfgY) {
        this.cfgY = cfgY;
    }

    public Integer getCfgJ() {
        return cfgJ;
    }

    public void setCfgJ(Integer cfgJ) {
        this.cfgJ = cfgJ;
    }

    public Integer getCfgF() {
        return cfgF;
    }

    public void setCfgF(Integer cfgF) {
        this.cfgF = cfgF;
    }

    public newPaxRoute getCurrentRoute() {
        return currentRoute;
    }

    public void setCurrentRoute(newPaxRoute currentRoute) {
        this.currentRoute = currentRoute;
    }

    public Long getRange() {
        return range;
    }

    public void setRange(Long range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PaxPlane paxPlane = (PaxPlane) o;
        return Objects.equals(id, paxPlane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
