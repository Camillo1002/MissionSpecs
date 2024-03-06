public class Rocket implements SpaceShip {
    protected int cost;

    protected double cargoWeight;
    protected int maxWeight;

    public Rocket(int cost, double cargoWeight, int maxWeight) {
        this.cost = cost;
        this.cargoWeight = cargoWeight;
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean launch()
    {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item)
    {
        return (cargoWeight + item.weight) <= maxWeight;
    }

    public int carry(Item item) {
        cargoWeight = cargoWeight + item.weight;
        return (int) cargoWeight;
    }

    public int getCost() {
        return cost;
    }


}
