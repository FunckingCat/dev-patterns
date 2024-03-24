package org.example;

import org.example.behavior.Beverage;
import org.example.factory.AddonFactory;
import org.example.factory.CocktailBeverageFactory;
import org.example.factory.FreshBeverageFactory;
import org.example.factory.TeaBeverageFactory;
import org.example.factory.VolumeFactory;
import org.example.decorator.MilkDecorator;
import org.example.decorator.SugarDecorator;
import org.example.orchestrator.CafeteriaOrchestrator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        CafeteriaOrchestrator cafeteriaOrchestrator = new CafeteriaOrchestrator();

        cafeteriaOrchestrator.orchestrateCafeteriaOrder();

    }
}