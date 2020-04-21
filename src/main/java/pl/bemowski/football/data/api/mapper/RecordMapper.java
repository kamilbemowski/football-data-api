package pl.bemowski.football.data.api.mapper;


import lombok.extern.log4j.Log4j2;
import org.apache.commons.text.WordUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pl.bemowski.football.data.api.mapper.csv.CSVRecord;
import pl.bemowski.football.data.api.model.Odds;
import pl.bemowski.football.data.api.model.Record;
import pl.bemowski.football.data.api.model.Statistics;

import java.util.Arrays;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@Log4j2
public final class RecordMapper {

    private static final Logger LOGGER = LogManager.getLogger(RecordMapper.class);

    private RecordMapper() {
    }

    public static RecordMapper createRecordMapper() {
        return new RecordMapper();
    }

    public Record mapToRecord(final CSVRecord csvRecord, String season) {
        final Record record = new Record();
        try {
            record.setDivision(csvRecord.getString("Div"));
            record.setDate(csvRecord.getLocalDate("Date"));
            record.setHomeTeam(csvRecord.getString("HomeTeam", "HT"));
            record.setAwayTeam(csvRecord.getString("AwayTeam", "AT"));
            if (record.getHomeTeam() ==null || record.getAwayTeam() == null) {
                log.error("Home or away team not set " + csvRecord.line());
            }
            record.setFullTimeHomeGoals(csvRecord.getInteger("FTHG"));
            record.setFullTimeAwayGoals(csvRecord.getInteger("FTAG"));
            record.setFullTimeResult(csvRecord.getResult("FTR"));
            record.setHalfTimeHomeGoals(csvRecord.getInteger("HTHG"));
            record.setHalfTimeAwayGoals(csvRecord.getInteger("HTAG"));
            record.setHalfTimeResult(csvRecord.getResult("HTR"));
            record.setAttendance(csvRecord.getString("Attendance"));
            record.setReferee(csvRecord.getString("Refreee", "Referee"));
            Statistics statistics = new Statistics();
            statistics.setHomeShots(csvRecord.getInteger("HS"));
            statistics.setAwayShots(csvRecord.getInteger("AS"));
            statistics.setHomeShotOnTarget(csvRecord.getInteger("HST"));
            statistics.setAwayShotOnTarget(csvRecord.getInteger("AST"));
            statistics.setHomeHitWoodwork(csvRecord.getInteger("HHW"));
            statistics.setAwayHitWoodwork(csvRecord.getInteger("AHW"));
            statistics.setHomeCorners(csvRecord.getInteger("HC"));
            statistics.setAwayCorners(csvRecord.getInteger("AC"));
            statistics.setHomeFoulCommited(csvRecord.getInteger("HF"));
            statistics.setAwayFoulCommited(csvRecord.getInteger("AF"));
            statistics.setHomeOffsides(csvRecord.getInteger("HO"));
            statistics.setAwayOffsides(csvRecord.getInteger("AO"));
            statistics.setHomeYellowCards(csvRecord.getInteger("HY"));
            statistics.setAwayYellowCards(csvRecord.getInteger("AY"));
            statistics.setHomeRedCards(csvRecord.getInteger("HR"));
            statistics.setAwayRedCards(csvRecord.getInteger("AR"));
            record.setStatistics(statistics);
            record.setSeason(season);

            Odds odds = new Odds();
            odds.setHomeBookingPoints(csvRecord.getInteger("HBP"));
            odds.setAwayBookingPoints(csvRecord.getInteger("ABP"));
            odds.setBet365homeWinOdds(csvRecord.getDouble("B365H"));
            odds.setBet365DrawOdd(csvRecord.getDouble("B365D"));
            odds.setBet365awayWinOdds(csvRecord.getDouble("B365A"));
            odds.setBlueSquareHomeWinOdds(csvRecord.getDouble("BSH"));
            odds.setBlueSquareDrawOdds(csvRecord.getDouble("BSD"));
            odds.setBlueSquareAwayWinOdds(csvRecord.getDouble("BSA"));
            odds.setBeWinHomeWinOdds(csvRecord.getDouble("BWH"));
            odds.setBeWinDrawOdds(csvRecord.getDouble("BWD"));
            odds.setBeWinAwayWinOdds(csvRecord.getDouble("BWA"));
            odds.setGamebookershomeWinOdds(csvRecord.getDouble("GBH"));
            odds.setGamebookersDrawOdd(csvRecord.getDouble("GBD"));
            odds.setGamebookersawayWinOdds(csvRecord.getDouble("GBA"));
            odds.setInterwettenhomeWinOdds(csvRecord.getDouble("IWH"));
            odds.setInterwettenDrawOdd(csvRecord.getDouble("IWD"));
            odds.setInterwettenawayWinOdds(csvRecord.getDouble("IWA"));
            odds.setLadbrokeshomeWinOdds(csvRecord.getDouble("LBH"));
            odds.setLadbrokesDrawOdd(csvRecord.getDouble("LBD"));
            odds.setLadbrokesawayWinOdds(csvRecord.getDouble("LBA"));
            odds.setPinnaclehomeWinOdds(csvRecord.getDouble("PSH"));
            odds.setPinnacleDrawOdd(csvRecord.getDouble("PSD"));
            odds.setPinnacleawayWinOdds(csvRecord.getDouble("PSA"));
            odds.setSportingOddsHomeWinOdds(csvRecord.getDouble("SOH"));
            odds.setSportingOddsDrawOdds(csvRecord.getDouble("SOD"));
            odds.setSportingOddsAwayWinOdds(csvRecord.getDouble("SOA"));
            odds.setSportingbethomeWinOdds(csvRecord.getDouble("SBH"));
            odds.setSportingbetDrawOdd(csvRecord.getDouble("SBD"));
            odds.setSportingbetawayWinOdds(csvRecord.getDouble("SBA"));
            odds.setStanJamesHomeWinOdds(csvRecord.getDouble("SJH"));
            odds.setStanJamesDrawOdds(csvRecord.getDouble("SJD"));
            odds.setStanJamesAwayWinOdds(csvRecord.getDouble("SJA"));
            odds.setStanleybethomeWinOdds(csvRecord.getDouble("SYH"));
            odds.setStanleybetDrawOdd(csvRecord.getDouble("SYD"));
            odds.setStanleybetawayWinOdds(csvRecord.getDouble("SYA"));
            odds.setVCBetHomeWinOdds(csvRecord.getDouble("VCH"));
            odds.setVCBetDrawOdds(csvRecord.getDouble("VCD"));
            odds.setVCBetAwayWinOdds(csvRecord.getDouble("VCA"));
            odds.setWilliamHillHomeWinOdds(csvRecord.getDouble("WHH"));
            odds.setWilliamHillDrawOdds(csvRecord.getDouble("WHD"));
            odds.setWilliamHillAwayWinOdds(csvRecord.getDouble("WHA"));
            odds.setNumberBetBrainBookmakersToCalculate(csvRecord.getDouble("Bb1X2"));
            odds.setBetbrainAverageHomeWinOdds(csvRecord.getDouble("BbAvH"));
            odds.setBetbrainMaximumDrawOdds(csvRecord.getDouble("BbMxD"));
            odds.setBetbrainAverageDrawWinOdds(csvRecord.getDouble("BbAvD"));
            odds.setBetbrainMaximumAwayWinOdds(csvRecord.getDouble("BbMxA"));
            odds.setBetbrainAverageAwayWinOdds(csvRecord.getDouble("BbAvA"));

            odds.setBetbrainMaximumOver25Goals(csvRecord.getDouble("BbMx>2.5"));
            odds.setBetbrainAverageOver25Goals(csvRecord.getDouble("BbAv>2.5"));
            odds.setBetbrainMaximumUnder25Goals(csvRecord.getDouble("BbMx<2.5"));
            odds.setBetbrainAverageUnder25Goals(csvRecord.getDouble("BbAv<2.5"));

            odds.setGamebookersOver25Goals(csvRecord.getDouble("BbMx>2.5"));
            odds.setGamebookersUnder25Goals(csvRecord.getDouble("BbAv>2.5"));
            odds.setBet365Over25Goals(csvRecord.getDouble("BbMx<2.5"));
            odds.setBet365Under25Goals(csvRecord.getDouble("BbAv<2.5"));

            odds.setBetbrainMaximumAsianHandicapHomeTeamOdds(csvRecord.getDouble("BbMxAHH"));
            odds.setBetbrainAverageAsianHandicapHomeTeamOdds(csvRecord.getDouble("BbAvAHH"));
            odds.setBetbrainMaximumAsianHandicapAwayTeamOdds(csvRecord.getDouble("BbMxAHA"));
            odds.setBetbrainAverageAsianHandicapAwayTeamOdds(csvRecord.getDouble("BbAvAHA"));
            odds.setGamebookersAsianHandicapHomeTeamOdds(csvRecord.getDouble("GBAHH"));
            odds.setGamebookersAsianHandicapAwayTeamOdds(csvRecord.getDouble("GBAHA"));
            odds.setGamebookersSizeOfHandicapHomeTeam(csvRecord.getDouble("GBAH"));
            odds.setLadbrokesAsianHandicapHomeTeamOdds(csvRecord.getDouble("LBAHH"));
            odds.setLadbrokesAsianHandicapAwayTeamOdds(csvRecord.getDouble("LBAHA"));
            odds.setLadbrokesSizeOfHandicapHomeTeam(csvRecord.getDouble("LBAH"));
            odds.setBet365AsianHandicapHomeTeamOdds(csvRecord.getDouble("B365AHH"));
            odds.setBet365AsianHandicapAwayTeamOdds(csvRecord.getDouble("B365AHA"));
            odds.setBet365SizeOfHandicapHomeTeam(csvRecord.getDouble("B365AH"));
            odds.setPinnacleAsianHandicapHomeTeamOdds(csvRecord.getDouble("PAHH"));
            odds.setPinnacleAsianHandicapAwayTeamOdds(csvRecord.getDouble("PAHA"));
            odds.setMarketMaximumAsianHandicapHomeTeamOdds(csvRecord.getDouble("MaxAHH"));
            odds.setMarketMaximumAsianHandicapAwayTeamOdds(csvRecord.getDouble("MaxAHA"));
            odds.setMarketAverageAsianHandicapHomeTeamOdds(csvRecord.getDouble("AvgAHH"));
            odds.setMarketAverageAsianHandicapAwayTeamOdds(csvRecord.getDouble("AvgAHA"));

            record.setOdds(odds);
        } catch (final IllegalArgumentException ex) {
            LOGGER.info("Cannot find field", ex);
        }
        return record;
    }


}
