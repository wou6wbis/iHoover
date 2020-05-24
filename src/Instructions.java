import java.util.ArrayList;
import java.util.Scanner;

public class Instructions {
    public enum command {A, R, L}; // A to move forward, R to move right and L to move left
    private ArrayList<command> commands = new ArrayList<>(); // List of commands from the user

    public Instructions() {};

    public Instructions(ArrayList<command> commands) {
        this.commands = commands;
    }

    // Get the commands from the user to move the hoover
    public void readCommands() {
        boolean control;
        do {
            control = false;
            System.out.print("Please enter the directions for the hoover : ");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine().toUpperCase();
            if (!inputString.matches("[A,D,G]*")) {
                System.err.println("Please choose a direction from : A, D or G !");
            }
            else {
                this.commands = new ArrayList<>();
                for (char c : inputString.toCharArray()) {
                    if (c == 'A')
                        commands.add(command.A);
                    else if (c == 'D')
                        commands.add(command.R);
                    else if (c == 'G')
                        commands.add(command.L);
                }
                control = true;
            }

        } while (!control);
    }

    // Move the hoover according to the list of commands given by the user
    public void execute(Hoover hoover, Grid grid){
        boolean success = false;
        if (this.commands.isEmpty())
            System.err.println("List of commands is empty !");
        else {
            for (Instructions.command command : this.commands){
                success = hoover.move(command, grid);
                if (!success){
                   break;
                }
            }
            if (success)
                System.out.println("X = " + hoover.getPosition_x()+ "\n" + "Y = " + hoover.getPosition_y() + "\n" + "Orientation = " + hoover.getOrientation());
        }
    }
}
