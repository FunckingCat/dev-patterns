package org.example;

import org.example.impl.CafeteriaMenuContainer;
import org.example.impl.MegaMenu;
import org.example.impl.MenuItem;
import org.example.impl.PelmennayaMenuContainer;
import org.example.impl.PizzaMenuContainer;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MegaMenu menu = new MegaMenu();
        menu.add(new CafeteriaMenuContainer());
        menu.add(new PizzaMenuContainer());
        menu.add(new PelmennayaMenuContainer());

        List<MenuItem> menuItems = menu.getAll();

        int counter = 0;
        for (MenuItem item : menuItems) {
            System.out.printf("[%s] - %s\n", counter++, item);
        }

        int input = scanner.nextInt();

        System.out.printf("Your choise is %s", menuItems.get(input));

    }

}