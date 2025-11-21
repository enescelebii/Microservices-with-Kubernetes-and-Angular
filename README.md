# 🧩 Microservices with Spring Boot, Docker & Kubernetes

This repository contains a **Spring Boot-based Microservices Architecture** developed as a complete, production-grade project.  
It demonstrates how to design, build, secure, and deploy cloud-native microservices using **Spring Boot**, **Spring Cloud**, **Docker**, and **Kubernetes**.

<img width="2541" height="1062" alt="image" src="https://github.com/user-attachments/assets/72af3b64-5fdf-4f46-8d2c-a8f6f7cc81a5" />
<img width="1328" height="672" alt="image" src="https://github.com/user-attachments/assets/2ba97cae-7eb5-46e7-a8ff-2c6accc68a98" />


---

## 🚀 Project Overview

The project represents a **simple e-commerce platform**, where customers can browse products, place orders, and receive notifications.  
Each service focuses on its own responsibility, making the system scalable, fault-tolerant, and easy to maintain.

### 🧠 Core Microservices

- **Product Service** → Manages product catalog and details  
- **Order Service** → Handles order creation and management  
- **Inventory Service** → Tracks stock availability  
- **Notification Service** → Sends asynchronous notifications (via Kafka events)

---

## ⚙️ Tech Stack

| Layer | Technologies |
|-------|---------------|
| **Backend** | Spring Boot 3, Java 21 |
| **Inter-Service Communication** | Spring Cloud RestClient |
| **Service Discovery** | Spring Cloud Netflix Eureka |
| **API Gateway** | Spring Cloud Gateway |
| **Security** | Keycloak (OAuth2, OpenID Connect) |
| **Resilience** | Resilience4J (Circuit Breaker Pattern) |
| **Event-Driven Messaging** | Apache Kafka |
| **Database** | MySQL & MongoDB |
| **Observability** | OpenTelemetry, Grafana Tempo, Loki, Prometheus |
| **Containerization** | Docker, Docker Compose |
| **Orchestration** | Kubernetes |

---

## 🧱 Architecture Highlights

- **Microservices Communication:** Uses both synchronous (RestClient) and asynchronous (Kafka) patterns  
- **Centralized Authentication:** Managed via Keycloak for secure identity and access management  
- **Resilient Services:** Circuit Breaker and fault tolerance via Resilience4J  
- **Full Observability Stack:** Distributed tracing, logging, and metrics with Prometheus and Grafana  
- **Cloud-Native Deployment:** All services containerized and orchestrated via Kubernetes  


## 🧭 Architecture Diagram (coming soon)
- A visual diagram of microservices communication, Kafka event flow, and observability stack will be added soon.

## 👤 Author
- [Tutorial video from Techie](https://programmingtechie.com/)
- 📧 Enes Çelebi [Linkedin](https://www.linkedin.com/in/enescelebi1/)
- 💡 Passionate about Microservices, Cloud-Native Development, and Distributed Systems
