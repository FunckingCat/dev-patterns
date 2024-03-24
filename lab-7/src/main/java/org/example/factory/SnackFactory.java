package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SnackFactory {

    public static Snack chooseSnack(Scanner input) {
        System.out.println("CHOOSE SNACK");
        List<String> output = Arrays.stream(Snack.Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        Snack.Type snakType = Snack.Type.values()[input.nextInt()];
        return new Snack(snakType);
    };

}
