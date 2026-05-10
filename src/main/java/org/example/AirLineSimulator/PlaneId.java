package org.example.AirLineSimulator;

import java.util.StringJoiner;

public class PlaneId {
    private String initLetter;
    private Integer mainId;
    private Integer subId;

    public PlaneId(String initLetter, Integer mainId, Integer subId) {
        this.initLetter = initLetter;
        this.mainId = mainId;
        this.subId = subId;
    }

    public PlaneId(String planeIdString){
        try{
            String[] split = planeIdString.split("-");
            initLetter = split[0];
            mainId = Integer.parseInt(split[1]);
            if(split.length == 3){
                subId = Integer.parseInt(split[2]);
            } else {
                subId = 0;
            }
        } catch (Exception e){
            initLetter = planeIdString;
            mainId = 0;
            subId = 0;
        }
    }

    @Override
    public String toString() {
        if (mainId > 0 && subId > 0) {
            return initLetter + "-" + mainId + "-" + subId;
        }
        if (mainId > 0) {
            return initLetter + "-" + mainId;
        }
        return initLetter;
    }

    public String getInitLetter() {
        return initLetter;
    }

    public void setInitLetter(String initLetter) {
        this.initLetter = initLetter;
    }

    public Integer getMainId() {
        return mainId;
    }

    public void setMainId(Integer mainId) {
        this.mainId = mainId;
    }

    public Integer getSubId() {
        return subId;
    }

    public void setSubId(Integer subId) {
        this.subId = subId;
    }
}
