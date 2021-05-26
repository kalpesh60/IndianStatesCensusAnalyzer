import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCodeTest {
    private static final String INDIA_STATE_CODE_CSV_FILEPATH = "./src/main/resources/IndiaStateCode.csv";
    private static final String INCORRECT_FILE = "./src/IndiaStateCensusData.txt";
    private static final String WRONG_FILE_TYPE = "./src/main/resources/IndiaStateCensusData.txt";

    @Test
    public void givenIndiaStateCodeCSVFileShouldReturnCorrectRecords() throws CensusAnalyzerException {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        int numOfRecords = stateCensusAnalyzer.loadIndiaStateCodeData(INDIA_STATE_CODE_CSV_FILEPATH);
        System.out.println(numOfRecords);
        Assertions.assertEquals(37,numOfRecords);
    }

    @Test
    public void givenStateCodeCSVFileIsIncorrectShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        try {
            stateCensusAnalyzer.loadIndiaStateCodeData(INCORRECT_FILE);
        } catch (CensusAnalyzerException e) {
            e.printStackTrace();
            Assertions.assertEquals(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void givenSateCodeCSVFileWhenIncorrectTypeShouldThrowCustomException() {
        StateCensusAnalyzer stateCensusAnalyzer = new StateCensusAnalyzer();
        try {
            stateCensusAnalyzer.loadIndiaStateCodeData(WRONG_FILE_TYPE);
        } catch (CensusAnalyzerException e) {
            Assertions.assertEquals(CensusAnalyzerException.CensusExceptionType.WRONG_TYPE, e.type);
        }
    }
}
