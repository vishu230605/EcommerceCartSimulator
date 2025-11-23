import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDAO {
    public void addToCart(int productId, int quantity) throws SQLException {
        String query = "INSERT INTO cart (product_id, quantity) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, productId);
            pstmt.setInt(2, quantity);
            pstmt.executeUpdate();
        }
    }

    public List<Product> getCartItems() throws SQLException {
        List<Product> cartItems = new ArrayList<>();
        String query = "SELECT p.*, c.quantity as cart_qty FROM cart c " +
                "JOIN products p ON c.product_id = p.id";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                cartItems.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("cart_qty")
                ));
            }
        }
        return cartItems;
    }

    public void removeFromCart(int productId) throws SQLException {
        String query = "DELETE FROM cart WHERE product_id = ? LIMIT 1";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, productId);
            pstmt.executeUpdate();
        }
    }

    public void clearCart() throws SQLException {
        String query = "DELETE FROM cart";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(query);
        }
    }
}
