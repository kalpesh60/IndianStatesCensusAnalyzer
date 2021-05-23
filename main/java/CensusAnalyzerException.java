public class CensusAnalyzerException extends Exception{

    enum CensusExceptionType{
        NO_SUCH_FILE,
    }
    CensusExceptionType type;

    public CensusAnalyzerException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}