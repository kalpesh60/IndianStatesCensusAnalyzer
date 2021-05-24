public class CensusAnalyzerException extends Exception{

    public CensusAnalyzerException(CensusExceptionType buildErrors) {

    }

    enum CensusExceptionType{
        NO_SUCH_FILE, BUILD_ERRORS, WRONG_TYPE,
    }
    CensusExceptionType type;

    public CensusAnalyzerException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}