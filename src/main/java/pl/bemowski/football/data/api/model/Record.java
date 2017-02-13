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
    private Result fullTimeResult;
    private int halfTimeHomeGoals;
    private int halfTimeAwayGoals;
    private Result halfTimeResult;
    private int attendance;
    private String refree;
    private int homeShots;
    private int awayShots;
    private int homeShotOnTarget;
    private int awayShotOnTarget;
    private int homeHitWoodwork;
    private int awayHitWoodwork;
    private int homeCorners;
    private int awayCorners;
    private int homeFoulCommited;
    private int awayFoulCommited;
    private int homeOffsides;
    private int awayOffsides;
    private int homeYellowCards;
    private int awayYellowCards;
    private int homeRedCards;
    private int awayRedCards;
    private int homeBookingPoints;
    private int awayBookingPoints;

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

    public void setFullTimeResult(Result fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }

    public Result getFullTimeResult() {
        return fullTimeResult;
    }

    public void setHalfTimeHomeGoals(int halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }

    public int getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    public void setHalfTimeAwayGoals(int halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    public int getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    public void setHalfTimeResult(Result halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public Result getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setRefree(String refree) {
        this.refree = refree;
    }

    public String getRefree() {
        return refree;
    }

    public void setHomeShots(int homeShots) {
        this.homeShots = homeShots;
    }

    public int getHomeShots() {
        return homeShots;
    }

    public void setAwayShots(int awayShots) {
        this.awayShots = awayShots;
    }

    public int getAwayShots() {
        return awayShots;
    }

    public void setHomeShotOnTarget(int homeShotOnTarget) {
        this.homeShotOnTarget = homeShotOnTarget;
    }

    public int getHomeShotOnTarget() {
        return homeShotOnTarget;
    }

    public void setAwayShotOnTarget(int awayShotOnTarget) {
        this.awayShotOnTarget = awayShotOnTarget;
    }

    public int getAwayShotOnTarget() {
        return awayShotOnTarget;
    }

    public void setHomeHitWoodwork(int homeHitWoodwork) {
        this.homeHitWoodwork = homeHitWoodwork;
    }

    public int getHomeHitWoodwork() {
        return homeHitWoodwork;
    }

    public void setAwayHitWoodwork(int awayHitWoodwork) {
        this.awayHitWoodwork = awayHitWoodwork;
    }

    public int getAwayHitWoodwork() {
        return awayHitWoodwork;
    }

    public void setHomeCorners(int homeCorners) {
        this.homeCorners = homeCorners;
    }

    public int getHomeCorners() {
        return homeCorners;
    }

    public void setAwayCorners(int awayCorners) {
        this.awayCorners = awayCorners;
    }

    public int getAwayCorners() {
        return awayCorners;
    }

    public void setHomeFoulCommited(int homeFoulCommited) {
        this.homeFoulCommited = homeFoulCommited;
    }

    public int getHomeFoulCommited() {
        return homeFoulCommited;
    }

    public void setAwayFoulCommited(int awayFoulCommited) {
        this.awayFoulCommited = awayFoulCommited;
    }

    public int getAwayFoulCommited() {
        return awayFoulCommited;
    }

    public void setHomeOffsides(int homeOffsides) {
        this.homeOffsides = homeOffsides;
    }

    public int getHomeOffsides() {
        return homeOffsides;
    }

    public void setAwayOffsides(int awayOffsides) {
        this.awayOffsides = awayOffsides;
    }

    public int getAwayOffsides() {
        return awayOffsides;
    }

    public void setHomeYellowCards(int homeYellowCards) {
        this.homeYellowCards = homeYellowCards;
    }

    public int getHomeYellowCards() {
        return homeYellowCards;
    }

    public void setAwayYellowCards(int awayYellowCards) {
        this.awayYellowCards = awayYellowCards;
    }

    public int getAwayYellowCards() {
        return awayYellowCards;
    }

    public void setHomeRedCards(int homeRedCards) {
        this.homeRedCards = homeRedCards;
    }

    public int getHomeRedCards() {
        return homeRedCards;
    }

    public void setAwayRedCards(int awayRedCards) {
        this.awayRedCards = awayRedCards;
    }

    public int getAwayRedCards() {
        return awayRedCards;
    }


    public void setHomeBookingPoints(int homeBookingPoints) {
        this.homeBookingPoints = homeBookingPoints;
    }

    public int getHomeBookingPoints() {
        return homeBookingPoints;
    }

    public void setAwayBookingPoints(int awayBookingPoints) {
        this.awayBookingPoints = awayBookingPoints;
    }

    public int getAwayBookingPoints() {
        return awayBookingPoints;
    }
}
