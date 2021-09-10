import java.util.Scanner;
/**
 * @author Arman Hatami
 * @version 1.0
 * input class to get all types of input we want in 1 place
 */
public class Input {
    Error error;
    public String getInput(){
        Scanner input  = new Scanner(System.in);
        String command = input.nextLine();
        return command;
    }
    public int getInteger(){
        Scanner input  = new Scanner(System.in);
        int command = input.nextInt();
        return command;
    }
}
