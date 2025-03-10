public class RedHeadDuck extends Duck { public RedHeadDuck() { quackBehaviour = new Quack(); swimBehaviour = new SwimWithLegs(); flyBehavior = new FlyWithWings();
}
@Override
public void display() { System.out.println("I'm a red head duck");
}
}
