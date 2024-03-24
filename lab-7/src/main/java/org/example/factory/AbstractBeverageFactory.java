package org.example.factory;

import org.example.behavior.Beverage;

import java.util.Scanner;

public abstract class AbstractBeverageFactory {

    public abstract Beverage createBeverage(Scanner input);

}
