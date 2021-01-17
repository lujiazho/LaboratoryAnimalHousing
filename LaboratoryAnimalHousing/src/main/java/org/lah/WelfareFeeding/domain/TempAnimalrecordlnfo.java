package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_animalrecordlnfo
 */
public class TempAnimalrecordlnfo implements Serializable {
    private String animalnumber;

    private Integer pigage;

    private String pigsex;

    private static final long serialVersionUID = 1L;

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public Integer getPigage() {
        return pigage;
    }

    public void setPigage(Integer pigage) {
        this.pigage = pigage;
    }

    public String getPigsex() {
        return pigsex;
    }

    public void setPigsex(String pigsex) {
        this.pigsex = pigsex;
    }
}