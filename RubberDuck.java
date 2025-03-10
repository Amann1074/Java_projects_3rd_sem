public class RubberDuck extends Duck { public RubberDuck() { quackBehaviour = new Squeak(); swimBehaviour = new Floating(); flyBehavior = new FlyNoWay();
}
@Override
public void display() { System.out.println("I am a Rubber Duck");
}
}
