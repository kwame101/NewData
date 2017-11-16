
/**
 * Write a description of class Balance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balance extends Command
{
    /**
     * Return user's balance information.
     * Pre-condition: both ui and sys are not null;
     */
    public String process(SysMain ui, Pass sys)
    {
        assert ui != null : "Look.process gets null ui";
        assert sys != null : "Look.process gets null pass";
        return sys.balance();
    }
}
