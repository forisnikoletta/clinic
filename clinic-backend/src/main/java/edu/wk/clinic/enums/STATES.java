package edu.wk.clinic.enums;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public enum STATES {
    ACCEPTED(0, "Accepted"), CONSULTING(1, "Consulting"), COMPLETED(2, "Completed");

    public static STATES getState(int state) {
        List<STATES> states = new ArrayList<STATES>(EnumSet.allOf(STATES.class));
        for(STATES st : states) {
            if(st.getState() == state) {
                return st;
            }
        }
        return null;
    }
    private int state;
    private String name;
    STATES(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public String toString() { return name; }
}
