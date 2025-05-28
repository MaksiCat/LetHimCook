package lethimcook.models.enums;

public enum Size {
    SMALL(4, 5.50, 1.00, 0.75, 0.50, 0.30),
    MEDIUM(8, 7.00, 2.00, 1.50, 1.00, 0.60),
    LARGE(12, 8.50, 3.00, 2.25, 1.50, 0.90);

    private final int inches;
    private final double basePrice;
    private final double meatPrice;
    private final double cheesePrice;
    private final double extraMeatPrice;
    private final double extraCheesePrice;

    Size(int inches, double basePrice, double meatPrice, double cheesePrice, double extraMeatPrice, double extraCheesePrice) {
        this.inches = inches;
        this.basePrice = basePrice;
        this.meatPrice = meatPrice;
        this.cheesePrice = cheesePrice;
        this.extraMeatPrice = extraMeatPrice;
        this.extraCheesePrice = extraCheesePrice;
    }

    public static Size fromInches(int inches) {
        switch (inches) {
            case 4: return SMALL;
            case 8: return MEDIUM;
            case 12: return LARGE;
            default: throw new IllegalArgumentException("Invalid size.");
        }
    }

    public double getBasePrice() { return basePrice; }
    public double getMeatPrice() { return meatPrice; }
    public double getCheesePrice() { return cheesePrice; }
}
