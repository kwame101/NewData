
/**
 * Write a description of class Taking here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taking extends Command
{
   private Transport transport;
   private Station station1;
   private Station station2;
   
   /**
     * Initialise the transport and station.
     * Pre-condition: transport is not null.
     * Pre-condition: both stations are not null.
     */
   public Taking(Transport transport, Station station1, Station station2)
   {
      this.transport =  transport;
      this.station1 = station1;
      this.station2 = station2;
   }
   
   /**
     * Taking the correct route.
     * Pre-condition: sys is not null.
     */
    public String process(SysMain ui, Pass sys)
    {
        assert sys != null : "Go.process gets null game";
        return sys.transit(transport,station1,station2);
    }
}
