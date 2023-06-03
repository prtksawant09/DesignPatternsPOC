package edu.pratik.decorator.toppings;

import edu.pratik.decorator.BasePizza;

public class ToppingsDecorator extends BasePizza {

    private final int cost;

    protected ToppingsDecorator(BasePizza basePizza, int cost) {
        this.cost = basePizza.getCost()+cost;
    }

    @Override
    public int getCost() {
        return cost;
    }
}
