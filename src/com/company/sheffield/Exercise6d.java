package com.company.sheffield;

public class Exercise6d {
    private static final double LEMON_PRICE = 0.43;
    private static final double PROFIT_PERCENTAGE = 0.21;
    private static final double TOTAL_PROFIT = 14.00;
    public static void main(String[] args) {
        //calculate the profit per lemon.
        double profitPerLemon = LEMON_PRICE * PROFIT_PERCENTAGE;

        //calculate the number of lemons.
        int lemons = (int)Math.round(TOTAL_PROFIT/profitPerLemon);

        //output number of lemons sold
        System.out.println("Lemons Sold: " + lemons);
    }
}
