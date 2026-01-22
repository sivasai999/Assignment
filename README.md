# Microservices Architecture Project

Spring Boot microservices application with API Gateway, JWT authentication, and service discovery.

## 🏗️ Architecture

Gateway (8080) → Auth Service (8084) - Authentication
              → Order Service (8081) - Order Management
              → Eureka Server (8761) - Service Discovery

## 📦 Services

### 1. **API Gateway** (Port 8080)
- Single entry point for all requests
- JWT token validation
- Routes to microservices
- Circuit breaker with fallback

### 2. **Auth Service** (Port 8084)
- User registration and login
- JWT token generation
- Role-based access control
- Database: MySQL (`auth_db`)

### 3. **Order Service** (Port 8081)
- CRUD operations for orders
- RESTful API
- Swagger documentation
- Database: MySQL (`order_db`)

### 4. **Eureka Server** (Port 8761)
- Service discovery and registration

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.4.1
- Spring Cloud Gateway
- Netflix Eureka
- MySQL
- JWT (jjwt 0.11.5)
- JPA/Hibernate
- Maven

## 🚀 Quick Start

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL 8.0+

### Setup

1. **Update Database Credentials** in `application.properties` files

2. **Start Services (in order):**
# 1. Eureka Server

# 2. API Gateway

# 3. Order Service

# 4. Auth Service

3. **Verify:**
- Eureka Dashboard: http://localhost:8761


## 🔐 API Endpoints

### Authentication

**Register:**
POST http://localhost:8080/auth/register

{
  "username": "siva",
  "email": "siva@gmail.com",
  "password": "sivasai123"
}

**Login:**
POST http://localhost:8080/auth/login

{
  "username": "siva",
  "password": "sivasai123"
}

# Returns: token

### Orders (Requires JWT Token)


# Get all orders
GET http://localhost:8080/order/api/v1/orders
Authorization: token

# Get order by ID
GET http://localhost:8080/order/api/v1/orders/{id}
Authorization: token

# Create order
POST http://localhost:8080/order/api/v1/orders
Authorization: token
Content-Type: application/json

{
  "orderNumber": "ORD-001",
  "userId": 1,
  "totalAmount": 99.99,
  "status": "PENDING"
}


## 🔒 Authentication Flow

1. Register/Login → Get JWT token
2. Include token in header: `Authorization: Bearer <token>`
3. Gateway validates token and routes to service





