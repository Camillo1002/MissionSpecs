public class U2 extends Rocket {

    public  U2(){
        super(120000,18,29);
    }
    @Override
    public boolean launch() {
        double explosion = 0.04* cargoWeight/maxWeight;
        return  Math.random() > explosion;
    }
    @Override
    public boolean land(){
        double crash = 0.08* cargoWeight/maxWeight;
        return Math.random() >  crash;
    }

    @Override
    public int getCost() {
        return 120;
    }
}
