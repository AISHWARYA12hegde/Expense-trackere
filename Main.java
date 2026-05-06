import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Expense> expenses = new ArrayList<>();

        while (true) {

            System.out.println("\n==== Expense Tracker ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Exit");
            System.out.println("4. Total Expense");
            System.out.println("5. Filter by Category");

            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            sc.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    System.out.print("Enter expense name: ");
                    String name = sc.nextLine();

                    double amount = 0;

                    try {
                        System.out.print("Enter amount: ");
                        amount = sc.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                        break;
                    }

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter category (FOOD/TRAVEL/SHOPPING/EDUCATION/ENTERTAINMENT/OTHER): ");
                    String catInput = sc.nextLine().trim().toUpperCase();

                    Category category;

                    try {
                        category = Category.valueOf(catInput);
                    } catch (Exception e) {
                        System.out.println("Invalid category! Defaulting to OTHER");
                        category = Category.OTHER;
                    }

                    Expense exp = new Expense(name, amount, category);
                    expenses.add(exp);

                    System.out.println("Expense added!");
                    break;

                case 2:
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses yet");
                    } else {
                        System.out.println("\nExpenses:");
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                case 4:
                    double total = expenses.stream()
                            .mapToDouble(Expense::getAmount)
                            .sum();

                    System.out.println("Total Spending: " + total);
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String catInput1 = sc.nextLine().trim().toUpperCase();

                    Category categorycheck;

                    try {
                        categorycheck = Category.valueOf(catInput1);
                    } catch (Exception e) {
                        System.out.println("Invalid category! Defaulting to OTHER");
                        categorycheck = Category.OTHER;
                    }

                    final Category finalCategory = categorycheck;

                    boolean found = false;

                    for (Expense e : expenses) {
                        if (e.getCategory() == finalCategory) {
                            System.out.println(e);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No expenses found for this category.");
                    }

                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}