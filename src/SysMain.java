
/**
 * Write a description of class SysMain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SysMain
{
    private Pass pass;
    private Parser parser;
   
    /**
     * Initialise.
     */
    public SysMain()
    {
        pass = new Pass();
        parser = new Parser();
    }
    
    /**
     *  Main start routine.  Loops until end of system.
     */
    public void start() 
    {            
        System.out.println(pass.welcome());
        System.out.println(getHelp());
                
        while (! pass.finished()) {
            Command command = parser.getCommand();
            System.out.println(command.process(this, pass));
        }
    }
    
    /**
     * Main method; used if the system is standalone
     */
    public static void main(String[] args)
    {
        SysMain ui = new SysMain();
        ui.start();
    }
    
    /**
     * Tell user how to obtain help.
     */
    public String getHelp()
    {
        return "Type '" + parser.help() + "' if you need help.";
    }
    
    /**
     * Tell player available commands.
     */
    public String getCommands()
    {
        return "Your commands are: " + parser.commands();
    }
}
