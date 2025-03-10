
public class DecoyDuck extends Duck { public DecoyDuck() {
quackBehaviour = (QuackBehaviour) new MuteQuack(); swimBehaviour = new Drown();
flyBehavior = new FlyNoWay();
}
@Override
public void display() { System.out.println("I am a Decoy Duck");
