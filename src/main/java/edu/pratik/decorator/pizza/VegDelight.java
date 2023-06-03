package edu.pratik.decorator.pizza;

import edu.pratik.decorator.BasePizza;

public class VegDelight extends BasePizza {
    private static final int COST=250;

    @Override
    public int getCost() {
        return COST;
    }
}
