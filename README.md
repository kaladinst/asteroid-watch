# 🌑 NASA Asteroid Watch System

> A Spring Boot application that monitors Near-Earth Objects (NEOs) in real-time using NASA's NeoWs API.


![WhatsApp Image 2026-02-10 at 13 31 41](https://github.com/user-attachments/assets/be0b4c0c-cc24-49d0-b796-afdd17fdbdb7)

## 🚀 Overview
This system acts as an automated "Sentry" for Earth. It connects to NASA's servers daily, analyzes passing asteroids, and filters them to identify potentially hazardous objects.

It is built as a **full-stack application** with a Java backend handling the complex data processing and a responsive dashboard for visualization.

## 🛠 Tech Stack
* **Backend:** Java 23, Spring Boot 3.2
* **Database:** H2 In-Memory Database (JPA/Hibernate)
* **API:** NASA NeoWs (Near Earth Object Web Service)
* **Frontend:** HTML5, CSS3, JavaScript (Fetch API)
* **Tools:** Maven, Lombok, IntelliJ IDEA

## ✨ Key Features
* **Automated Scheduling:** Runs a cron job every day at 10:00 AM to fetch the latest data.
* **Hazard Detection:** Automatically flags asteroids based on NASA's "Potentially Hazardous" classification.
* **Data Pipeline:** ETL (Extract, Transform, Load) process from NASA JSON -> Java Objects -> SQL Database.
* **REST API:** Exposes endpoints (e.g., `/asteroids`) for frontend consumption.
* **Interactive Dashboard:** Dark-mode UI that visualizes threat levels with dynamic CSS.

## ⚙️ How to Run
1.  **Clone the repository**
    ```bash
    git clone [https://github.com/kaladinst/asteroid-watch.git](https://github.com/kaladinst/asteroid-watch.git)
    ```
2.  **Configure API Key**
    * Get a free key from [api.nasa.gov](https://api.nasa.gov/).
    * Open `src/main/resources/application.properties` and add:
        ```properties
        nasa.api.key=YOUR_API_KEY
        ```
3.  **Build & Run**
    ```bash
    mvn spring-boot:run
    ```
4.  **Access the Dashboard**
    * Open `http://localhost:8080/index.html` in your browser.

## 📐 Architecture
`NASA API` ➡ `Spring Service (ETL)` ➡ `H2 Database` ➡ `REST Controller` ➡ `Browser`

---
*Created by [Emir Duman](https://github.com/kaladinst)*
