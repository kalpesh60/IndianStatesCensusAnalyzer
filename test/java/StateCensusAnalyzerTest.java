import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyzerTest {

    private static final String INDIA_STATE_CSV_FILEPATH = "./src/main/resources/IndiaStateCensusData.csv";
    private static final String INCORRECT_FILE = "./src";
    private static final String WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.txt";

    @Test
    public void givenIndiaCensusCSVFileShouldReturnCorrectRecords() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        int numOfRecords = stateCensusAnalyzer.loadIndiaCensusData(INDIA_STATE_CSV_FILEPATH);
        System.out.println(numOfRecords);
        Assertions.assertEquals(29,numOfRecords);
    }

    @Test
    public void givenStateCensusCSVFileIsIncorrectShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        try {
            stateCensusAnalyzer.loadIndiaCensusData(INCORRECT_FILE);
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenSateCensusCSVFileWhenIncorrectTypeShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        try {
            stateCensusAnalyzer.loadIndiaCensusData(WRONG_FILE_TYPE);
        } catch (CensusAnalyzerException e) {
            Assertions.assertEquals(CensusAnalyzerException.CensusExceptionType.WRONG_TYPE, e.type);
        }
    }
}
