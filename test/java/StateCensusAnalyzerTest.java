import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyzerTest {

    private static final String INDIA_STATE_CSV_FILEPATH = "./src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenIndiaCensusCSVFileShouldReturnCorrectRecords() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        int numOfRecords = stateCensusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_FILEPATH);
        System.out.println(numOfRecords);
        Assertions.assertEquals(29,numOfRecords);
    }
}
