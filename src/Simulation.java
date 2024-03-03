import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    //do testów - wypisanie tekstu z pliku
    public void printFile() {
        File file = new File("items.txt");
        try {
            ArrayList<Item> items = loadItems(file);
            for (Item item : items) {
                System.out.println("Item name: " + item.name + ", weight: " + item.weight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList items = new ArrayList<>();
        Scanner scanner = new Scanner(file);

        //czy kolejna linijak texstu
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] part = line.split("=");

            Item item = new Item();
            item.name = part[0];
            item.weight = Integer.parseInt(part[1]);

            items.add(item);

        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        return rockets;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();
        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        return 0;
    }
}
