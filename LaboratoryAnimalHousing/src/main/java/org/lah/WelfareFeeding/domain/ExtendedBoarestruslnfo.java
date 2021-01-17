package org.lah.WelfareFeeding.domain;

import java.io.Serializable;

/**
 * 2020rg_group13_boarestruslnfo
 * @author 
 */
public class ExtendedBoarestruslnfo implements Serializable {
    private Integer actionid;

    private String animalnumber;

    private String behaviorstarttime;

    private String behaviorendtime;

    private String behaviordescription;

    private String treatmentplan;

    private String treatmentresult;

    private static final long serialVersionUID = 1L;

    public Integer getActionid() {
        return actionid;
    }

    public void setActionid(Integer actionid) {
        this.actionid = actionid;
    }

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public String getBehaviorstarttime() {
        return behaviorstarttime;
    }

    public void setBehaviorstarttime(String behaviorstarttime) {
        this.behaviorstarttime = behaviorstarttime;
    }

    public String getBehaviorendtime() {
        return behaviorendtime;
    }

    public void setBehaviorendtime(String behaviorendtime) {
        this.behaviorendtime = behaviorendtime;
    }

    public String getBehaviordescription() {
        return behaviordescription;
    }

    public void setBehaviordescription(String behaviordescription) {
        this.behaviordescription = behaviordescription;
    }

    public String getTreatmentplan() {
        return treatmentplan;
    }

    public void setTreatmentplan(String treatmentplan) {
        this.treatmentplan = treatmentplan;
    }

    public String getTreatmentresult() {
        return treatmentresult;
    }

    public void setTreatmentresult(String treatmentresult) {
        this.treatmentresult = treatmentresult;
    }
}