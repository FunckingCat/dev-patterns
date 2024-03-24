package org.example.factory;

import org.example.behavior.Beverage;
import org.example.model.Tea;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TeaBeverageFactory extends AbstractBeverageFactory {

    public enum Type {
        GREEN(
                List.of(
                    "Heat the Water: Heat your water until it's just about to boil, which is around 160-180°F (71-82°C). If you don’t have a thermometer, bring the water to a boil and then let it cool for about 2 minutes. It's crucial not to pour boiling water over green tea leaves as it can scorch the leaves, affecting the delicate flavors.",
                    "Pre-warm Your Teapot or Cup: Pour some of the hot water into your teapot or cup, swirl it around, and then discard the water. This step is optional but helps to maintain the temperature while your tea steeps.",
                    "Add the Green Tea: Place your green tea leaves in a tea infuser and set it in your teapot or cup. If you're using a tea bag, simply place it in your cup.",
                    "Steep the Tea: Pour the hot water over the tea leaves or bag, making sure they're completely submerged. Allow the tea to steep for about 2 to 3 minutes. If you prefer a lighter tea, start checking at 1 minute. For a stronger brew, allow it to steep for a full 3 minutes. Avoid steeping for too long as it can extract bitter compounds.",
                    "Remove the Tea Leaves or Bag: Once your tea has reached the desired strength, remove the tea leaves or bag from the water. This prevents over-steeping and ensures a smooth taste.",
                    "Flavor as Desired: If you like, add a bit of honey for sweetness. A slice of lemon or a few mint leaves can also add a refreshing twist to your green tea.",
                    "Enjoy: Sip your freshly brewed green tea and enjoy the subtle, calming flavors."
                ),
                List.of(
                    "1 teaspoon of green tea leaves or 1 green tea bag",
                    "8 ounces (about 240 milliliters) of water"
                ),
                1.5f
        ),
        BLACK(
                List.of(
                    "Heat the Water: Heat your water until it reaches a rolling boil, which is around 200-212°F (93-100°C). Unlike green tea, black tea requires hotter water for proper extraction of flavors.",
                    "Pre-warm Your Teapot or Cup: Pour some of the hot water into your teapot or cup, swirl it around, and then discard the water. This helps to maintain the temperature while your tea steeps.",
                    "Add the Black Tea: Place your black tea leaves in a tea infuser and set it in your teapot or cup. If you're using a tea bag, simply place it in your cup.",
                    "Steep the Tea: Pour the hot water over the tea leaves or bag, ensuring they're fully submerged.Allow the tea to steep for about 3 to 5 minutes. The longer you steep, the stronger the flavor will be. You can adjust the steeping time based on your preference for strength.",
                    "Remove the Tea Leaves or Bag: Once the tea has reached your desired strength, remove the tea leaves or bag from the water. Leaving the tea to steep for too long can result in bitterness.",
                    "Flavor as Desired: If you prefer your black tea with milk and/or sugar, add them to taste. You can also add honey, lemon, or spices like cinnamon or cardamom for additional flavor.",
                    "Enjoy: Savor your freshly brewed cup of black tea, either hot or over ice, depending on your preference."
                ),
                List.of(
                    "1 teaspoon of black tea leaves or 1 black tea bag",
                    "8 ounces (about 240 milliliters) of water"
                ),
                1.0f
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

        System.out.println("CREATE TEA");

        List<String> output = Arrays.stream(Type.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = input.nextInt();
        Type type =Type.values()[value];
        return new Tea(type.name(), type.recipe, type.ingredients, type.basePrice);
    }
}
