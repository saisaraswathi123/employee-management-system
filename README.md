#  Employee Management System

A full-stack **Role-Based Employee Management System** with authentication, CRUD operations, document upload, search/filtering, pagination, reporting, and Swagger API documentation.

---

##  Tech Stack

- **Backend**: Java (Spring Boot)
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Token)
- **Frontend**: HTML, CSS, JavaScript (Demo Interface)
- **API Docs**: Swagger UI

---

##  Features

- Defined project scope and user roles .
- Chose tech stack: Java + Spring Boot
- Designed wireframes and ER diagram
- Created DB schema and planned REST APIs
- Initialized Spring Boot project
- Implemented JWT-based authentication
- Created `User` model and `/auth/register`, `/auth/login` endpoints
- - Built CRUD APIs for:
  - **Employees**
  - **Departments**
  - **Roles**
- Connected backend to PostgreSQL
- Added resume/profile file upload API for employees
- Allowed assigning roles and departments to users
- Developed advanced search with filters:
- Filter by **Role**, **Department**, **Keyword**
- Added **Pagination** and **Sorting** support
- Generated reports using CSV and PDF
- Integrated **Swagger UI** for API testing and documentation
- Performed functional testing of all endpoints
- Prepared for deployment on GitHub
  
---

##  Project Structure
management/
├── src/
│ ├── main/java/com/employee/management/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ ├── service/
│ │ ├── config/
│ │ └── util/
│ └── resources/
│ ├── static/
│ ├── application.properties
│ └── templates/
├── uploads/
└── pom.xml

---

## Run the application (Spring Boot):
./mvnw spring-boot:run

---

## Access Swagger UI:
http://localhost:8080/swagger-ui/index.html

---

## Clone the repository:
git clone https://github.com/saisaraswathi123/employee-management-system.git
cd employee-management-system




