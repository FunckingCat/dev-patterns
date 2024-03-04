package org.example;

import org.example.model.DecoyDuck;
import org.example.model.RegularDuck;
import org.example.model.RubberDuck;

public class Main {
    public static void main(String[] args) {
        DecoyDuck decoyDuck = new DecoyDuck();
        RubberDuck rubberDuck = new RubberDuck();
        RegularDuck regularDuck = new RegularDuck();

        regularDuck.quak();
        regularDuck.fly();

        rubberDuck.quak();
        rubberDuck.fly();

        decoyDuck.quak();
        decoyDuck.fly();
        decoyDuck.setFlyPhraze("Я летаю на радиоуправлении");

        decoyDuck.fly();

    }
}