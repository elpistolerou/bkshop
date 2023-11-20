public class DiscountPricingStrategy implements PricingStrategy {
    private double discount;

    public DiscountPricingStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double calculatePrice(double originalPrice) {
        return originalPrice - (originalPrice * discount);
    }
}