package org.example.model;

public class Snack {

    public enum Type {
        PIE(1.0f), BUN(2.0f), NONE(0.0f);

        public final Float price;

        Type (Float price) {
            this.price = price;
        }
    }

    public Snack(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    private Type type;

}
