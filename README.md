E-Commerce Shopping Cart Simulator with GUI and Validation
This Java project simulates an e-commerce shopping cart system with a graphical user interface (GUI), persistent database storage using JDBC and H2 Database, and robust input validation. It demonstrates core Java concepts (e.g., OOP principles like encapsulation and modularity), error handling, data validation, and innovative features for a seamless user experience.

## Features
- **Product Management**: Load and display products from a database with stock tracking.
- **Cart Operations**: Add, remove, view items, calculate totals, and checkout with persistence across sessions.
- **GUI Interface**: Intuitive JavaFX-based UI with ListViews for products/cart, buttons for actions, and real-time updates.
- **Data Validation**: Client-side checks (e.g., positive quantities, selected items) and server-side validation (e.g., stock availability, product existence) to prevent invalid data entry.
- **Error Handling & Robustness**: Exception handling for DB errors, invalid inputs, and system failures; user-friendly alerts prevent crashes.
- **Integration & Event Handling**: Smooth interaction between GUI, business logic, and DB; optimized event listeners for efficient performance.
- **Code Quality & Innovation**: Clean, modular code with Javadoc comments; innovative features like confirmation dialogs and stock checks for enhanced reliability.

## Prerequisites
- **Java**: JDK 8 or higher (download from https://www.oracle.com/java/technologies/javase-downloads.html).
- **JavaFX**: SDK 11+ (download from https://openjfx.io) for GUI components.
- **H2 Database**: Version 1.4.200 or compatible (download JAR from https://www.h2database.com/html/download.html).
- **IDE/Tools**: Any Java IDE (e.g., Eclipse, IntelliJ) or command line for compilation and execution.

## Installation and Setup
1. **Clone or Download the Project**:
   - Download the project files or clone from GitHub (if available).
   - Place the H2 JAR and JavaFX SDK JARs (e.g., javafx-controls.jar) in a `/lib` folder within the project directory.

2. **Project Structure**:
   ```
   EcommerceCartSimulatorGUI/
   ├── src/
   │   ├── DatabaseConnection.java
   │   ├── Product.java
   │   ├── ProductDAO.java
   │   ├── CartDAO.java
   │   ├── ShoppingCart.java
   │   ├── EcommerceGUI.java
   │   └── EcommerceSimulator.java
   ├── db/
   │   ├── schema.sql
   │   └── insert_sample.sql
   ├── lib/
   │   ├── h2-*.jar
   │   └── javafx-*.jar (SDK JARs)
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
   - Run: `javac -cp ".:lib/*" src/*.java` (includes H2 and JavaFX JARs).

2. **Execute the Program**:
   - Run: `java -cp ".:lib/*" --module-path lib --add-modules javafx.controls,javafx.fxml src/EcommerceSimulator`.
   - The GUI window will open: Select products from the list, enter quantity, add to cart, remove items, or checkout.
   - Data persists in the DB; check H2 Console for updates.

3. **Sample Interaction**:
   - Select a product (e.g., Laptop).
   - Enter quantity (e.g., 1) and click "Add to Cart".
   - View cart, remove if needed, and checkout with confirmation.
   - Alerts handle errors (e.g., invalid quantity or insufficient stock).

## Database Schema
- **products Table**: Stores item details (id INT PRIMARY KEY, name VARCHAR, price DOUBLE, quantity INT).
- **cart Table**: Tracks cart items (id INT PRIMARY KEY, product_id INT FOREIGN KEY, quantity INT).
- Use H2 Console to query: `SELECT * FROM products;` or `SELECT * FROM cart;`.

## Code Quality and Standards
- **Commenting**: All classes and methods include Javadoc comments for clarity.
- **Modularity**: Separate concerns (e.g., DAOs for DB, GUI for UI, ShoppingCart for logic).
- **Standards**: Follows Java naming conventions, uses prepared statements for security, and includes comprehensive exception handling.
- **Innovation**: GUI with real-time updates, validation alerts, and confirmation dialogs for better UX.

## Troubleshooting
- **JavaFX Errors**: Ensure JavaFX JARs are in classpath and modules are added correctly.
- **DB Connection Issues**: Check H2 Console is running and schema is created.
- **Validation Alerts**: If alerts don't appear, verify JavaFX is properly configured.
- **Compilation Errors**: Confirm Java version and JAR paths.
