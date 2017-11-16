import java.util.Scanner;
/**
 * Write a description of class Parser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Parser
{
    private Scanner reader;         // source of command input

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser() 
    {
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // will hold the full input line
        String word1 = null;
        Transport word3 = null;
        Station str_from = null;
        Station end_at = null;

        System.out.print("\n> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        @SuppressWarnings("resource")
		Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            switch (word1) {
                case "taking" : if(tokenizer.hasNext() && tokenizer.next().toLowerCase().equals("the")){
                    // skip to third word <transport>
                    if(tokenizer.hasNext()) {
                        try {
                            word3 = Transport.valueOf(tokenizer.next().toUpperCase());
                            if(tokenizer.hasNext() && tokenizer.next().toLowerCase().equals("from")){
                                if(tokenizer.hasNext()) {
                                    try{
                                        String mainText = tokenizer.nextLine();
                                        String [] fromTexts = mainText.split("to");
                                        String strText = fromTexts[0];
                                        String atText = fromTexts[1];
                                        switch (strText.trim()) {
                                            case "5th" :  str_from = Station.valueOf("FIFTHTH");
                                            break;
                                            case "pelham parkway" : str_from = Station.valueOf("PELHAM_PARKWAY");
                                            break;
                                            case "bronx" : str_from = Station.valueOf("BRONX");
                                            break;
                                            case "guns hill" : str_from = Station.valueOf("GUNS_HILL");
                                            break;
                                            default : return new Command();
                                        }
                                        switch (atText.trim()) {
                                            case "5th" :  end_at = Station.valueOf("FIFTHTH");
                                            break;
                                            case "pelham parkway" : end_at = Station.valueOf("PELHAM_PARKWAY");
                                            break;
                                            case "bronx" : end_at = Station.valueOf("BRONX");
                                            break;
                                            case "guns hill" : end_at = Station.valueOf("GUNS_HILL");
                                            break;
                                            default : return new Command();
                                        }
                                        return new Taking(word3,str_from,end_at);
                                    }
                                    catch (IllegalArgumentException e) {
                                        return new Command();
                                    }
                                }
                            }
                        }
                        catch (IllegalArgumentException e) {
                            return new Command();
                        }
                    }
                }
                break;
                case "help" : return new Help();
                case "quit" : return new Quit();
                case "balance" : return new Balance();
            }
        } 
        return new Command(); // unknown command
    }

    /**
     * Returns a list of valid commands.
     */
    public String commands()
    {
        return "taking the <transport> from <station> to <station>, help, balance\n" +
        "Only transports allowed: subway and bus \n" +
        "Only stations allowed: 5th, pelham parkway, bronx, guns hill";
    }

    /**
     * Returns name of help command.
     */
    public String help()
    {
        return "help";
    }

    public String balance()
    {
        return "balance";
    }
}
