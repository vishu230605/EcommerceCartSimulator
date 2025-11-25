# EcommerceCartSimulator
## Features
- **Product Management**: Add, view, and manage products stored in a database.
- **Cart Operations**: Add items to cart, view cart contents, remove items, and calculate totals.
- **Persistence**: All data (products and cart) is stored in an H2 database for persistence across sessions.
- **OOP Implementation**: Uses classes like `Product`, `ShoppingCart`, `ProductDAO`, and `CartDAO` to demonstrate encapsulation, modularity, and separation of concerns.
- **JDBC Integration**: Establishes database connectivity with prepared statements for secure queries.
- **Console Interface**: Simple command-line menu for user interaction.

## Prerequisites
- **Java**: JDK 8 or higher (download from https://www.oracle.com/java/technologies/javase-downloads.html).
- **H2 Database**: Version 1.4.200 or compatible (download JAR from https://www.h2database.com/html/download.html).
- **IDE/Tools**: Any Java IDE (e.g., Eclipse, IntelliJ) or command line for compilation and execution.

## Installation and Setup
1. **Clone or Download the Project**:
   - Download the project files or clone from GitHub (if available).
   - Place the H2 JAR file in a `/lib` folder within the project directory.

2. **Project Structure**:
   ```
   EcommerceCartSimulatorDB/
   ├── src/
   │   ├── DatabaseConnection.java
   │   ├── Product.java
   │   ├── ProductDAO.java
   │   ├── CartDAO.java
   │   ├── ShoppingCart.java
   │   └── EcommerceSimulator.java
   ├── db/
   │   ├── schema.sql
   │   └── insert_sample.sql
   ├── lib/
   │   └── h2-*.jar
   └── README.md
   ```

3. **Database Setup**:
   - Launch H2 Console: Run `java -jar lib/h2-*.jar` in the terminal. Access at http://localhost:8082.
   - Create a new database: Use JDBC URL `jdbc:h2:~/ecommerce`, username `sa`, and no password.
   - Execute `/db/schema.sql` in the H2 Console to create tables (`products` and `cart`).
   - Execute `/db/insert_sample.sql` to insert sample products (e.g., Laptop, Phone, Headphones).

## How to Run
1. **Compile the Code**:
   - Open a terminal in the project root.
   - Run: `javac -cp lib/h2-*.jar src/*.java`

2. **Execute the Program**:
   - Run: `java -cp .:lib/h2-*.jar src/EcommerceSimulator`
   - Follow the console menu:
     - View available products (loaded from DB).
     - Add products to cart by ID and quantity.
     - View cart, remove items, or checkout.
     - Exit to close the connection.

3. **Sample Interaction**:
   - Choose option 1: Enter product ID (e.g., 1 for Laptop) and quantity.
   - Choose 2: View cart contents.
   - Choose 4: Checkout and see total (data persists in DB).

## Database Schema
- **products Table**: Stores item details (id, name, price, quantity).
- **cart Table**: Tracks cart items (id, product_id, quantity) with a foreign key to products.
- Use H2 Console to query: `SELECT * FROM products;` or `SELECT * FROM cart;`.

## Code Quality and Standards
- **Commenting**: All classes and methods include Javadoc comments for clarity.
- **Modularity**: DAOs handle DB logic separately from business logic.
- **Standards**: Follows Java naming conventions, uses prepared statements to prevent SQL injection, and includes exception handling for robustness.

## Troubleshooting
- **JDBC Errors**: Ensure H2 JAR is in classpath and DB URL is correct.
- **Connection Issues**: Check if H2 Console is running and tables are created.
- **Compilation Errors**: Verify Java version and file paths.
