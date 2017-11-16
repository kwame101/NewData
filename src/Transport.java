
/**
 * Enumeration class Transport - write a description of the enum class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum Transport
{
    SUBWAY("subway"),
    BUS("bus");
    
    private String transport;
    
    private Transport(String transport)
    {
        this.transport = transport;
    }
    
    public String getTransport()
    {
        return transport;
    }
}
