public class U1 extends Rocket {


    public  U1(){
        super(100000,10,18);
    }
   @Override
    public boolean launch() {
        double explosion = 0.05 * cargoWeight/maxWeight;
      return  Math.random() > explosion;
    }
    @Override
    public boolean land(){
        double crash = 0.01 * cargoWeight/maxWeight;
        return Math.random() >  crash;
    }

    @Override
    public int getCost() {
        return 60;
    }

}
