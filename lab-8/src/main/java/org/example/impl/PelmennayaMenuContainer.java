package org.example.impl;

import org.example.behavior.Container;
import org.example.behavior.Iterator;
import org.example.behavior.Linker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class PelmennayaMenuContainer implements Container, Linker<MenuItem> {

    private final Map<Integer, MenuItem> menu;

    public PelmennayaMenuContainer() {
        String menuName = this.getClass().getSimpleName();
        menu =  new HashMap<>(){{
            put(0, new MenuItem(menuName, "Classic Pelmeni (Russian Dumplings)", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            put(1, new MenuItem(menuName, "Siberian Pelmeni with Beef and Pork Filling", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            put(2, new MenuItem(menuName, "Vegetarian Pelmeni with Potato and Mushroom Filling", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            put(3, new MenuItem(menuName, "Pelmeni Soup (Pelmeni in a Clear Broth)", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            put(4, new MenuItem(menuName, "Pelmeni Platter with Sour Cream and Dill", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
        }};
    }

    @Override
    public Iterator<MenuItem> getIterator() {
        return new PizzaMenuIterator();
    }

    @Override
    public List<MenuItem> getAll() {
        Iterator<MenuItem> iterator = getIterator();
        List<MenuItem> menuItems = new ArrayList<>();
        while (iterator.hasNext()) {
            menuItems.add(iterator.next());
        }
        return menuItems;
    }

    private class PizzaMenuIterator implements Iterator<MenuItem> {

        int index;

        @Override
        public boolean hasNext() {
            return index < menu.keySet().size();
        }

        @Override
        public MenuItem next() {
            if (this.hasNext()) {
                return menu.get(index++);
            }
            return null;
        }

        @Override
        public void pop() {
            if (!this.hasNext()) {
                throw new RuntimeException("Cannot pop");
            }
            menu.remove(index);
        }
    }

}
