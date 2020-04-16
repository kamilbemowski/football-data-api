package pl.bemowski.football.data.api.model;

import lombok.Data;

@Data
public class Statistics {
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

}
