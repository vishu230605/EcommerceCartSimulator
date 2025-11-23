import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EcommerceSimulator {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        ProductDAO productDAO = new ProductDAO();
        Scanner scanner = new Scanner(System.in);

        try {
            // Load and display products from DB
            List<Product> products = productDAO.getAllProducts();
            System.out.println("Available Products:");
            for (Product p : products) {
                System.out.println(p.getId() + ". " + p);
            }

            while (true) {
                System.out.println("\nE-commerce Cart Simulator");
                System.out.println("1. Add Product by ID");
                System.out.println("2. View Cart");
                System.out.println("3. Remove Product by ID");
                System.out.println("4. Checkout");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter product ID: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter quantity: ");
                        int qty = scanner.nextInt();
                        cart.addProduct(id, qty);
                        break;
                    case 2:
                        cart.viewCart();
                        break;
                    case 3:
                        System.out.print("Enter product ID to remove: ");
                        int removeId = scanner.nextInt();
                        cart.removeProduct(removeId);
                        break;
                    case 4:
                        cart.checkout();
                        break;
                    case 5:System.out.println("Exiting simulator.");
                        DatabaseConnection.closeConnection();
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
