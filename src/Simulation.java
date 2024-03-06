import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Simulation {

    //do testów - wypisanie tekstu z pliku
    public boolean printFile() {
        File file = new File("items.txt");
        try {
            ArrayList<Item> items = loadItems(file);
            for (Item item : items) {
                System.out.println("Item name: " + item.name + ", weight: " + item.weight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList items = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {

            //czy kolejna linijak texstu
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] part = line.split("=");

                Item item = new Item();
                item.name = part[0];
                item.weight = Integer.parseInt(part[1]);

                items.add(item);

            }
        }
        return items;
    }
    //TODO potecjalny problem
    public ArrayList<Rocket> loadU1(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while (!items.isEmpty()) {
            U1 u1Rocket = new U1();
            boolean itemLoaded = loadRocket(u1Rocket, items);
            if (!itemLoaded) {
                break;
            }
            rockets.add(u1Rocket);
        }
        return rockets;
    }
    //TODO potecjalny problem

    public ArrayList<Rocket> loadU2(ArrayList<Item> items) {
        ArrayList<Rocket> rockets = new ArrayList<>();

        while (!items.isEmpty()) {
            U2 u2Rocket = new U2();
            boolean itemLoaded = loadRocket(u2Rocket, items);
            if (!itemLoaded) {
                break;
            }
            rockets.add(u2Rocket);
        }
        return rockets;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {
        int cost = 0;

        for (Rocket rocket : rockets) {
            cost = cost + rocket.getCost();

            while (true) {
                if (rocket.launch() && rocket.land()) {
                    break;
                } else {
                    cost += rocket.getCost();
                }
            }
        }
        return cost;
    }

    private boolean loadRocket(Rocket rocket, ArrayList<Item> items) {
        Iterator<Item> iterator = items.iterator();
        boolean itemLoaded = false;

        while (iterator.hasNext()) {
            Item item = iterator.next();

            if (rocket.canCarry(item)) {
                rocket.carry(item);
                iterator.remove();
                itemLoaded = true;
            }
        }
        return itemLoaded;
    }


}
