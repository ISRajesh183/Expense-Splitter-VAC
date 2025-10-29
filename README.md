#  Expense Splitter Web Application

A full-stack web application to manage shared expenses and balances among groups or friends.  
Built using **Spring Boot** for the backend and **Vue.js** for the frontend.

---

##  Project Structure
```
Expense-Splitter-VAC/
├── backend/        # Spring Boot backend (Java)
│   ├── src/
│   ├── pom.xml
│   └── ...
│
└── frontend/       # Vue.js frontend
    ├── src/
    ├── package.json
    └── ...
```
---

##  Features

-  Manage people and group expenses
-  Automatically calculate individual shares and balances
-  View detailed balance reports
-  Secure login with validation
-  Real-time updates (through REST endpoints)
-  Unit tests for both frontend and backend

---

##  Tech Stack

**Frontend:**
- Vue.js 3
- Vite
- Axios
- Jest (unit testing)

**Backend:**
- Spring Boot
- Spring Data JPA
- H2 / MySQL (configurable)
- Maven
- JUnit 5 (unit testing)

---

##  How to Run the Project

###  Backend Setup

1. Navigate to the backend folder:
   cd backend

2. Build and run the Spring Boot app:
   mvn spring-boot:run

3. Backend will start on:
   http://localhost:8080

---

###  Frontend Setup

1. Navigate to the frontend folder:
   cd frontend

2. Install dependencies:
   npm install

3. Start the development server:
   npm run dev

4. Frontend runs on:
   http://localhost:5173

---

##  Running Tests

### Backend Tests:
cd backend
mvn test

### Frontend Tests:
cd frontend
npm run test

---

##  License

This project is for academic and learning purposes.
You may modify or extend it freely with proper attribution.
