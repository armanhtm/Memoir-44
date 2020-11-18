import java.util.Scanner;

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
