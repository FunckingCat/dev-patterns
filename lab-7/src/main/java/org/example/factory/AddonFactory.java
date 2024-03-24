package org.example.factory;

import org.example.behavior.Beverage;
import org.example.decorator.MilkDecorator;
import org.example.decorator.SugarDecorator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AddonFactory {

    public enum Addons {
        NONE, MILK, SUGAR;
    }

    public static Beverage addAddons(Beverage beverage, Scanner keyboard) {

        System.out.println("ADD ADDONS");

        int input;

        do {
            List<String> output = Arrays.stream(Addons.values())
                    .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                    .toList();
            System.out.println(String.join(" ", output));
            input = keyboard.nextInt();
            beverage = switch (input) {
                case 0 -> beverage;
                case 1 -> new MilkDecorator(beverage);
                case 2 -> new SugarDecorator(beverage);
                default -> throw new IllegalStateException("Unexpected value: " + input);
            };
        } while (input != 0);

        return beverage;
    }

}
