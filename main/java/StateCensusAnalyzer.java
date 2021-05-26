import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyzer {

    public int loadIndiaCensusData(String CsvFilepath)  throws CensusAnalyzerException {
        int numOfEntries = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilepath))) {
            CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
            csvToBeanBuilder.withType(IndiaCensusCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
            numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                IndiaCensusCSV censusData = censusCSVIterator.next();
            }
        } catch (NoSuchFileException e) {
            throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.getMessage());
        } catch (RuntimeException e) {
            throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.WRONG_DELEMETER_HEADER, "incorrect delimeter");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numOfEntries;
    }

    public int loadIndiaStateCodeData(String CsvFilepath) throws CensusAnalyzerException {
        int numOfEntries = 0;
        try (Reader reader = Files.newBufferedReader(Paths.get(CsvFilepath))) {
            CsvToBeanBuilder<IndiaStateCodeCSV> csvToBeanBuilder = new CsvToBeanBuilder<IndiaStateCodeCSV>(reader);
            csvToBeanBuilder.withType(IndiaStateCodeCSV.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndiaStateCodeCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaStateCodeCSV> censusCSVIterator = csvToBean.iterator();
            numOfEntries = 0;
            while (censusCSVIterator.hasNext()) {
                numOfEntries++;
                IndiaStateCodeCSV censusData = censusCSVIterator.next();
            }
        } catch (NoSuchFileException e) {
            throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.NO_SUCH_FILE, e.getMessage());
        } catch (RuntimeException e) {
            throw new CensusAnalyzerException(CensusAnalyzerException.CensusExceptionType.WRONG_DELEMETER_HEADER, "incorrect delimeter");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numOfEntries;
    }
}