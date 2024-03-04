package org.example;

import org.example.behavior.Beverage;
import org.example.model.Coffee;
import org.example.model.MilkDecorator;
import org.example.model.SugarDecorator;
import org.example.model.Tea;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("[0] Tea\n[1] Coffee");
        int input = keyboard.nextInt();

        Beverage beverage = switch (input) {
            case 0 ->  new Tea();
            case 1-> new Coffee();
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };

        do {
            System.out.println("[0] Exit\n[1] +Milk\n[2] +Sugar");
            input = keyboard.nextInt();
            beverage = switch (input) {
                case 0 -> beverage;
                case 1 -> new MilkDecorator(beverage);
                case 2 -> new SugarDecorator(beverage);
                default -> throw new IllegalStateException("Unexpected value: " + input);
            };
        } while (input != 0);

        System.out.printf("Your choise: %s Total cost %s\n", beverage.getDescription(), beverage.cost());

    }
}