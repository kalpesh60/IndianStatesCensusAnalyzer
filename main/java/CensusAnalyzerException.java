public class CensusAnalyzerException extends Exception{

    enum CensusExceptionType{
        NO_SUCH_FILE, WRONG_TYPE, WRONG_DELEMETER_HEADER,
    }
    CensusExceptionType type;

    public CensusAnalyzerException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}