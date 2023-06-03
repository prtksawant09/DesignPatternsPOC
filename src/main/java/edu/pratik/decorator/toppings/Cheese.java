package edu.pratik.decorator.toppings;

import edu.pratik.decorator.BasePizza;

public class Cheese extends ToppingsDecorator {

    private static final int COST=25;

    public Cheese(BasePizza pizza) {
        super(pizza, COST);
    }
}
