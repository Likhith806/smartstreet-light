# 🌃 Smart Street Light Management System

A full-stack web application to monitor and control smart street lights using intelligent brightness adjustment and a real-time dashboard.

---

## 🚀 Features

- 🔐 User Registration & Login (Full Stack Authentication)
- 💡 Add and manage street lights
- 🔄 Toggle lights ON/OFF
- 🧠 AI-based brightness control
- 📊 Dashboard with real-time data visualization
- 🗑 Clear all lights functionality
- 🎨 Modern UI with animations and glassmorphism

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- Hibernate

### Frontend
- HTML
- CSS
- JavaScript
- Chart.js

### Database
- MySQL

---

## 📂 Project Structure

```text
smart-light/
│
├── src/
│   └── main/
│       ├── java/
│       │   └── com/smartlight/
│       │       ├── controller/      # REST APIs (UserController, StreetLightController)
│       │       ├── service/         # Business logic layer
│       │       ├── repository/      # JPA repositories (DB access)
│       │       ├── entity/          # Entity classes (User, StreetLight)
│       │       └── SmartLightApplication.java
│       │
│       └── resources/
│           ├── static/              # Frontend (HTML, CSS, JS)
│           │   ├── index.html
│           │   ├── login.html
│           │   ├── register.html
│           │   ├── script.js
│           │   └── style.css
│           │
│           └── application.properties   # DB & server configuration
│
├── pom.xml                          # Maven dependencies
└── README.md                        # Project documentation
```
