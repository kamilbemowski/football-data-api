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
            record.setRefree(csvRecord.getString("Refreee"));
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
            /*/*
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
         * GBAHH = Gamebookers Asian handicap home team odds
         * GBAHA = Gamebookers Asian handicap away team odds
         * GBAH = Gamebookers size of handicap (home team)
         * LBAHH = Ladbrokes Asian handicap home team odds
         * LBAHA = Ladbrokes Asian handicap away team odds
         * LBAH = Ladbrokes size of handicap (home team)
         * B365AHH = Bet365 Asian handicap home team odds
         * B365AHA = Bet365 Asian handicap away team odds
         * B365AH = Bet365 size of handicap (home team)
         * PAHH = Pinnacle Asian handicap home team odds
         * PAHA = Pinnacle Asian handicap away team odds
         * MaxAHH = Market maximum Asian handicap home team odds
         * MaxAHA = Market maximum Asian handicap away team odds
         * AvgAHH = Market average Asian handicap home team odds
         * AvgAHA = Market average Asian handicap away team odds
         *
         * Closing odds (last odds before match starts)
         *
         * PSCH = Pinnacle closing home win odds
         * PSCD = Pinnacle closing draw odds
         * PSCA = Pinnacle closing away win odds
         */
            record.setOdds(odds);
        } catch (final IllegalArgumentException ex) {
            LOGGER.info("Cannot find field", ex);
        }
        return record;
    }

    public static void main(String[] args) {
        String s = "Betbrain maximum Asian handicap home team odds\n" +
                "Betbrain average Asian handicap home team odds\n" +
                "Betbrain maximum Asian handicap away team odds\n" +
                "Betbrain average Asian handicap away team odds\n" +
                "Gamebookers Asian handicap home team odds\n" +
                "Gamebookers Asian handicap away team odds\n" +
                "Gamebookers size of handicap (home team)\n" +
                "Ladbrokes Asian handicap home team odds\n" +
                "Ladbrokes Asian handicap away team odds\n" +
                "Ladbrokes size of handicap (home team)\n" +
                "Bet365 Asian handicap home team odds\n" +
                "Bet365 Asian handicap away team odds\n" +
                "Bet365 size of handicap (home team)\n" +
                "Pinnacle Asian handicap home team odds\n" +
                "Pinnacle Asian handicap away team odds\n" +
                "Market maximum Asian handicap home team odds\n" +
                "Market maximum Asian handicap away team odds\n" +
                "Market average Asian handicap home team odds\n" +
                "Market average Asian handicap away team odds";
        String[] lines = s.split("\n");
        Arrays.stream(lines)
                .map(cc -> cc.replace("(", ""))
                .map(cc -> cc.replace(")", ""))
                .map(WordUtils::capitalizeFully)
                .map(cc -> cc.replace(" ", ""))
                .map(cc -> cc.replace(".", ""))
                .map(cc -> "odds.set" + cc + "(csvRecord.getDouble(\"\"));")
                .forEach(System.out::println);
        System.out.println("");
        Arrays.stream(lines)
                .map(cc -> cc.replace("(", ""))
                .map(cc -> cc.replace(")", ""))
                .map(WordUtils::capitalizeFully)
                .map(cc -> cc.replace(" ", ""))
                .map(cc -> cc.replace(".", ""))
                .map(cc -> {
                    char[] chars = cc.toCharArray();
                    chars[0] += 32;
                    return new String(chars);
                })
                .map(cc -> "private Double " + cc + ";")
                .forEach(System.out::println);

    }
}
