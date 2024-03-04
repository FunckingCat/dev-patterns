package org.example.model;

public abstract class AbstractDuck {

    protected final String name;

    protected String flyPhraze;

    protected String quakPhraze;

    protected AbstractDuck(String name, String flyPhraze, String quakPhraze) {
        this.name = name + " утка";
        this.flyPhraze = flyPhraze;
        this.quakPhraze = quakPhraze;
    }

    public void setFlyPhraze(String flyPhraze) {
        this.flyPhraze = flyPhraze;
    }

    public void setQuakPhraze(String quakPhraze) {
        this.quakPhraze = quakPhraze;
    }
}
