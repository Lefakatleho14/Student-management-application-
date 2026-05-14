# Student Management Application

## 📌 Project Overview
An enterprise-ready Java application designed to streamline student administration through a centralized relational database. This project demonstrates full **CRUD (Create, Read, Update, Delete)** capabilities, secure data persistence, and a modular architecture suitable for scalable software systems.

## 🚀 Key Features
*   **Comprehensive Student Tracking:** Manage student profiles, enrollment status, and academic records.
*   **Relational Database Integration:** Powered by SQL to ensure 100% data integrity and persistence.
*   **Secure Data Handling:** Implementation of Prepared Statements to safeguard against SQL injection.
*   **Modular Design:** Separated layers for Business Logic and Data Access (DAO) to enhance code reusability.

## 🛠 Tech Stack
*   **Backend:** Java (JDK 11+)
*   **Database:** MySQL / MSSQL (Relational)
*   **Version Control:** Git & GitHub
*   **IDE:** Visual Studio Code / NetBeans

## 🏗 System Architecture
The application is built using a **Tiered Architecture**:
1.  **UI/Presentation:** Console-based interface for user interaction.
2.  **Service Layer:** Validates business rules and processes student data.
3.  **Data Access Layer (DAO):** Handles direct SQL queries and database connectivity.

## 🔄 System Workflow
1. **User Interaction:** The user selects "Add Student" in the console.
2. **Controller Logic:** The application prompts for Name, ID, and Course.
3. **Validation:** The system checks if the ID already exists or if fields are empty.
4. **Data Access:** The `StudentService` calls `StudentDAO.save()`.
5. **Persistence:** An `INSERT` SQL query is executed via JDBC with Prepared Statements.
6. **Feedback:** The database returns a success code, and the UI displays "Student Added Successfully."


## 📋 Installation
1. Clone the repository:
   ```bash
   git clone [https://github.com/Lefakatleho14/Student-management-application-.git](https://github.com/Lefakatleho14/Student-management-application-.git)
