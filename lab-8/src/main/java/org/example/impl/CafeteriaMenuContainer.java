package org.example.impl;

import org.example.behavior.Container;
import org.example.behavior.Iterator;
import org.example.behavior.Linker;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class CafeteriaMenuContainer implements Container, Linker<MenuItem> {

    private final List<MenuItem> menu;

    private final List<Linker<MenuItem>> subMenu = new ArrayList<>();

    public CafeteriaMenuContainer() {

        String menuName = this.getClass().getSimpleName();
        menu = new ArrayList<>() {{
            add(new MenuItem(menuName, "Grilled Chicken Caesar Salad", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            add(new MenuItem(menuName, "Classic Cheeseburger with Fries", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            add(new MenuItem(menuName, "Veggie Wrap with Hummus", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            add(new MenuItem(menuName, "Spaghetti Bolognese", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
            add(new MenuItem(menuName, "Roast Turkey Sandwich with Cranberry Sauce", "Description", ThreadLocalRandom.current().nextDouble(1, 10)));
        }};

        subMenu.add(new PizzaMenuContainer());
        subMenu.add(new PelmennayaMenuContainer());

    }

    @Override
    public Iterator<MenuItem> getIterator() {
        return new CafeteriaMenuIterator();
    }

    @Override
    public List<MenuItem> getAll() {
        Iterator<MenuItem> iterator = getIterator();
        List<MenuItem> menuItems = new ArrayList<>();
        while (iterator.hasNext()) {
            menuItems.add(iterator.next());
        }
        List<MenuItem> subMenus = subMenu.stream()
                .map(Linker::getAll)
                .flatMap(List::stream)
                .peek(item -> item.setMenuName(this.getClass().getSimpleName() + "->" + item.getMenuName()))
                .toList();
        menuItems.addAll(subMenus);
        return menuItems;
    }

    private class CafeteriaMenuIterator implements Iterator<MenuItem> {

        int index;

        @Override
        public boolean hasNext() {
            return index < menu.size();
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
