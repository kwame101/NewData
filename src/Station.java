import java.util.List;
import java.util.Arrays;

/**
 * Enumeration class Station - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Station
{
    FIFTHTH("5th", 1),
    PELHAM_PARKWAY("Pelham Parkway", 1, 2), 
    BRONX("Bronx", 3),
    GUNS_HILL("Guns Hill", 2);
    
    private String station;
    private final List<Integer> zones;
    
    private Station(String station,Integer ...zones)
    {
        this.station = station;
        this.zones = Arrays.asList(zones);
    }

    public String getStation()
    {
        return station;
    }
    
    public List<Integer> getZones()
    {
        return zones;
    }
}
