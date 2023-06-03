package edu.pratik.decorator.pizza;

import edu.pratik.decorator.BasePizza;

public class Farmhouse extends BasePizza {
    private static final int COST=200;

    @Override
    public int getCost() {
        return COST;
    }
}