# Order Service – Spring Boot CRUD API

## Overview
A simple CRUD REST API built using Spring Boot, Spring Data JPA, and MySQL.  
Designed with clean layered architecture

---

## Tech Stack
- Java 17
- Spring Boot 4
- Spring Data JPA
- MySQL
- MapStruct
- Lombok
- Spring Boot Actuator
- Swagger (springdoc-openapi)

---

## Services & Ports

| Eureka Server | 8761 |
| API Gateway | 8080 |
| Order Service | 8081 |
| User Service | 8082 |
| Product Service | 8083 |

---

## 🔹 Eureka Server
- Central service registry
- Services register automatically
- Dashboard: http://localhost:8761

---

## 🔹 API Gateway
- Single entry point
- Routes via Eureka
- Circuit breaker enabled
- Path rewriting supported

## API Endpoints
- POST `/api/v1/orders`
- GET `/api/v1/orders`
- GET `/api/v1/orders/{id}`
- PUT `/api/v1/orders/{id}`
- DELETE `/api/v1/orders/{id}`

---

## Running the Applicatison
1. Configure MySQL in `application.properties`
2. Run:

App runs on `http://localhost:8081`

---

## Actuator Endpoints
/actuator/health  
/actuator/metrics

## Swagger UI:
http://localhost:8081/swagger-ui/index.html
---


