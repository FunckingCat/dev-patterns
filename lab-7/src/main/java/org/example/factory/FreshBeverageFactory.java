package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Fresh;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FreshBeverageFactory extends AbstractBeverageFactory {

    public enum Type {
        APPLE(
                List.of(
                    "Prepare the apple filling: In a large bowl, toss the sliced apples with 2 tablespoons of granulated sugar, lemon juice, 1 teaspoon of cinnamon, and nutmeg until well coated. Transfer the apple mixture to the prepared baking dish, spreading out evenly.",
                    "Make the crisp topping: In another bowl, combine the flour, oats, granulated sugar, brown sugar, salt, and 1 teaspoon of cinnamon. Pour the melted butter over the mixture, and stir until the mixture is crumbly. If you're using nuts, mix them in as well.",
                    "Assemble the crisp: Sprinkle the crumbly oat mixture evenly over the top of the apples in the baking dish.",
                    "Bake: Place the dish in the preheated oven and bake for about 45 minutes, or until the topping is golden brown and the apple filling is bubbly around the edges."
                ),
                List.of(
                    "6 to 8 fresh apples (medium-sized), peeled, cored, and thinly sliced (a mix of Granny Smith and Honeycrisp is great for flavor and texture)",
                    "2 tablespoons granulated sugar",
                    "1 tablespoon lemon juice",
                    "1 teaspoon ground cinnamon",
                    "½ teaspoon ground nutmeg"
                ),
                6.0f
        ),

        ORANGE(
                List.of(
                    "Prepare the Oranges:",
                    "Wash the oranges thoroughly under running water.",
                    "Roll the oranges on the countertop with your palm, applying gentle pressure. This helps in extracting more juice.",
                    "Juice the Oranges:",
                    "Cut the oranges in half.",
                    "Using a hand juicer or a citrus press, juice the oranges. You should get about 1 cup of juice. If you prefer your drink without pulp, you can strain the juice using a sieve."
                ),
                List.of(
                    "4 large, ripe oranges (for about 1 cup of orange juice)",
                    "2 tablespoons of lemon juice (optional, for a bit of tang)",
                    "2 teaspoons of honey or sugar, adjust to taste (optional, for sweetness)",
                    "Ice cubes",
                    "Mint leaves for garnish (optional)",
                    "Sparkling water (optional, for a fizzy version)"
                ),
                5.0f
        );

        public final List<String> recipe;
        public final List<String> ingredients;

        public final Float basePrice;

        Type(List<String> recipe, List<String> ingredients, Float basePrice) {
            this.recipe = recipe;
            this.ingredients = ingredients;
            this.basePrice = basePrice;
        }
    }

    @Override
    public Beverage createBeverage(Scanner input) {

        System.out.println("CREATE FRESH");

        List<String> output = Arrays.stream(Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = input.nextInt();
        Type type = Type.values()[value];
        return new Fresh(type.name(), type.recipe, type.ingredients, type.basePrice);
    }
}
