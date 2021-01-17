package org.lah.WelfareFeeding.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 2020rg_group13_environmental_standard
 */
public class EnvironmentalStandard implements Serializable {
    private String environmentalstandardsnumber;

    private String animalnumber;

    private String staffing;

    private Date establishmentdate;

    private Double humiditylowerlimit;

    private Double temperaturelowerlimit;

    private Double staticpressuredifferencelowerlimit;

    private Double lightlowerlimit;

    private Double noiselowerlimit;

    private Double airvolumelowerlimit;

    private Double humidityupperlimit;

    private Double temperatureupperlimit;

    private Double staticpressuredifferenceupperlimit;

    private Double lightupperlimit;

    private Double noiseupperlimit;

    private Double airvolumeupperlimit;

    private static final long serialVersionUID = 1L;

    public String getEnvironmentalstandardsnumber() {
        return environmentalstandardsnumber;
    }

    public void setEnvironmentalstandardsnumber(String environmentalstandardsnumber) {
        this.environmentalstandardsnumber = environmentalstandardsnumber;
    }

    public String getAnimalnumber() {
        return animalnumber;
    }

    public void setAnimalnumber(String animalnumber) {
        this.animalnumber = animalnumber;
    }

    public String getStaffing() {
        return staffing;
    }

    public void setStaffing(String staffing) {
        this.staffing = staffing;
    }

    public Date getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(Date establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    public Double getHumiditylowerlimit() {
        return humiditylowerlimit;
    }

    public void setHumiditylowerlimit(Double humiditylowerlimit) {
        this.humiditylowerlimit = humiditylowerlimit;
    }

    public Double getTemperaturelowerlimit() {
        return temperaturelowerlimit;
    }

    public void setTemperaturelowerlimit(Double temperaturelowerlimit) {
        this.temperaturelowerlimit = temperaturelowerlimit;
    }

    public Double getStaticpressuredifferencelowerlimit() {
        return staticpressuredifferencelowerlimit;
    }

    public void setStaticpressuredifferencelowerlimit(Double staticpressuredifferencelowerlimit) {
        this.staticpressuredifferencelowerlimit = staticpressuredifferencelowerlimit;
    }

    public Double getLightlowerlimit() {
        return lightlowerlimit;
    }

    public void setLightlowerlimit(Double lightlowerlimit) {
        this.lightlowerlimit = lightlowerlimit;
    }

    public Double getNoiselowerlimit() {
        return noiselowerlimit;
    }

    public void setNoiselowerlimit(Double noiselowerlimit) {
        this.noiselowerlimit = noiselowerlimit;
    }

    public Double getAirvolumelowerlimit() {
        return airvolumelowerlimit;
    }

    public void setAirvolumelowerlimit(Double airvolumelowerlimit) {
        this.airvolumelowerlimit = airvolumelowerlimit;
    }

    public Double getHumidityupperlimit() {
        return humidityupperlimit;
    }

    public void setHumidityupperlimit(Double humidityupperlimit) {
        this.humidityupperlimit = humidityupperlimit;
    }

    public Double getTemperatureupperlimit() {
        return temperatureupperlimit;
    }

    public void setTemperatureupperlimit(Double temperatureupperlimit) {
        this.temperatureupperlimit = temperatureupperlimit;
    }

    public Double getStaticpressuredifferenceupperlimit() {
        return staticpressuredifferenceupperlimit;
    }

    public void setStaticpressuredifferenceupperlimit(Double staticpressuredifferenceupperlimit) {
        this.staticpressuredifferenceupperlimit = staticpressuredifferenceupperlimit;
    }

    public Double getLightupperlimit() {
        return lightupperlimit;
    }

    public void setLightupperlimit(Double lightupperlimit) {
        this.lightupperlimit = lightupperlimit;
    }

    public Double getNoiseupperlimit() {
        return noiseupperlimit;
    }

    public void setNoiseupperlimit(Double noiseupperlimit) {
        this.noiseupperlimit = noiseupperlimit;
    }

    public Double getAirvolumeupperlimit() {
        return airvolumeupperlimit;
    }

    public void setAirvolumeupperlimit(Double airvolumeupperlimit) {
        this.airvolumeupperlimit = airvolumeupperlimit;
    }
}