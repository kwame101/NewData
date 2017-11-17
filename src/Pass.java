import java.util.List;
/**
 * Write a description of class System here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pass
{
    private boolean finished;
    private double balance;
    private Fares fare;

    /**
     * Constructor for objects of class Pass
     */
    public Pass()
    {
        finished = false;
        balance = 30.00;
    }

    public String transit(Transport transport, Station station1, Station station2)
    {
        assert transport != null : "Pass.transit gets null transport";
        assert station1 != null : "Pass.transit gets null station1";
        assert station2 != null : "Pass.transit gets null station2";
        String msg = null;
        String trans = transport.getTransport();
        switch(trans){
            case "subway" : msg = subwayTransit(station1, station2);
            break;
            case "bus" : msg = busTransit(station1, station2);
            break;
        }
        return msg;
    }

    public String busTransit(Station station1, Station station2)
    {
        String msg = null;
        if(station1.getStation().equals(station2.getStation())){
            msg ="You can't transit to same station, please try again. \n";
        }
        else {    
            fare = Fares.valueOf("ANY_BUS_RIDE");
            return calculateFare(fare,station1,station2);
        }
        return msg;
    }

    public String subwayTransit(Station station1, Station station2)
    {
        String msg = null;
        if(station1.getStation().equals(station2.getStation())){
            msg ="You can't transit to same station, please try again. \n";
        }
        else { 
            fare = checkZoneFare(station1, station2);
            msg = calculateFare(fare,station1,station2);
        }
        return msg;
    }

    public Fares checkZoneFare(Station station1,Station station2){
        List<Integer> checkZones1 = station1.getZones();
        List<Integer> checkZones2 = station2.getZones();
        //anywhere in zone 1
        if(checkZones1.contains(1) && checkZones2.contains(1) || checkZones1.contains(1) && 
        checkZones1.size() > 1 && checkZones2.contains(1)){
            return Fares.valueOf("ANYWHERE_IN_ZONE_ONE");
        }
        //any one zone outside zone 1
        else if(checkZones1.containsAll(checkZones2) && checkZones2.size() == 1 &&
        !checkZones2.contains(1)){
            return Fares.valueOf("ONE_ZONE_OUTSIDE_ZONE_ONE");
        }
        //any two zones including zone 1
        else if(checkZones2.contains(1) && !checkZones1.contains(1)){
            return Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
        }
        //any two zones excluding zone 1
        else if(!checkZones1.contains(1) && !checkZones2.contains(1)){
            return Fares.valueOf("ANY_TWO_ZONES_EXC_ZONE_ONE");
        }
        //any three zones
        else if(!checkZones1.containsAll(checkZones2) && checkZones2.size() >=2){
            return Fares.valueOf("ANY_THREE_ZONES");
        }
        return null;
    }

    public String calculateFare(Fares fare, Station station1, Station station2)
    {
        String msg = null;
        if(balance >= fare.getFare()){
            balance = balance - fare.getFare();
            msg = "You are transiting from " + station1.getStation() + " to " + 
            station2.getStation() + " on a bus.";
        }
        else {
            msg = "You don't enough balance in your subway pass.";
        }
        return msg;
    }

    /**
     * Return whether the system has finished or not.
     */
    public boolean finished()
    {
        return finished;
    }

    /**
     * Opening message for the user.
     */
    public String welcome()
    {
        return "\nWelcome to the Subway Pass Problem!\n" +
        "A simple ticket system which allows user to travel from point A to B.\n";
    }

    /**
     * Return the user's balance
     */
    public String balance()
    {
        return "Your current balance: $"+balance;
    }

    /**
     * Give some help information.
     */
    public String help() 
    {
        return "Assume you are at a station getting a transport; follow instructions below.\n";
    }

    /**
     * Execute quit command.
     */
    public String quit()
    {
        finished = true;
        return "System shutting down... bye.";
    }
}
