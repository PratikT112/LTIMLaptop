package org.example.AirLineSimulator;

import java.util.List;

public class PaxRoute {

    public PlaneId planeId;
    public String mfgCompany;
    public String planeModel;
    public String base;
    public String source;
    public String stopOver;
    public String destination;
    public Integer demY;
    public Integer demJ;
    public Integer demF;


    @Override
    public String toString(){
        return "|" + String.join("|",
                String.format("%-10s", planeId),
                String.format("%-10s", mfgCompany),
                String.format("%-15s", planeModel),
                String.format("%-11s", routeBounds())) + "|";
    }


    public PaxRoute(String routeData, List<String> baseList) {
        String[] split = routeData.split("\\|");
        planeId = new PlaneId(split[1].trim());
        mfgCompany = split[2].trim();
        planeModel = split[3].trim();
        String[] sourceDestination = split[4].trim().split("-");
        source = sourceDestination[0];
        stopOver = sourceDestination[1];
        destination = sourceDestination[2];
        base = split[5].trim();
        String[] demands = split[6].split("-");
        demY = Integer.parseInt(demands[0].trim());
        demJ = Integer.parseInt(demands[1].trim());
        demF = Integer.parseInt(demands[2].trim());

    }

    public Boolean isPointInvolved(String port){
        return source.equals(port) || destination.equals(port);
    }

    public Boolean isBaseToBase(List<String> baseList){
        return baseList.contains(source) && baseList.contains(destination);
    }

    public String routeBounds(){
        return String.join("-", source, stopOver, destination);
    }

    public PlaneId getPlaneId() {
        return planeId;
    }

    public void setPlaneId(PlaneId planeId) {
        this.planeId = planeId;
    }

    public String getMfgCompany() {
        return mfgCompany;
    }

    public void setMfgCompany(String mfgCompany) {
        this.mfgCompany = mfgCompany;
    }

    public String getPlaneModel() {
        return planeModel;
    }

    public void setPlaneModel(String planeModel) {
        this.planeModel = planeModel;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStopOver() {
        return stopOver;
    }

    public void setStopOver(String stopOver) {
        this.stopOver = stopOver;
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
}
