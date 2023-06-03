package edu.pratik.decorator.toppings;

import edu.pratik.decorator.BasePizza;

public class ChickenSausage extends ToppingsDecorator {
    private static final int COST=50;

    public ChickenSausage(BasePizza basePizza) {
        super(basePizza, COST);
    }
}
