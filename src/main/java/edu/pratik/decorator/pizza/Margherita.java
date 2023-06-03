package edu.pratik.decorator.pizza;

import edu.pratik.decorator.BasePizza;

public class Margherita extends BasePizza {
    private static final int COST=100;

    @Override
    public int getCost() {
        return COST;
    }
}
