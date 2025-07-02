# E-commerce Backend - Spring Boot Application

A full-stack e-commerce web application built with Spring Boot and modern web technologies. This project demonstrates complete backend development skills including RESTful API design, database management, and frontend-backend integration for a local store management system.

## Project Overview

This e-commerce application provides a comprehensive platform for managing products and shopping cart functionality. The system allows users to browse products, add items to cart, search through inventory, and filter products by categories - all essential features for modern online retail platforms.

## Features

### 🛍️ Product Management
- **Product Catalog**: Complete product listing with details
- **Search Functionality**: Find products by name or description
- **Category Filtering**: Browse products by categories
- **Product Details**: Comprehensive product information display

### 🛒 Shopping Cart System
- **Add to Cart**: Seamless product addition to shopping cart
- **Cart Management**: View, update, and remove cart items
- **Quantity Control**: Adjust item quantities in cart
- **Real-time Updates**: Dynamic cart updates without page refresh

### 💾 Data Management
- **In-memory Database**: H2 database for development and testing
- **Sample Data**: Pre-loaded product catalog for immediate testing
- **Data Persistence**: Reliable data storage during application runtime

## Technology Stack

### Backend
- **Java 17**: Modern Java development
- **Spring Boot 3.x**: Rapid application development framework
- **Spring Web**: RESTful web services
- **Spring Data JPA**: Database operations and ORM
- **H2 Database**: In-memory database for development
- **Bean Validation**: Input validation and data integrity

### Frontend
- **HTML5**: Modern web markup
- **CSS3**: Responsive styling and layouts
- **Vanilla JavaScript**: Dynamic frontend functionality
- **REST API Integration**: Seamless backend communication

## Getting Started

### Prerequisites
- Java 17 or higher
- Spring Tool Suite 4 (STS4) or any Java IDE
- Maven 3.6+
- Web browser (Chrome, Firefox, etc.)

### Installation Steps

1. **Clone or Download the Project**
   ```bash
   git clone <repository-url>
   cd ecommerce-backend
   ```

2. **Import into STS4**
   - File → Import → Existing Maven Projects
   - Select the project folder
   - Click Finish

3. **Build the Project**
   ```bash
   mvn clean install
   ```

4. **Run the Application**
   - Right-click `EcommerceBackendApplication.java`
   - Run As → Java Application
   - Or use Maven: `mvn spring-boot:run`

5. **Access the Application**
   - Backend API: `http://localhost:8080`
   - H2 Console: `http://localhost:8080/h2-console`
   - Frontend: Open `index.html` in your browser

### Database Configuration

H2 Console Access:
- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:ecommerce`
- **Username**: `sa`
- **Password**: (leave empty)

## API Endpoints

### Product Endpoints
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `GET /api/products/search?name={name}` - Search products by name
- `GET /api/products/category/{category}` - Get products by category
- `POST /api/products` - Create new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Cart Endpoints
- `GET /api/cart` - Get all cart items
- `POST /api/cart/add` - Add product to cart
- `PUT /api/cart/{id}` - Update cart item quantity
- `DELETE /api/cart/{id}` - Remove item from cart
- `DELETE /api/cart/clear` - Clear entire cart

## Project Structure

```
ecommerce-backend/
├── src/main/java/com/localstore/ecommerce/
│   ├── EcommerceBackendApplication.java    # Main application class
│   ├── config/
│   │   └── DataLoader.java                 # Sample data loader
│   ├── controller/
│   │   ├── ProductController.java          # Product REST endpoints
│   │   └── CartController.java             # Cart REST endpoints
│   ├── entity/
│   │   ├── Product.java                    # Product entity model
│   │   └── CartItem.java                   # Cart item entity model
│   ├── repository/
│   │   ├── ProductRepository.java          # Product data access
│   │   └── CartItemRepository.java         # Cart data access
│   └── service/
│       ├── ProductService.java             # Product business logic
│       └── CartService.java                # Cart business logic
├── src/main/resources/
│   └── application.yml                     # Application configuration
├── frontend/
│   └── index.html                          # Frontend interface
└── pom.xml                                 # Maven dependencies
```

## Configuration

The application uses YAML configuration in `application.yml`:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:ecommerce
    driver-class-name: org.h2.Driver
  h2:
    console:
      enabled: true
  jpa:
    show-sql: true
    hibernate:
      ddl-auto: create-drop
```

## Sample Data

The application comes with pre-loaded sample products including:
- Electronics (Laptops, Smartphones, Headphones)
- Clothing (T-shirts, Jeans, Sneakers)
- Books (Programming, Fiction, Science)
- Home & Garden items

## Testing the Application

1. **Start the backend** - Run the Spring Boot application
2. **Verify API** - Test endpoints using browser or Postman
3. **Open frontend** - Launch `index.html` in web browser
4. **Test features**:
   - Browse product catalog
   - Search for specific products
   - Filter by categories
   - Add items to cart
   - Manage cart contents

## Troubleshooting

### Common Issues

**Port Already in Use**
- Change port in `application.yml`: `server.port: 8081`

**Frontend Can't Connect**
- Ensure backend is running on correct port
- Check API_BASE_URL in frontend code

**Database Console Access Issues**
- Verify H2 console is enabled in configuration
- Use correct JDBC URL: `jdbc:h2:mem:ecommerce`

**Maven Dependency Issues**
- Run `mvn clean install`
- Refresh project in IDE
- Check internet connection for dependency downloads

## Future Enhancements

Potential improvements for production deployment:
- [ ] User authentication and authorization
- [ ] Order management system
- [ ] Payment gateway integration
- [ ] Product image upload functionality
- [ ] Inventory management
- [ ] Email notifications
- [ ] PostgreSQL/MySQL database integration
- [ ] Admin dashboard for product management

## Learning Outcomes

This project demonstrates proficiency in:
- **Spring Boot Development**: Framework architecture and best practices
- **RESTful API Design**: Creating clean and maintainable endpoints
- **Database Integration**: JPA/Hibernate ORM and repository patterns
- **Full-stack Development**: Frontend-backend integration
- **Project Structure**: Organizing code following Spring Boot conventions
- **Testing and Debugging**: Application troubleshooting and verification

## Contributing

This project welcomes contributions and suggestions:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/improvement`)
3. Commit changes (`git commit -am 'Add new feature'`)
4. Push to branch (`git push origin feature/improvement`)
5. Create a Pull Request

---

**Developed by:** Yash Kalkhambkar  
**Institution:** MIT ADT University  
**Program:** Second Year, Computer Science & Engineering  
**LinkedIn:** [Connect with me](https://linkedin.com/in/yash-kalkhambkar)  

For detailed setup instructions, refer to the complete setup guide included in the project documentation.
