package org.example.model;

import org.example.behaviour.Flyable;
import org.example.behaviour.Qakable;

public class RegularDuck extends AbstractDuck implements Flyable, Qakable {

    public RegularDuck() {
        super("Обычная", "Я летаю на крыльях", "Я крякаю редко");
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
