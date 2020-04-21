package pl.bemowski.football.data.api.model;

import lombok.*;
import lombok.ToString.Include;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString(onlyExplicitlyIncluded = true)
public class Record implements Serializable {
    @Include private String division;
    @Include private LocalDate date;
    @Include private String homeTeam;
    @Include private String awayTeam;
    @Include private Integer fullTimeHomeGoals;
    @Include private Integer fullTimeAwayGoals;
    private Result fullTimeResult;
    private Integer halfTimeHomeGoals;
    private Integer halfTimeAwayGoals;
    private Result halfTimeResult;
    private String attendance;
    private String referee;

    private Statistics statistics;

    private Odds odds;
    private String season;

}