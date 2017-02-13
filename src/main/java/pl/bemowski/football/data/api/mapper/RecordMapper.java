package pl.bemowski.football.data.api.mapper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import pl.bemowski.football.data.api.mapper.csv.CSVRecord;
import pl.bemowski.football.data.api.model.Record;

/**
 * Created by Kamil Bemowski on 2017-02-13.
 */
@Component
public class RecordMapper {

    private static final Logger LOGGER = Logger.getLogger(RecordMapper.class);

    public Record map(CSVRecord csvRecord) {
        Record record = new Record();
        try {
            record.setDivision(csvRecord.getString("Div"));
            record.setDate(csvRecord.getLocalDate("Date"));
            record.setHomeTeam(csvRecord.getString("HomeTeam"));
            record.setAwayTeam(csvRecord.getString("AwayTeam"));
            record.setFullTimeHomeGoals(csvRecord.getInteger("FTHG"));
            record.setFullTimeAwayGoals(csvRecord.getInteger("FTAG"));
            record.setFullTimeResult(csvRecord.getResult("FTR"));
            record.setHalfTimeHomeGoals(csvRecord.getInteger("HTHG"));
            record.setHalfTimeAwayGoals(csvRecord.getInteger("HTAG"));
            record.setHalfTimeResult(csvRecord.getResult("HTR"));
            record.setAttendance(csvRecord.getString("Attendance"));
            record.setRefree(csvRecord.getString("Refreee"));
            record.setHomeShots(csvRecord.getInteger("HS"));
            record.setAwayShots(csvRecord.getInteger("AS"));
            record.setHomeShotOnTarget(csvRecord.getInteger("HST"));
            record.setAwayShotOnTarget(csvRecord.getInteger("AST"));
            record.setHomeHitWoodwork(csvRecord.getInteger("HHW"));
            record.setAwayHitWoodwork(csvRecord.getInteger("AHW"));
            record.setHomeCorners(csvRecord.getInteger("HC"));
            record.setAwayCorners(csvRecord.getInteger("AC"));
            record.setHomeFoulCommited(csvRecord.getInteger("HF"));
            record.setAwayFoulCommited(csvRecord.getInteger("AF"));
            record.setHomeOffsides(csvRecord.getInteger("HO"));
            record.setAwayOffsides(csvRecord.getInteger("AO"));
            record.setHomeYellowCards(csvRecord.getInteger("HY"));
            record.setAwayYellowCards(csvRecord.getInteger("AY"));
            record.setHomeRedCards(csvRecord.getInteger("HR"));
            record.setAwayRedCards(csvRecord.getInteger("AR"));
            record.setHomeBookingPoints(csvRecord.getInteger("HBP"));
            record.setAwayBookingPoints(csvRecord.getInteger("ABP"));
            record.setBet365homeWinOdds(csvRecord.getDouble("B365H"));
            record.setBet365DrawOdd(csvRecord.getDouble("B365D"));
            record.setBet365awayWinOdds(csvRecord.getDouble("B365A"));
            record.setBlueSquareHomeWinOdds(csvRecord.getDouble("BSH"));
            record.setBlueSquareDrawOdds(csvRecord.getDouble("BSD"));
            record.setBlueSquareAwayWinOdds(csvRecord.getDouble("BSA"));
            record.setBeWinHomeWinOdds(csvRecord.getDouble("BWH"));
            record.setBeWinDrawOdds(csvRecord.getDouble("BWD"));
            record.setBeWinAwayWinOdds(csvRecord.getDouble("BWA"));
            record.setGamebookershomeWinOdds(csvRecord.getDouble("GBH"));
            record.setGamebookersDrawOdd(csvRecord.getDouble("GBD"));
            record.setGamebookersawayWinOdds(csvRecord.getDouble("GBA"));
            record.setInterwettenhomeWinOdds(csvRecord.getDouble("IWH"));
            record.setInterwettenDrawOdd(csvRecord.getDouble("IWD"));
            record.setInterwettenawayWinOdds(csvRecord.getDouble("IWA"));
            record.setLadbrokeshomeWinOdds(csvRecord.getDouble("LBH"));
            record.setLadbrokesDrawOdd(csvRecord.getDouble("LBD"));
            record.setLadbrokesawayWinOdds(csvRecord.getDouble("LBA"));
            record.setPinnaclehomeWinOdds(csvRecord.getDouble("PSH"));
            record.setPinnacleDrawOdd(csvRecord.getDouble("PSD"));
            record.setPinnacleawayWinOdds(csvRecord.getDouble("PSA"));
            record.setSportingOddsHomeWinOdds(csvRecord.getDouble("SOH"));
            record.setSportingOddsDrawOdds(csvRecord.getDouble("SOD"));
            record.setSportingOddsAwayWinOdds(csvRecord.getDouble("SOA"));
            record.setSportingbethomeWinOdds(csvRecord.getDouble("SBH"));
            record.setSportingbetDrawOdd(csvRecord.getDouble("SBD"));
            record.setSportingbetawayWinOdds(csvRecord.getDouble("SBA"));
            record.setStanJamesHomeWinOdds(csvRecord.getDouble("SJH"));
            record.setStanJamesDrawOdds(csvRecord.getDouble("SJD"));
            record.setStanJamesAwayWinOdds(csvRecord.getDouble("SJA"));
            record.setStanleybethomeWinOdds(csvRecord.getDouble("SYH"));
            record.setStanleybetDrawOdd(csvRecord.getDouble("SYD"));
            record.setStanleybetawayWinOdds(csvRecord.getDouble("SYA"));
            record.setVCBetHomeWinOdds(csvRecord.getDouble("VCH"));
            record.setVCBetDrawOdds(csvRecord.getDouble("VCD"));
            record.setVCBetAwayWinOdds(csvRecord.getDouble("VCA"));
            record.setWilliamHillHomeWinOdds(csvRecord.getDouble("WHH"));
            record.setWilliamHillDrawOdds(csvRecord.getDouble("WHD"));
            record.setWilliamHillAwayWinOdds(csvRecord.getDouble("WHA"));
        } catch (IllegalArgumentException ex) {
            LOGGER.info("Cannot find field", ex);
        }
        /**
         * Bb1X2 = Number of BetBrain bookmakers used to calculate match odds averages and maximums
         * BbMxH = Betbrain maximum home win odds
         * BbAvH = Betbrain average home win odds
         * BbMxD = Betbrain maximum draw odds
         * BbAvD = Betbrain average draw win odds
         * BbMxA = Betbrain maximum away win odds
         * BbAvA = Betbrain average away win odds
         * 
         * 
         * 
         * Key to total goals betting odds:
         * 
         * BbOU = Number of BetBrain bookmakers used to calculate over/under 2.5 goals (total goals) averages and maximums
         * BbMx>2.5 = Betbrain maximum over 2.5 goals
         * BbAv>2.5 = Betbrain average over 2.5 goals
         * BbMx<2.5 = Betbrain maximum under 2.5 goals
         * BbAv<2.5 = Betbrain average under 2.5 goals
         * 
         * GB>2.5 = Gamebookers over 2.5 goals
         * GB<2.5 = Gamebookers under 2.5 goals
         * B365>2.5 = Bet365 over 2.5 goals
         * B365<2.5 = Bet365 under 2.5 goals
         * 
         * 
         * Key to Asian handicap betting odds:
         * 
         * BbAH = Number of BetBrain bookmakers used to Asian handicap averages and maximums
         * BbAHh = Betbrain size of handicap (home team)
         * BbMxAHH = Betbrain maximum Asian handicap home team odds
         * BbAvAHH = Betbrain average Asian handicap home team odds
         * BbMxAHA = Betbrain maximum Asian handicap away team odds
         * BbAvAHA = Betbrain average Asian handicap away team odds
         * 
         * GBAHH = Gamebookers Asian handicap home team odds
         * GBAHA = Gamebookers Asian handicap away team odds
         * GBAH = Gamebookers size of handicap (home team)
         * LBAHH = Ladbrokes Asian handicap home team odds
         * LBAHA = Ladbrokes Asian handicap away team odds
         * LBAH = Ladbrokes size of handicap (home team)
         * B365AHH = Bet365 Asian handicap home team odds
         * B365AHA = Bet365 Asian handicap away team odds
         * B365AH = Bet365 size of handicap (home team)
         * 
         * 
         * Closing odds (last odds before match starts)
         * 
         * PSCH = Pinnacle closing home win odds
         * PSCD = Pinnacle closing draw odds
         * PSCA = Pinnacle closing away win odds
         */
        return record;
    }
}
