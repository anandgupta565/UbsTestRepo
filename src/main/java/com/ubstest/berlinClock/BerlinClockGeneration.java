package com.ubstest.berlinClock;

import java.util.ArrayList;
import java.util.List;


public class BerlinClockGeneration {

    public String[] getBerlinTime(String time) {       
        List<Integer> parts = new ArrayList<Integer>();
        for (String part : time.split(":")) {
            parts.add(Integer.parseInt(part));
        }
        return new String[] {
                getSeconds(parts.get(2)),
                getTopHours(parts.get(0)),
                getLastRowHours(parts.get(0)),
                getTopMinutes(parts.get(1)),
                getLastRowMinutes(parts.get(1))
        };
    }

    public String getSeconds(int number) {
        if (number % 2 == 0) return "Y";
        else return "O";
    }

    protected String getTopHours(int number) {
        return getOnOff(4, getTopNumberOfOnSigns(number));
    }

    protected String getLastRowHours(int number) {
        return getOnOff(4, number % 5);
    }

    protected String getTopMinutes(int number) {
        return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
    }

    protected String getLastRowMinutes(int number) {
        return getOnOff(4, number % 5, "Y");
    }

    
    private String getOnOff(int lamps, int onSigns) {
        return getOnOff(lamps, onSigns, "R");
    }
    private String getOnOff(int lamps, int onSigns, String onSign) {
        String out = "";       
        for (int i = 0; i < onSigns; i++) {
            out += onSign;
        }
        for (int i = 0; i < (lamps - onSigns); i++) {
            out += "O";
        }
        return out;
    }

    private int getTopNumberOfOnSigns(int number) {
        return (number - (number % 5)) / 5;
    }

}
