
/**
 * Write a description of class Quit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Quit extends Command
{
   /**
     * Just tells the system to quit.
     * Pre-condition: system must not be null.
     */
    public String process(SysMain ui, Pass sys)
    {
        assert sys != null;
        return sys.quit();
    }
}
