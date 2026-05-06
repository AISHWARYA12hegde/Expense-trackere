public class Expense {
     private String name;
    private double amount;
    private Category category;

    public Expense(String name, double amount, Category category) {
        this.name = name;
        this.amount = amount;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
     public Category getCategory() {
        return category;
    }
    @Override
public String toString() {
    return name + " - " + amount + " - " + category;
}
}
