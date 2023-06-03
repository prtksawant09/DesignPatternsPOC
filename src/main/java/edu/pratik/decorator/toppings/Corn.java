package edu.pratik.decorator.toppings;

import edu.pratik.decorator.BasePizza;

public class Corn extends ToppingsDecorator {
    private static final int COST=25;

    public Corn(BasePizza basePizza) {
        super(basePizza, COST);
    }
}
