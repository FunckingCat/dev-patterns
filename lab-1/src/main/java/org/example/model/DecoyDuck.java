package org.example.model;

import org.example.behaviour.Flyable;
import org.example.behaviour.Qakable;

public class DecoyDuck extends AbstractDuck implements Flyable, Qakable {

    public DecoyDuck() {
        super("Приманка", "Я не летаю", "Я крякаю громко");
    }

    @Override
    public void fly() {
        System.out.printf("%s: %s\n", name, flyPhraze);
    }

    @Override
    public void quak() {
        System.out.printf("%s: %s\n", name, quakPhraze);
    }

}
