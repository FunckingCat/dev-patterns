package org.example.impl;

import org.example.behavior.Container;
import org.example.behavior.Iterator;
import org.example.behavior.Linker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PizzaMenuContainer implements Container, Linker<MenuItem> {

    private MenuItem[] menu = {
            new MenuItem(this.getClass().getSimpleName(), "Margherita Pizza", "Description", ThreadLocalRandom.current().nextDouble(1, 10)),
            new MenuItem(this.getClass().getSimpleName(), "Pepperoni Pizza", "Description", ThreadLocalRandom.current().nextDouble(1, 10)),
            new MenuItem(this.getClass().getSimpleName(), "Vegetarian Supreme Pizza", "Description", ThreadLocalRandom.current().nextDouble(1, 10)),
            new MenuItem(this.getClass().getSimpleName(), "BBQ Chicken Pizza", "Description", ThreadLocalRandom.current().nextDouble(1, 10)),
            new MenuItem(this.getClass().getSimpleName(), "Meat Lover's Pizza", "Description", ThreadLocalRandom.current().nextDouble(1, 10))
    };

    @Override
    public List<MenuItem> getAll() {
        Iterator<MenuItem> iterator = getIterator();
        List<MenuItem> menuItems = new ArrayList<>();
        while (iterator.hasNext()) {
            menuItems.add(iterator.next());
        }
        return menuItems;
    }

    @Override
    public Iterator<MenuItem> getIterator() {
        return new PizzaMenuIterator();
    }

    private class PizzaMenuIterator implements Iterator<MenuItem> {

        int index;

        @Override
        public boolean hasNext() {
            return index < menu.length;
        }

        @Override
        public MenuItem next() {
            if (this.hasNext()) {
                return menu[index++];
            }
            return null;
        }

        @Override
        public void pop() {
            if (!this.hasNext()) {
                throw new RuntimeException("Cannot pop");
            }
            menu = (MenuItem[]) IntStream.range(0, menu.length)
                    .filter(i -> i != index)
                    .mapToObj(i -> menu[i])
                    .toArray();
        }
    }

}
