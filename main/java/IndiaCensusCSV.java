import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {

    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population")
    public int population;

    @CsvBindByName(column = "AreaInSqKm")
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm")
    public int densityPerSqKm;

    public IndiaCensusCSV() {
    }

    @Override
    public String toString() {
        return "IndiaCensusCSV{" + "State='" + state + '\'' + ", Population='" + population + '\'' + ", AreaInSqKm='"
                + areaInSqKm + '\'' + ", DensityPerSqKm='" + densityPerSqKm + '\'' + '}';
    }
}