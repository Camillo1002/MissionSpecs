import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Simulation simulation = new Simulation();

//        System.out.println(simulation.printFile());



        try {
            File file01 = new File("resources/items.txt");
            File file02 = new File("resources/items2.txt");



            // Load Items for Phase-1 and Phase-2
            ArrayList<Item> phase1Items = simulation.loadItems(file01);
            ArrayList<Item> phase2Items = simulation.loadItems(file02);

            // Load a fleet of U1 rockets for Phase-1 and then for Phase-2
            ArrayList<Rocket> u1Phase1Rockets = simulation.loadU1(phase1Items);
            ArrayList<Rocket> u1Phase2Rockets = simulation.loadU1(phase2Items);

            // Run the simulation using the fleet of U1 rockets and display the total budget required
            int totalBudgetU1 = simulation.runSimulation(u1Phase1Rockets) + simulation.runSimulation(u1Phase2Rockets);
            System.out.println("Total Budget for U1 Rockets: " + totalBudgetU1);

            // Load a fleet of U2 rockets for Phase-1 and then for Phase-2
            ArrayList<Rocket> u2Phase1Rockets = simulation.loadU2(phase1Items);
            ArrayList<Rocket> u2Phase2Rockets = simulation.loadU2(phase2Items);

            // Run the simulation using the fleet of U2 rockets and display the total budget required
            int totalBudgetU2 = simulation.runSimulation(u2Phase1Rockets) + simulation.runSimulation(u2Phase2Rockets);
            System.out.println("Total Budget for U2 Rockets: " + totalBudgetU2);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    }
