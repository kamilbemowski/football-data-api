package pl.bemowski.football.data.api.model;

import java.time.LocalDate;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
public class Record {
    private String division;
    private String homeTeam;
    private LocalDate date;
    private String awayTeam;
    private Integer fullTimeHomeGoals;
    private Integer fullTimeAwayGoals;
    private FullTimeResult fullTimeResult;

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDivision() {
        return division;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setFullTimeHomeGoals(Integer fullTimeHomeGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
    }

    public Integer getFullTimeHomeGoals() {
        return fullTimeHomeGoals;
    }


    public void setFullTimeAwayGoals(Integer fullTimeAwayGoals) {
        this.fullTimeAwayGoals = fullTimeAwayGoals;
    }

    public Integer getFullTimeAwayGoals() {
        return fullTimeAwayGoals;
    }

    public void setFullTimeResult(FullTimeResult fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }

    public FullTimeResult getFullTimeResult() {
        return fullTimeResult;
    }
}
