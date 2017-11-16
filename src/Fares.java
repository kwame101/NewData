/**
 * Enumeration class FARES - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Fares
{
    ANYWHERE_IN_ZONE_ONE("Anywhere in zone 1", 2.50),
    ONE_ZONE_OUTSIDE_ZONE_ONE("One zone outside zone 1", 2.00),
    ANY_TWO_ZONES_INC_ZONE_ONE("Any two zones inc zone 1", 3.00),
    ANY_TWO_ZONES_EXC_ZONE_ONE("Any two zones exc zone 1", 2.25),
    ANY_THREE_ZONES("Any three zones", 3.20),
    ANY_BUS_RIDE("Any bus ride", 1.80);
    
    private String journey;
    private double fare;
    
    private Fares(String journey, double fare)
    {
        this.journey = journey;
        this.fare = fare;
    }
    
    public String getJourney()
    {
        return journey;
    }
    
    public double getFare()
    {
        return fare;
    }
}
