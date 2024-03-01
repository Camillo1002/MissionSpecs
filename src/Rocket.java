public class Rocket implements SpaceShip {
    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return true;
    }


    public int carry(Item item) {
        return 0;
    }

}
