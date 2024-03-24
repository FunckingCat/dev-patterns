package org.example.orchestrator;

import org.example.behavior.Beverage;
import org.example.model.Pair;
import org.example.model.Snack;
import org.example.service.CookingService;
import org.example.service.OrderService;
import org.example.service.PaymentService;

import java.util.Scanner;

public class CafeteriaOrchestrator {

    private final OrderService orderService;
    private final CookingService cookingService;
    private final PaymentService paymentService;

    public CafeteriaOrchestrator() {
        orderService = new OrderService();
        cookingService = new CookingService();
        paymentService = new PaymentService();
    }

    public void orchestrateCafeteriaOrder() {
        System.out.println("Enter CafeteriaOrchestrator::orchestrateCafeteriaOrder");

        Scanner keyboard = new Scanner(System.in);

        Pair<Beverage, Snack> order = orderService.takeOrder(keyboard);

        cookingService.cookOrder(order);

        paymentService.payOrder(order, keyboard);

    }

}
