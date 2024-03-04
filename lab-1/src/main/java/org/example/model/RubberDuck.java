package org.example.model;

import org.example.behaviour.Flyable;
import org.example.behaviour.Qakable;

public class RubberDuck extends AbstractDuck implements Flyable, Qakable {

    public RubberDuck() {
        super("Резиновая", "Я не летаю", "Я не крякаю");
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
