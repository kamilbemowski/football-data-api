package pl.bemowski.football.data.api.mapper.csv;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by kamil on 13.02.17.
 */
public class CSVRecordTest {
    @Test
    public void testLineWithQuotation() {
        CSVRecord csvRecord = new CSVRecord("1,2,3,\"Test, A\",51,6", new CSVHeader("1,2,3,4,5,6"));
        Assert.assertEquals("Test, A", csvRecord.getString("4"));
        Assert.assertEquals("1", csvRecord.getString("1"));
        Assert.assertEquals("51", csvRecord.getString("5"));
        Assert.assertEquals("6", csvRecord.getString("6"));

    }

    @Test
    public void testEmpty() {
        CSVRecord csvRecord = new CSVRecord("test,,afterEmpty", new CSVHeader("val1,val2,val3"));
        Assert.assertEquals("test", csvRecord.getString("val1"));
        Assert.assertEquals("", csvRecord.getString("val2"));
        Assert.assertEquals("afterEmpty", csvRecord.getString("val3"));

    }

    @Test
    public void testDate() {
        CSVRecord csvRecord = new CSVRecord("11/11/90,10/11/2010,01/01/00,01/01/17", new CSVHeader("date1,date2,date3,date4"));
        Assert.assertEquals(LocalDate.parse("11/11/1990", DateTimeFormatter.ofPattern("dd/MM/yyyy")), csvRecord.getLocalDate("date1"));
        Assert.assertEquals(LocalDate.parse("10/11/2010", DateTimeFormatter.ofPattern("dd/MM/yyyy")), csvRecord.getLocalDate("date2"));
        Assert.assertEquals(LocalDate.parse("01/01/2000", DateTimeFormatter.ofPattern("dd/MM/yyyy")), csvRecord.getLocalDate("date3"));
        Assert.assertEquals(LocalDate.parse("01/01/2017", DateTimeFormatter.ofPattern("dd/MM/yyyy")), csvRecord.getLocalDate("date4"));
    }

}