/**
 * Enumeration class Station - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Station
{
    FIFTHTH("5th"),
    PELHAM_PARKWAY("Pelham Parkway"), 
    BRONX("Bronx"),
    GUNS_HILL("Guns Hill");
    
    private String station;
    
    private Station(String station)
    {
        this.station = station;
    }

    public String getStation()
    {
        return station;
    }
    
}
