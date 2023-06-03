package edu.pratik.decorator.pizza;

import edu.pratik.decorator.BasePizza;

public class ChickenDelight extends BasePizza {
    private static final int COST=300;

    @Override
    public int getCost() {
        return COST;
    }
}
