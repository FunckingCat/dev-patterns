package org.example.service;

import org.example.behavior.Beverage;
import org.example.factory.TeaBeverageFactory;
import org.example.model.Pair;
import org.example.model.Snack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PaymentService {

    public enum PaymentType {
        CARD("Attach your card"), CASH("Insert bills"), QR("Scan the QR code");

        public final String paymentMessage;

        PaymentType(String message) {
            this.paymentMessage = message;
        }

    }

    public void payOrder(Pair<Beverage, Snack> order, Scanner scanner) {
        System.out.println("\nPAYING ORDER");

        System.out.printf("Your order is %s with snack %s\n", order.getFirst().getDescription(), order.getSecond().getType().name());
        System.out.printf("Price for beverage is %s\n", order.getFirst().getTotalPrice());
        System.out.printf("Price for snack is %s\n", order.getSecond().getType().price);


        System.out.println("CHOOSE PAYMENT METHOD");
        List<String> output = Arrays.stream(PaymentType.values())
                .map(type -> "[%d] - %s".formatted(type.ordinal(), type.name().toLowerCase()))
                .toList();
        System.out.println(String.join(" ", output));
        int value = scanner.nextInt();
        PaymentType type = PaymentType.values()[value];
        System.out.println(type.paymentMessage);

    }

}
