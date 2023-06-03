package edu.pratik.decorator.toppings;

import edu.pratik.decorator.BasePizza;

public class ChickenPepperoni extends ToppingsDecorator {

    private static final int COST=50;

    public ChickenPepperoni(BasePizza basePizza) {
        super(basePizza, COST);
    }
}
