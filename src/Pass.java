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
            switch(station1.getStation()){
                //case of 5th
                case "5th" : if(station2.getStation().equals("Pelham Parkway")){
                    fare = Fares.valueOf("ANYWHERE_IN_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Bronx")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Guns Hill")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                //case of pelham parkway
                case "Pelham Parkway": if(station2.getStation().equals("5th")){
                    fare = Fares.valueOf("ANYWHERE_IN_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Bronx")){
                    fare = Fares.valueOf("ANY_THREE_ZONES");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Guns Hill")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                //case of bronx
                case "Bronx" : if(station2.getStation().equals("5th")){
                    fare = Fares.valueOf("ANYWHERE_IN_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Pelham Parkway")){
                    fare = Fares.valueOf("ANY_THREE_ZONES");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Guns Hill")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_EXC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                ///case of guns hill
                case "Guns Hill" :if(station2.getStation().equals("5th")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Pelham Parkway")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_INC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                else if(station2.getStation().equals("Bronx")){
                    fare = Fares.valueOf("ANY_TWO_ZONES_EXC_ZONE_ONE");
                    return calculateFare(fare,station1,station2);
                }
                default: return msg;
            }
        }
        return msg;
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
