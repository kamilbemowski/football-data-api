package pl.bemowski.football.data.api.mapper;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import pl.bemowski.football.data.api.mapper.csv.CSVRecord;
import pl.bemowski.football.data.api.model.FullTimeResult;
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
            record.setFullTimeResult(FullTimeResult.valueOf(csvRecord.getString("FTR")));
        } catch (IllegalArgumentException ex) {
            LOGGER.info("Cannot find field", ex);
        }
        /**
         * FTR = Full Time Result (H=Home Win, D=Draw, A=Away Win)
         * HTHG = Half Time Home Team Goals
         * HTAG = Half Time Away Team Goals
         * HTR = Half Time Result (H=Home Win, D=Draw, A=Away Win)
         * 
         * Match Statistics (where available) Attendance = Crowd Attendance Referee = Match Referee HS = Home Team Shots AS = Away Team
         * Shots HST = Home Team Shots on Target AST = Away Team Shots on Target HHW = Home Team Hit Woodwork AHW = Away Team Hit Woodwork
         * HC = Home Team Corners AC = Away Team Corners HF = Home Team Fouls Committed AF = Away Team Fouls Committed HO = Home Team
         * Offsides AO = Away Team Offsides HY = Home Team Yellow Cards AY = Away Team Yellow Cards HR = Home Team Red Cards AR = Away Team
         * Red Cards HBP = Home Team Bookings Points (10 = yellow, 25 = red) ABP = Away Team Bookings Points (10 = yellow, 25 = red)
         * 
         * Key to 1X2 (match) betting odds data:
         * 
         * B365H = Bet365 home win odds B365D = Bet365 draw odds B365A = Bet365 away win odds BSH = Blue Square home win odds BSD = Blue
         * Square draw odds BSA = Blue Square away win odds BWH = Bet&Win home win odds BWD = Bet&Win draw odds BWA = Bet&Win away win odds
         * GBH = Gamebookers home win odds GBD = Gamebookers draw odds GBA = Gamebookers away win odds IWH = Interwetten home win odds IWD =
         * Interwetten draw odds IWA = Interwetten away win odds LBH = Ladbrokes home win odds LBD = Ladbrokes draw odds LBA = Ladbrokes
         * away win odds PSH = Pinnacle home win odds PSD = Pinnacle draw odds PSA = Pinnacle away win odds SOH = Sporting Odds home win
         * odds SOD = Sporting Odds draw odds SOA = Sporting Odds away win odds SBH = Sportingbet home win odds SBD = Sportingbet draw odds
         * SBA = Sportingbet away win odds SJH = Stan James home win odds SJD = Stan James draw odds SJA = Stan James away win odds SYH =
         * Stanleybet home win odds SYD = Stanleybet draw odds SYA = Stanleybet away win odds VCH = VC Bet home win odds VCD = VC Bet draw
         * odds VCA = VC Bet away win odds WHH = William Hill home win odds WHD = William Hill draw odds WHA = William Hill away win odds
         * 
         * Bb1X2 = Number of BetBrain bookmakers used to calculate match odds averages and maximums BbMxH = Betbrain maximum home win odds
         * BbAvH = Betbrain average home win odds BbMxD = Betbrain maximum draw odds BbAvD = Betbrain average draw win odds BbMxA = Betbrain
         * maximum away win odds BbAvA = Betbrain average away win odds
         * 
         * 
         * 
         * Key to total goals betting odds:
         * 
         * BbOU = Number of BetBrain bookmakers used to calculate over/under 2.5 goals (total goals) averages and maximums BbMx>2.5 =
         * Betbrain maximum over 2.5 goals BbAv>2.5 = Betbrain average over 2.5 goals BbMx<2.5 = Betbrain maximum under 2.5 goals BbAv<2.5 =
         * Betbrain average under 2.5 goals
         * 
         * GB>2.5 = Gamebookers over 2.5 goals GB<2.5 = Gamebookers under 2.5 goals B365>2.5 = Bet365 over 2.5 goals B365<2.5 = Bet365 under
         * 2.5 goals
         * 
         * 
         * Key to Asian handicap betting odds:
         * 
         * BbAH = Number of BetBrain bookmakers used to Asian handicap averages and maximums BbAHh = Betbrain size of handicap (home team)
         * BbMxAHH = Betbrain maximum Asian handicap home team odds BbAvAHH = Betbrain average Asian handicap home team odds BbMxAHA =
         * Betbrain maximum Asian handicap away team odds BbAvAHA = Betbrain average Asian handicap away team odds
         * 
         * GBAHH = Gamebookers Asian handicap home team odds GBAHA = Gamebookers Asian handicap away team odds GBAH = Gamebookers size of
         * handicap (home team) LBAHH = Ladbrokes Asian handicap home team odds LBAHA = Ladbrokes Asian handicap away team odds LBAH =
         * Ladbrokes size of handicap (home team) B365AHH = Bet365 Asian handicap home team odds B365AHA = Bet365 Asian handicap away team
         * odds B365AH = Bet365 size of handicap (home team)
         * 
         * 
         * Closing odds (last odds before match starts)
         * 
         * PSCH = Pinnacle closing home win odds PSCD = Pinnacle closing draw odds PSCA = Pinnacle closing away win odds
         */
        return record;
    }
}
