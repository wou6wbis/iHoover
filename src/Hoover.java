import java.util.Scanner;

public class Hoover {

    private enum orientation {N,E,S,W};
    private int position_x;
    private int position_y;
    private orientation orientation;

    public Hoover(){}

    public Hoover(int position_x, int position_y, String orientationHoover) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.orientation = (Hoover.orientation) orientation.valueOf(orientationHoover);
    }

    // Fill in the initial position of the hoover by the user
    public void initiateHoover (Grid grid) {
        int maxPositionX = grid.getDimension_x()-1;
        int maxPositionY = grid.getDimension_y()-1;

        Hoover hoover = new Hoover();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        boolean control = false;
        while (!control) {
            try {
                System.out.print("Please enter the hoover position X : ");
                inputString = scanner.nextLine();
                int position_x = Integer.parseUnsignedInt(inputString);
                if (position_x >maxPositionX)
                    throw new NumberFormatException();

                System.out.print("Please enter the hoover position Y : ");
                inputString = scanner.nextLine();
                int position_y = Integer.parseUnsignedInt(inputString);
                if (position_y >maxPositionY)
                    throw new NumberFormatException();

                System.out.print("Please enter the hoover orientation : ");
                inputString = scanner.nextLine().toUpperCase();
                if (inputString.charAt(0) != 'N' && inputString.charAt(0) != 'E' && inputString.charAt(0) != 'W' && inputString.charAt(0) != 'S')
                    throw new Exception ("Please choose an orientation from : N, E, W or S !");

                this.setPosition_x(position_x);
                this.setPosition_y(position_y);
                this.setOrientation(orientation.valueOf(inputString));

                control = true;

            } catch (NumberFormatException ex) {
                System.err.println("Please enter a valid number !");
            } catch (Exception ex) {
                System.err.println(ex.getMessage());

            }
        }
    }

    // The hoover rotates to the right
    public void rotateToTheRight(){
        if (this.orientation == orientation.N) {
            this.orientation = orientation.E;
        }

        else if (this.orientation == orientation.E) {
            this.orientation = orientation.S;
        }

        else if (this.orientation == orientation.S){
            this.orientation = orientation.W;
        }


        else if (this.orientation == orientation.W){
            this.orientation = orientation.N;
        }
    }

    // The hoover rotates to the left
    public void rotateToTheLeft (){
        if (this.orientation == orientation.N){
            this.orientation = orientation.W;
        }

        else if (this.orientation == orientation.W){
            this.orientation = orientation.S;
        }


        else if (this.orientation == orientation.S){
            this.orientation = orientation.E;
        }


        else if (this.orientation == orientation.E){
            this.orientation = orientation.N;
        }
    }

    // The hoover moves forward, if possible
    public boolean advance (int maxPositionX, int maxPositionY) {

        if (this.orientation == orientation.N){
            if (this.position_y == maxPositionY){
                System.err.println("Invalid position, cannot execute move !");
                return false;
            }
            else {
                this.position_y += 1;
                return true;
            }

        }

        else if (this.orientation == orientation.E){
            if (this.position_x == maxPositionX){
                System.err.println("Invalid position, cannot execute move !");
                return false;
            }
            else {
                this.position_x += 1;
                return true;
            }
        }

        else if (this.orientation == orientation.W){
            if (this.position_x == 0){
                System.err.println("Invalid position, cannot execute move !");
                return false;
            }
            else {
                this.position_x -= 1;
                return true;
            }
        }

        else if (this.orientation == orientation.S){
            if (this.position_y == 0){
                System.err.println("Invalid position, cannot execute move !");
                return false;
            }
            else {
                this.position_y -= 1;
                return true;
            }
        }
        return false;
    }

    public boolean move(Instructions.command command, Grid grid){

        int maxPositionX = grid.getDimension_x()-1;
        int maxPositionY = grid.getDimension_y()-1;

        if (command == command.R){
            rotateToTheRight();
            return true;
        }

        if (command == command.L){
            rotateToTheLeft();
            return true;
        }

        if (command == command.A){
            boolean success = advance(maxPositionX, maxPositionY);
            return success;
        }

        return false;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    public Hoover.orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Hoover.orientation orientation) {
        this.orientation = orientation;
    }


}
