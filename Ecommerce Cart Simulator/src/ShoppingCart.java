import java.sql.SQLException;
import java.util.List;

public class ShoppingCart {
    private CartDAO cartDAO;
    private ProductDAO productDAO;

    public ShoppingCart() {
        this.cartDAO = new CartDAO();
        this.productDAO = new ProductDAO();
    }

    public void addProduct(int productId, int quantity) throws SQLException {
        Product product = productDAO.getProductById(productId);
        if (product != null) {
            cartDAO.addToCart(productId, quantity);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void viewCart() throws SQLException {
        List<Product> items = cartDAO.getCartItems();
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            System.out.println("\nCart Items:");
            for (Product item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice() +
                        " (Qty: " + item.getQuantity() + ")");
            }
        }
    }

    public void removeProduct(int productId) throws SQLException {
        cartDAO.removeFromCart(productId);
        System.out.println("Product removed from cart.");
    }

    public void checkout() throws SQLException {
        List<Product> items = cartDAO.getCartItems();
        double total = 0;
        for (Product item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        System.out.println("Total: $" + total);
        cartDAO.clearCart();
        System.out.println("Checkout complete. Cart cleared.");
    }
}

