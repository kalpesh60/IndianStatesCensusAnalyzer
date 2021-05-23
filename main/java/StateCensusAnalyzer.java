import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer {

    public int loadIndiaCensusData(String CsvFilepath)  throws CensusAnalyzerException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CsvFilepath));
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            int namOfEtries = 0;
            while (censusCSVIterator.hasNext()) {
                namOfEtries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
            return namOfEtries;
        } catch (IOException e) {
            throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE,
                    e.getMessage());
        }
    }
}