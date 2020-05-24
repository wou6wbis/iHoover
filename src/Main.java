public class Main {

    public static void main(String[] args) {
        System.out.println("iHoover application");

        Grid grid = new Grid();
        grid.createGrid();

        Hoover hoover = new Hoover();
        hoover.initiateHoover(grid);

        Instructions instructions = new Instructions();

        instructions.readCommands();

        instructions.execute(hoover, grid);
    }
}
