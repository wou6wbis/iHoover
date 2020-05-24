import java.util.Scanner;

// The grid representing the surface the hoover is going to sweep
public class Grid {
    private int dimension_x;
    private int dimension_y;

    public Grid(){}

    public Grid(int dimension_x, int dimension_y) {
        this.dimension_x = dimension_x;
        this.dimension_y = dimension_y;
    }

    // Create the grid from the dimensions given by the user
    public void createGrid() {
        Grid grid = new Grid();
        Scanner scanner = new Scanner(System.in);
        String inputString;
        boolean control = false;
        while (!control) {
            try {
                System.out.print("Please enter the grid dimension X : ");
                inputString = scanner.nextLine();
                int dimension_x = Integer.parseUnsignedInt(inputString);
                if (dimension_x == 0)
                    throw new NumberFormatException();

                System.out.print("Please enter the grid dimension Y : ");
                inputString = scanner.nextLine();
                int dimension_y = Integer.parseUnsignedInt(inputString);
                if (dimension_y == 0)
                    throw new NumberFormatException();


                this.setDimension_x(dimension_x);
                this.setDimension_y(dimension_y);

                control = true;

            } catch (NumberFormatException ex) {
                System.err.println("Please enter a valid number ! \n");
            }
        }
    }

    public int getDimension_x() {
        return dimension_x;
    }

    public int getDimension_y() {
        return dimension_y;
    }

    public void setDimension_x(int dimension_x) {
        this.dimension_x = dimension_x;
    }

    public void setDimension_y(int dimension_y) {
        this.dimension_y = dimension_y;
    }
}

