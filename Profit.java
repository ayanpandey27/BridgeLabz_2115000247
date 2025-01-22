public class Profit {
    public static void main(String[] args) {
        // Cost price and selling price
        double costPrice = 129;
        double sellingPrice = 191;

        // Calculate profit and profit percentage
        double profit = sellingPrice - costPrice;
        double profitPercentage = (profit / costPrice) * 100;

        // Output the result in a single print statement with multiline text
        System.out.printf("Profit and Loss Calculation:\n" +
                          "Cost Price: INR %.2f\n" +
                          "Selling Price: INR %.2f\n" +
                          "Profit: INR %.2f\n" +
                          "Profit Percentage: %.2f%%\n", 
                          costPrice, sellingPrice, profit, profitPercentage);
    }
}
    
