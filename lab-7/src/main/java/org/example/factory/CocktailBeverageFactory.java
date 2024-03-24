package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Cocktail;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CocktailBeverageFactory extends AbstractBeverageFactory {

    public enum Type {
        VANILLA(
                List.of(
                    "Chill the Glass: Begin by placing your cocktail glass in the freezer to chill for about 5-10 minutes. This step ensures your cocktail stays cool longer.",
                    "Mix Ingredients: In a shaker, combine the vanilla vodka, white Creme de Cacao, half-and-half, and if you're using, a few drops of vanilla extract. If you have a vanilla bean, you can scrape a small amount of seeds into the mix for an authentic flavor boost.",
                    "Shake Well: Add ice cubes to the shaker. Seal the shaker tightly and shake vigorously for about 20-30 seconds. Shaking not only chills the drink but also ensures that all the ingredients are well combined."
                ),
                List.of(
                    "2 oz Vanilla Vodka",
                    "1 oz White Creme de Cacao",
                    "2 oz Half-and-half (or light cream)",
                    "Ice cubes",
                    "Vanilla bean or vanilla extract (a few drops) for extra flavor (optional)"
                ),
                3.0f
        ),
        BERRY(
                List.of(
                    "Prepare the Berries: In a cocktail shaker, add a handful of mixed berries. Save some for garnish. Muddle the berries well to release their juices and flavors. This will form the fruity base of your cocktail.",
                    "Mix the Cocktail: To the muddled berries, add the berry vodka, lemon juice, and simple syrup. The simple syrup can be adjusted based on how sweet you like your cocktail.",
                    "Shake: Add a handful of ice cubes to the shaker. Seal it tightly and shake vigorously for about 15-20 seconds, ensuring that all the ingredients are well chilled and combined."
                ),
                List.of(
                    "2 oz Berry Vodka (raspberry, strawberry, or mixed berry)",
                    "1 oz Lemon juice, freshly squeezed",
                    "1/2 oz Simple syrup (adjust to taste)",
                    "Mixed berries (strawberries, raspberries, blueberries) for muddling and garnish",
                    "Soda water or sparkling water"
                ),
                4.0f
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

        System.out.println("CREATE COCKTAIL");

        List<String> output = Arrays.stream(Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = input.nextInt();
        Type type = Type.values()[value];
        return new Cocktail(type.name(), type.recipe, type.ingredients, type.basePrice);
    }
}
