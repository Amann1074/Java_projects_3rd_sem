
# Java Lab Assignment 6 - Duck Simulation

## Description

This project is a Java implementation of the **Duck Simulation** using the **Strategy Design Pattern**. Different types of ducks exhibit different behaviors such as quacking, swimming, and flying. The implementation separates behaviors into interfaces, allowing for flexibility in modifying or extending duck behaviors dynamically.

## Features

- **Duck Types:**
  - `MallardDuck`
  - `RedHeadDuck`
  - `RubberDuck`
  - `DecoyDuck`
  
- **Behaviors Implemented:**
  - **Quacking:** `Quack`, `MuteQuack`, `Squeak`
  - **Swimming:** `SwimWithLegs`, `Floating`, `Drown`
  - **Flying:** `FlyWithWings`, `FlyNoWay`
  
- **Design Pattern Used:** Strategy Pattern  
  - Behaviors are defined in separate interfaces (`QuackBehaviour`, `SwimBehaviour`, `FlyBehaviour`).
  - Ducks can dynamically change their behaviors using setter methods.

## Code Structure

- `Main.java`: Entry point of the program, creates duck instances and displays their behaviors.
- `Duck.java`: Abstract class representing a duck with behavior attributes.
- **Behavior Interfaces:**
  - `QuackBehaviour.java`
  - `SwimBehaviour.java`
  - `FlyBehaviour.java`
- **Concrete Behavior Implementations:**
  - `Quack.java`, `MuteQuack.java`, `Squeak.java`
  - `SwimWithLegs.java`, `Floating.java`, `Drown.java`
  - `FlyWithWings.java`, `FlyNoWay.java`
- **Duck Implementations:**
  - `MallardDuck.java`
  - `RedHeadDuck.java`
  - `RubberDuck.java`
  - `DecoyDuck.java`


## Expected Output

```
I am a Mallard Duck
Quack Quack!
I believe I can swim
I can fly with wings!

I am a Red Head Duck
Quack Quack!
I believe I can swim
I can fly with wings!

I am a Rubber Duck
Squeak!
I can float on water!
I can't fly.

I am a Decoy Duck
...
Drowning!!!!
I can't fly.
```

## Author

**Amannyu Gondkar**  
PRN: 23070126011  
Batch: AIML(A-1)  
Subject: Java Lab Assignment 6  

