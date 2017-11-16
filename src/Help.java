
/**
 * Write a description of class Help here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Help extends Command
{
    /**
     * Return help information.
     * Pre-condition: both ui and sys are not null;
     */
    public String process(SysMain ui, Pass sys)
    {
        assert ui != null : "Help.process gets null ui";
        assert sys != null : "Help.process gets null sys";
        return sys.help() + ui.getCommands();
    }
}
