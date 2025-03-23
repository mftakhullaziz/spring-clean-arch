# 🧼 Java Clean Architecture – Project Structure

This project follows the principles of **Clean Architecture**, aiming to create a maintainable, testable, and scalable system by organizing code into well-defined, independent layers.

---

## 📚 Table of Contents

1. [Project Structure](#-project-structure)
2. [Core Layer (Enterprise Business Rules)](#-core--enterprise-business-rules)
3. [Delivery Layer (Interface Adapters)](#-delivery--interface-adapters)
4. [Domain Layer (DTOs & Models)](#-domain--dtos--models)
5. [Infrastructure Layer (Frameworks & Drivers)](#-infra--frameworks--drivers)
6. [Application Layer (Glue & Configuration)](#-app--application-layer-glue--configuration)

---

## 📁 Project Structure

```plaintext
javacleanarchitect/
├── CleanArchitectApplication.java
├── app/
│   ├── annotation/
│   │   ├── EntitiesBusiness.java
│   │   ├── Gateway.java
│   │   ├── RestHandler.java
│   │   └── Usecase.java
│   ├── config/
│   │   ├── PersistenceConfiguration.java
│   │   ├── SecurityConfiguration.java
│   │   ├── ServiceConfiguration.java
│   │   └── SpringFoxConfiguration.java
│   ├── constant/
│   │   └── RestConstant.java
│   └── property/
│       ├── GmailProperty.java
│       └── RedisProperty.java
├── core/
│   ├── entities/
│   │   └── account/
│   │       ├── AccountEntities.java
│   │       └── AccountEntitiesImpl.java
│   └── usecase/
│       ├── account/
│       │   ├── IAccountBoundary.java
│       │   ├── OAccountBoundary.java
│       │   └── AccountUsecase.java
│       └── order/
│           ├── IOrderBoundary.java
│           ├── OOrderBoundary.java
│           └── OrderUsecase.java
├── delivery/
│   ├── http/
│   │   ├── account/
│   │   │   ├── AccountController.java
│   │   │   └── AccountPresenter.java
│   │   └── order/
│   │       ├── OrderController.java
│   │       └── OrderPresenter.java
│   └── messaging/
│       └── OrderMessaging.java
├── domain/
│   ├── account/
│   │   ├── AccountDto.java
│   │   ├── AccountRequest.java
│   │   └── AccountResponse.java
│   └── order/
│       ├── OrderRequest.java
│       └── OrderResponse.java
└── infra/
    ├── client/
    │   ├── NotificationClient.java
    │   ├── ProductClient.java
    ├── gmail/
    │   ├── GoogleMailGateway.java
    │   └── GoogleMailGatewayImpl.java
    ├── midtrans/
    ├── mongodb/
    │   ├── object/
    │   │   └── AccountObject.java
    │   └── repo/
    │       └── AccountObjectRepository.java
    ├── mysql/
    │   ├── gateway/
    │   ├── persistence/
    │   └── repository/
    └── redis/
        ├── gateway/
        └── postgres/
```

## 🧠 `core/` — Enterprise Business Rules

This is the heart of the application, containing domain-specific business logic that is completely independent of external frameworks, databases, or delivery mechanisms.

### 🔹 `core/entities`
- Contains interfaces and business logic implementations for each domain (e.g., Account, Cart, Order).
- **Example:**
    - `AccountEntities.java`: Interface for account-related operations.
    - `AccountEntitiesImpl.java`: Implements business logic for accounts.

### 🔹 `core/usecase`
- Defines the business use cases and application services.
- Uses the **Boundary pattern** to separate input/output concerns:
    - `IAccountBoundary`: Input boundary interface (typically called by controllers).
    - `OAccountBoundary`: Output boundary interface (typically handled by presenters).
    - `AccountUsecase.java`: Implements account-related business use cases.

---

## 🚚 `delivery/` — Interface Adapters

The delivery layer adapts input from the outside world (e.g., HTTP, Messaging) into calls to the use case layer.

### 🔹 `delivery/http`
- **Controllers** handle incoming HTTP requests:
    - `AccountController`, `OrderController`.
- **Presenters** prepare output data for the response:
    - `AccountPresenter`, `OrderPresenter`.

### 🔹 `delivery/messaging`
- Messaging adapters handle incoming messages from message queues or event streams.
    - `OrderMessaging.java`: Handles order-related events/messages.

---

## 📦 `domain/` — DTOs & Models

This layer contains **data transfer objects (DTOs)** used across layers. These are plain Java objects (POJOs) and do not include any business logic.

- **Examples:**
    - `AccountDto`: Represents account data.
    - `AccountRequest`, `AccountResponse`: Used for HTTP request/response.
    - Same structure is applied to `Order` and other domains.

---

## 🏗️ `infra/` — Frameworks & Drivers

The infrastructure layer contains real implementations for external systems such as databases, APIs, cache services, and other communication drivers.

### 🔹 `infra/gmail`
- `GoogleMailGatewayImpl`: Sends emails via Gmail.

### 🔹 `infra/midtrans`
- Handles payment gateway integration with Midtrans.

### 🔹 `infra/mongodb`
- `AccountObject`: MongoDB document class.
- `AccountObjectRepository`: MongoDB data access.

### 🔹 `infra/mysql`
- `gateway/`: Implements gateway interfaces using JPA.
- `persistence/`: Logic for mapping domain to database.
- `repository/`: Spring Data JPA interfaces.

### 🔹 `infra/redis`
- Implements caching mechanism:
    - `RedisGateway`, `RedisGatewayImpl`, `RedisObject`.

### 🔹 `infra/client`
- Handles communication with other microservices (e.g., via REST, gRPC, Kafka).
- Contains client adapters and service consumers for inter-service communication.

---

## 🧩 `app/` — Application Layer (Glue & Configuration)

This layer ties all the components together, configuring Spring Boot and supporting features like properties, constants, and annotations.

### 🔹 `annotation/`
- Custom annotations to mark and categorize components:
    - `@EntitiesBusiness`, `@Usecase`, `@Gateway`, `@RestHandler`.

### 🔹 `config/`
- Spring Boot configuration classes:
    - `PersistenceConfiguration`: DB setup.
    - `SecurityConfiguration`: App security.
    - `ServiceConfiguration`: Service beans.
    - `SpringFoxConfiguration`: Swagger/OpenAPI docs.

### 🔹 `constant/`
- Shared constants, such as REST endpoint paths.

### 🔹 `property/`
- Binds Spring properties (from `application.yml`) to Java objects:
    - `GmailProperty`, `RedisProperty`.