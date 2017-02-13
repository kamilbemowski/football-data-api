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
    private Integer halfTimeHomeGoals;
    private Integer halfTimeAwayGoals;
    private Result halfTimeResult;
    private String attendance;
    private String refree;
    private Integer homeShots;
    private Integer awayShots;
    private Integer homeShotOnTarget;
    private Integer awayShotOnTarget;
    private Integer homeHitWoodwork;
    private Integer awayHitWoodwork;
    private Integer homeCorners;
    private Integer awayCorners;
    private Integer homeFoulCommited;
    private Integer awayFoulCommited;
    private Integer homeOffsides;
    private Integer awayOffsides;
    private Integer homeYellowCards;
    private Integer awayYellowCards;
    private Integer homeRedCards;
    private Integer awayRedCards;
    private Integer homeBookingPoints;
    private Integer awayBookingPoints;
    private Double bet365homeWinOdds;
    private Double bet365DrawOdd;
    private Double bet365awayWinOdds;
    private Double blueSquareHomeWinOdds;
    private Double blueSquareDrawOdds;
    private Double blueSquareAwayWinOdds;
    private Double beWinHomeWinOdds;
    private Double beWinDrawOdds;
    private Double beWinAwayWinOdds;
    private Double gamebookershomeWinOdds;
    private Double gamebookersDrawOdd;
    private Double gamebookersawayWinOdds;
    private Double interwettenhomeWinOdds;
    private Double interwettenDrawOdd;
    private Double interwettenawayWinOdds;
    private Double ladbrokeshomeWinOdds;
    private Double ladbrokesDrawOdd;
    private Double ladbrokesawayWinOdds;
    private Double pinnaclehomeWinOdds;
    private Double pinnacleDrawOdd;
    private Double pinnacleawayWinOdds;
    private Double sportingOddsHomeWinOdds;
    private Double sportingOddsDrawOdds;
    private Double sportingOddsAwayWinOdds;
    private Double sportingbethomeWinOdds;
    private Double sportingbetDrawOdd;
    private Double sportingbetawayWinOdds;
    private Double stanJamesHomeWinOdds;
    private Double stanJamesDrawOdds;
    private Double stanJamesAwayWinOdds;
    private Double stanleybethomeWinOdds;
    private Double stanleybetDrawOdd;
    private Double VCBetHomeWinOdds;
    private Double VCBetDrawOdds;
    private Double VCBetAwayWinOdds;
    private Double williamHillHomeWinOdds;
    private Double williamHillDrawOdds;
    private Double williamHillAwayWinOdds;
    private Double stanleybetawayWinOdds;

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

    public void setHalfTimeHomeGoals(Integer halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }

    public Integer getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    public void setHalfTimeAwayGoals(Integer halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    public Integer getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    public void setHalfTimeResult(Result halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public Result getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setRefree(String refree) {
        this.refree = refree;
    }

    public String getRefree() {
        return refree;
    }

    public void setHomeShots(Integer homeShots) {
        this.homeShots = homeShots;
    }

    public Integer getHomeShots() {
        return homeShots;
    }

    public void setAwayShots(Integer awayShots) {
        this.awayShots = awayShots;
    }

    public Integer getAwayShots() {
        return awayShots;
    }

    public void setHomeShotOnTarget(Integer homeShotOnTarget) {
        this.homeShotOnTarget = homeShotOnTarget;
    }

    public Integer getHomeShotOnTarget() {
        return homeShotOnTarget;
    }

    public void setAwayShotOnTarget(Integer awayShotOnTarget) {
        this.awayShotOnTarget = awayShotOnTarget;
    }

    public Integer getAwayShotOnTarget() {
        return awayShotOnTarget;
    }

    public void setHomeHitWoodwork(Integer homeHitWoodwork) {
        this.homeHitWoodwork = homeHitWoodwork;
    }

    public Integer getHomeHitWoodwork() {
        return homeHitWoodwork;
    }

    public void setAwayHitWoodwork(Integer awayHitWoodwork) {
        this.awayHitWoodwork = awayHitWoodwork;
    }

    public Integer getAwayHitWoodwork() {
        return awayHitWoodwork;
    }

    public void setHomeCorners(Integer homeCorners) {
        this.homeCorners = homeCorners;
    }

    public Integer getHomeCorners() {
        return homeCorners;
    }

    public void setAwayCorners(Integer awayCorners) {
        this.awayCorners = awayCorners;
    }

    public Integer getAwayCorners() {
        return awayCorners;
    }

    public void setHomeFoulCommited(Integer homeFoulCommited) {
        this.homeFoulCommited = homeFoulCommited;
    }

    public Integer getHomeFoulCommited() {
        return homeFoulCommited;
    }

    public void setAwayFoulCommited(Integer awayFoulCommited) {
        this.awayFoulCommited = awayFoulCommited;
    }

    public Integer getAwayFoulCommited() {
        return awayFoulCommited;
    }

    public void setHomeOffsides(Integer homeOffsides) {
        this.homeOffsides = homeOffsides;
    }

    public Integer getHomeOffsides() {
        return homeOffsides;
    }

    public void setAwayOffsides(Integer awayOffsides) {
        this.awayOffsides = awayOffsides;
    }

    public Integer getAwayOffsides() {
        return awayOffsides;
    }

    public void setHomeYellowCards(Integer homeYellowCards) {
        this.homeYellowCards = homeYellowCards;
    }

    public Integer getHomeYellowCards() {
        return homeYellowCards;
    }

    public void setAwayYellowCards(Integer awayYellowCards) {
        this.awayYellowCards = awayYellowCards;
    }

    public Integer getAwayYellowCards() {
        return awayYellowCards;
    }

    public void setHomeRedCards(Integer homeRedCards) {
        this.homeRedCards = homeRedCards;
    }

    public Integer getHomeRedCards() {
        return homeRedCards;
    }

    public void setAwayRedCards(Integer awayRedCards) {
        this.awayRedCards = awayRedCards;
    }

    public Integer getAwayRedCards() {
        return awayRedCards;
    }


    public void setHomeBookingPoints(Integer homeBookingPoints) {
        this.homeBookingPoints = homeBookingPoints;
    }

    public Integer getHomeBookingPoints() {
        return homeBookingPoints;
    }

    public void setAwayBookingPoints(Integer awayBookingPoints) {
        this.awayBookingPoints = awayBookingPoints;
    }

    public Integer getAwayBookingPoints() {
        return awayBookingPoints;
    }

    public void setBet365homeWinOdds(Double bet365homeWinOdds) {
        this.bet365homeWinOdds = bet365homeWinOdds;
    }

    public Double getBet365homeWinOdds() {
        return bet365homeWinOdds;
    }

    public void setBet365DrawOdd(Double bet365DrawOdd) {
        this.bet365DrawOdd = bet365DrawOdd;
    }

    public Double getBet365DrawOdd() {
        return bet365DrawOdd;
    }

    public void setBet365awayWinOdds(Double bet365awayWinOdds) {
        this.bet365awayWinOdds = bet365awayWinOdds;
    }

    public Double getBet365awayWinOdds() {
        return bet365awayWinOdds;
    }

    public void setBlueSquareHomeWinOdds(Double blueSquareHomeWinOdds) {
        this.blueSquareHomeWinOdds = blueSquareHomeWinOdds;
    }

    public Double getBlueSquareHomeWinOdds() {
        return blueSquareHomeWinOdds;
    }

    public void setBlueSquareDrawOdds(Double blueSquareDrawOdds) {
        this.blueSquareDrawOdds = blueSquareDrawOdds;
    }

    public Double getBlueSquareDrawOdds() {
        return blueSquareDrawOdds;
    }

    public void setBlueSquareAwayWinOdds(Double blueSquareAwayWinOdds) {
        this.blueSquareAwayWinOdds = blueSquareAwayWinOdds;
    }

    public Double getBlueSquareAwayWinOdds() {
        return blueSquareAwayWinOdds;
    }

    public void setBeWinHomeWinOdds(Double beWinHomeWinOdds) {
        this.beWinHomeWinOdds = beWinHomeWinOdds;
    }

    public Double getBeWinHomeWinOdds() {
        return beWinHomeWinOdds;
    }

    public void setBeWinDrawOdds(Double beWinDrawOdds) {
        this.beWinDrawOdds = beWinDrawOdds;
    }

    public Double getBeWinDrawOdds() {
        return beWinDrawOdds;
    }

    public void setBeWinAwayWinOdds(Double beWinAwayWinOdds) {
        this.beWinAwayWinOdds = beWinAwayWinOdds;
    }

    public Double getBeWinAwayWinOdds() {
        return beWinAwayWinOdds;
    }

    public void setGamebookershomeWinOdds(Double gamebookershomeWinOdds) {
        this.gamebookershomeWinOdds = gamebookershomeWinOdds;
    }

    public Double getGamebookershomeWinOdds() {
        return gamebookershomeWinOdds;
    }

    public void setGamebookersDrawOdd(Double gamebookersDrawOdd) {
        this.gamebookersDrawOdd = gamebookersDrawOdd;
    }

    public Double getGamebookersDrawOdd() {
        return gamebookersDrawOdd;
    }

    public void setGamebookersawayWinOdds(Double gamebookersawayWinOdds) {
        this.gamebookersawayWinOdds = gamebookersawayWinOdds;
    }

    public Double getGamebookersawayWinOdds() {
        return gamebookersawayWinOdds;
    }

    public void setInterwettenhomeWinOdds(Double interwettenhomeWinOdds) {
        this.interwettenhomeWinOdds = interwettenhomeWinOdds;
    }

    public Double getInterwettenhomeWinOdds() {
        return interwettenhomeWinOdds;
    }

    public void setInterwettenDrawOdd(Double interwettenDrawOdd) {
        this.interwettenDrawOdd = interwettenDrawOdd;
    }

    public Double getInterwettenDrawOdd() {
        return interwettenDrawOdd;
    }

    public void setInterwettenawayWinOdds(Double interwettenawayWinOdds) {
        this.interwettenawayWinOdds = interwettenawayWinOdds;
    }

    public Double getInterwettenawayWinOdds() {
        return interwettenawayWinOdds;
    }

    public void setLadbrokeshomeWinOdds(Double ladbrokeshomeWinOdds) {
        this.ladbrokeshomeWinOdds = ladbrokeshomeWinOdds;
    }

    public Double getLadbrokeshomeWinOdds() {
        return ladbrokeshomeWinOdds;
    }

    public void setLadbrokesDrawOdd(Double ladbrokesDrawOdd) {
        this.ladbrokesDrawOdd = ladbrokesDrawOdd;
    }

    public Double getLadbrokesDrawOdd() {
        return ladbrokesDrawOdd;
    }

    public void setLadbrokesawayWinOdds(Double ladbrokesawayWinOdds) {
        this.ladbrokesawayWinOdds = ladbrokesawayWinOdds;
    }

    public Double getLadbrokesawayWinOdds() {
        return ladbrokesawayWinOdds;
    }

    public void setPinnaclehomeWinOdds(Double pinnaclehomeWinOdds) {
        this.pinnaclehomeWinOdds = pinnaclehomeWinOdds;
    }

    public Double getPinnaclehomeWinOdds() {
        return pinnaclehomeWinOdds;
    }

    public void setPinnacleDrawOdd(Double pinnacleDrawOdd) {
        this.pinnacleDrawOdd = pinnacleDrawOdd;
    }

    public Double getPinnacleDrawOdd() {
        return pinnacleDrawOdd;
    }

    public void setPinnacleawayWinOdds(Double pinnacleawayWinOdds) {
        this.pinnacleawayWinOdds = pinnacleawayWinOdds;
    }

    public Double getPinnacleawayWinOdds() {
        return pinnacleawayWinOdds;
    }

    public void setSportingOddsHomeWinOdds(Double sportingOddsHomeWinOdds) {
        this.sportingOddsHomeWinOdds = sportingOddsHomeWinOdds;
    }

    public Double getSportingOddsHomeWinOdds() {
        return sportingOddsHomeWinOdds;
    }

    public void setSportingOddsDrawOdds(Double sportingOddsDrawOdds) {
        this.sportingOddsDrawOdds = sportingOddsDrawOdds;
    }

    public Double getSportingOddsDrawOdds() {
        return sportingOddsDrawOdds;
    }

    public void setSportingOddsAwayWinOdds(Double sportingOddsAwayWinOdds) {
        this.sportingOddsAwayWinOdds = sportingOddsAwayWinOdds;
    }

    public Double getSportingOddsAwayWinOdds() {
        return sportingOddsAwayWinOdds;
    }

    public void setSportingbethomeWinOdds(Double sportingbethomeWinOdds) {
        this.sportingbethomeWinOdds = sportingbethomeWinOdds;
    }

    public Double getSportingbethomeWinOdds() {
        return sportingbethomeWinOdds;
    }

    public void setSportingbetDrawOdd(Double sportingbetDrawOdd) {
        this.sportingbetDrawOdd = sportingbetDrawOdd;
    }

    public Double getSportingbetDrawOdd() {
        return sportingbetDrawOdd;
    }

    public void setSportingbetawayWinOdds(Double sportingbetawayWinOdds) {
        this.sportingbetawayWinOdds = sportingbetawayWinOdds;
    }

    public Double getSportingbetawayWinOdds() {
        return sportingbetawayWinOdds;
    }

    public void setStanJamesHomeWinOdds(Double stanJamesHomeWinOdds) {
        this.stanJamesHomeWinOdds = stanJamesHomeWinOdds;
    }

    public Double getStanJamesHomeWinOdds() {
        return stanJamesHomeWinOdds;
    }

    public void setStanJamesDrawOdds(Double stanJamesDrawOdds) {
        this.stanJamesDrawOdds = stanJamesDrawOdds;
    }

    public Double getStanJamesDrawOdds() {
        return stanJamesDrawOdds;
    }

    public void setStanJamesAwayWinOdds(Double stanJamesAwayWinOdds) {
        this.stanJamesAwayWinOdds = stanJamesAwayWinOdds;
    }

    public Double getStanJamesAwayWinOdds() {
        return stanJamesAwayWinOdds;
    }

    public void setStanleybethomeWinOdds(Double stanleybethomeWinOdds) {
        this.stanleybethomeWinOdds = stanleybethomeWinOdds;
    }

    public Double getStanleybethomeWinOdds() {
        return stanleybethomeWinOdds;
    }

    public void setStanleybetDrawOdd(Double stanleybetDrawOdd) {
        this.stanleybetDrawOdd = stanleybetDrawOdd;
    }

    public Double getStanleybetDrawOdd() {
        return stanleybetDrawOdd;
    }

    public void setVCBetHomeWinOdds(Double VCBetHomeWinOdds) {
        this.VCBetHomeWinOdds = VCBetHomeWinOdds;
    }

    public Double getVCBetHomeWinOdds() {
        return VCBetHomeWinOdds;
    }

    public void setVCBetDrawOdds(Double VCBetDrawOdds) {
        this.VCBetDrawOdds = VCBetDrawOdds;
    }

    public Double getVCBetDrawOdds() {
        return VCBetDrawOdds;
    }

    public void setVCBetAwayWinOdds(Double VCBetAwayWinOdds) {
        this.VCBetAwayWinOdds = VCBetAwayWinOdds;
    }

    public Double getVCBetAwayWinOdds() {
        return VCBetAwayWinOdds;
    }

    public void setWilliamHillHomeWinOdds(Double williamHillHomeWinOdds) {
        this.williamHillHomeWinOdds = williamHillHomeWinOdds;
    }

    public Double getWilliamHillHomeWinOdds() {
        return williamHillHomeWinOdds;
    }

    public void setWilliamHillDrawOdds(Double williamHillDrawOdds) {
        this.williamHillDrawOdds = williamHillDrawOdds;
    }

    public Double getWilliamHillDrawOdds() {
        return williamHillDrawOdds;
    }

    public void setWilliamHillAwayWinOdds(Double williamHillAwayWinOdds) {
        this.williamHillAwayWinOdds = williamHillAwayWinOdds;
    }

    public Double getWilliamHillAwayWinOdds() {
        return williamHillAwayWinOdds;
    }

    public void setStanleybetawayWinOdds(Double stanleybetawayWinOdds) {
        this.stanleybetawayWinOdds = stanleybetawayWinOdds;
    }

    public Double getStanleybetawayWinOdds() {
        return stanleybetawayWinOdds;
    }
}
