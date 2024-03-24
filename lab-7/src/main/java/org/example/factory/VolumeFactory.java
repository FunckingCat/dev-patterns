package org.example.factory;

import org.example.behavior.Beverage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VolumeFactory {

    public enum Volume {
        SMALL, MEDIUM, LARGE
    }

    public static Beverage setVolume(Beverage beverage, Scanner input) {
        System.out.println("CHOOSE VOLUME");
        List<String> output = Arrays.stream(Volume.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        Volume volume = Volume.values()[input.nextInt()];
        beverage.setVolume(switch (volume){
            case SMALL -> 0.2;
            case MEDIUM -> 0.4;
            case LARGE -> 0.6;
        });
        return beverage;
    };

}
