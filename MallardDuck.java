public class MallardDuck extends Duck{ public MallardDuck(){ quackBehaviour = new Quack(); swimBehaviour = new SwimWithLegs(); flyBehavior = new FlyWithWings();
}
@Override
public void display(){ System.out.println("I am a Mallard Duck");
}
}
