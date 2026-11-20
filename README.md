# Fintrix – Business Finance Management System

Fintrix is a comprehensive business finance management application designed to simplify and streamline financial operations. It aims to help businesses manage expenses, invoices, income, budgets, taxes, transactions, and accounts while providing financial reports and analytics to support informed decision-making.

---

## Table of Contents

1. [Overview](#overview)
2. [Objectives](#objectives)
3. [Features](#features)
4. [Technology Stack](#technology-stack)
5. [Project Architecture](#project-architecture)
6. [Project Structure](#project-structure)
7. [User Roles](#user-roles)
8. [Installation and Setup](#installation-and-setup)
9. [Running the Application](#running-the-application)
10. [Development Roadmap](#development-roadmap)
11. [Security Considerations](#security-considerations)
12. [Contributing](#contributing)
13. [License](#license)

---

## Overview

Fintrix aims to provide a centralized platform for managing essential business financial activities.

The application is organized into independent modules, each responsible for a particular financial operation. These modules are designed to work together to maintain consistency across financial records and simplify business management.

The system is being developed using Java and Maven, with an initial focus on user authentication and financial data management.

## Objectives

- Centralize business financial operations.
- Simplify income and expense tracking.
- Automate invoice generation and payment tracking.
- Maintain accurate accounting records.
- Monitor budgets and financial performance.
- Generate financial statements and analytical reports.
- Implement role-based access control.
- Maintain secure and reliable financial records.

## Features

### 1. User Management
- User registration and authentication.
- Secure password hashing.
- Role-based access control.
- User account management.
- Session management.

### 2. Accounting Engine
- Chart of accounts.
- Double-entry bookkeeping.
- Journal entry management.
- General ledger management.
- Trial balance generation.
- Accounting period management.

### 3. Expense Management
- Expense creation, editing, and deletion.
- Expense categorization.
- Recurring expense tracking.
- Expense document uploads.
- Spending analysis.

### 4. Income and Revenue Management
- Income and sales recording.
- Revenue categorization.
- Customer payment tracking.
- Revenue comparisons.
- Revenue analysis and forecasting.

### 5. Invoice Management
- Invoice generation.
- Invoice total calculation.
- PDF invoice generation.
- Invoice lifecycle management.
- Payment allocation.
- Recurring invoice support.

### 6. Accounts Payable and Receivable
- Vendor bill management.
- Outstanding invoice tracking.
- Payment reminders.
- Supplier payment scheduling.
- Overdue balance monitoring.

### 7. Budget Management
- Budget creation and allocation.
- Budget category management.
- Budget comparison.
- Budget alerts.
- Financial limit monitoring.

### 8. Bank Management
- Bank account management.
- Bank transaction tracking.
- Bank reconciliation.
- Bank statement importing.
- Cash management.
- Fund transfers.

### 9. Tax Management
- GST calculation.
- CGST, SGST, and IGST calculation.
- Tax configuration.
- Tax transaction tracking.
- GST report generation.
- Tax summaries.

### 10. Financial Reports and Analytics
- Balance sheet preparation.
- Profit and loss statements.
- Cash flow statements.
- Expense and revenue reports.
- Financial comparisons.
- Tax summaries and transaction registers.

### 11. Dashboard
- Total revenue and expenses.
- Net profit or loss.
- Available cash and bank balances.
- Monthly financial summaries.
- Income versus expenditure charts.
- Pending payments and receivables.

### 12. Audit and Document Management
- Activity history.
- Audit logging.
- Document storage and validation.
- PDF processing.
- OCR-based document processing.

---

## Technology Stack

| Technology | Purpose |
|---|---|
| Java 25 | Core application development |
| Apache Maven | Dependency and build management |
| Apache POI 5.4.1 | Excel workbook operations |
| jBCrypt 0.4 | Password hashing |
| Git | Version control |
| GitHub | Source code hosting |
| VS Code | Development environment |

Additional technologies may be introduced as the project develops.

---

## Project Architecture

Fintrix follows a modular architecture in which each package is responsible for a specific business function.

The application is divided into the following major components:

- **Application Layer:** Application entry point and coordination.
- **User Management Layer:** Authentication, authorization, and user administration.
- **Business Logic Layer:** Financial operations and business rules.
- **Accounting Layer:** Double-entry accounting and ledger operations.
- **Data Management Layer:** Data storage, retrieval, and database operations.
- **Reporting Layer:** Financial statements, reports, and analytics.

The modular design is intended to improve maintainability, scalability, and separation of responsibilities.

---

## Project Structure

```text
Fintrix/
│
├── .github/
│
├── data/
│   └── fintrix_users.xlsx
│
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── fintrix/
│                   │
│                   ├── App.java
│                   │
│                   ├── AccountingEngine/
│                   ├── AccountsPayableAndReceivable/
│                   ├── AuditManagement/
│                   ├── BankManagement/
│                   ├── BudgetManagement/
│                   ├── Dashboard/
│                   ├── Database/
│                   ├── DocumentManagement/
│                   ├── ExpenseManagement/
│                   ├── FinancialReportsAndAnalytics/
│                   ├── IncomeAndRevenueManagement/
│                   ├── InvoiceManagement/
│                   ├── TaxManagement/
│                   ├── TransactionManagement/
│                   ├── UserManagement/
│                   └── VendorAndCustomerManagement/
│
├── pom.xml
└── README.md
```

Each module contains classes responsible for its respective functionality.

---

## User Roles

Fintrix is designed to support role-based access control through three primary user roles.

| Role | Responsibilities |
|---|---|
| ADMIN | Manages users, application settings, and overall financial operations. |
| MANAGER | Oversees financial activities, manages operations, and approves transactions. |
| EMPLOYEE | Performs assigned tasks, records expenses, and accesses permitted information. |

Access to application features will be controlled according to the permissions assigned to each role.

---

## Installation and Setup

### Prerequisites

Ensure that the following software is installed:

- Java Development Kit (JDK) 25 or later.
- Apache Maven.
- Git.
- Visual Studio Code or another Java-compatible IDE.

### 1. Clone the Repository

```bash
git clone https://github.com/28-Sounak/Fintrix.git
```

### 2. Navigate to the Project Directory

```bash
cd Fintrix
```

### 3. Install Dependencies

Maven automatically downloads the dependencies specified in `pom.xml`.

```bash
mvn clean install
```

### 4. Compile the Project

```bash
mvn clean compile
```

---

## Running the Application

To execute the application, run:

```bash
java -cp target/classes com.fintrix.App
```

To compile the project before running:

```bash
mvn clean compile
```

---

## Development Roadmap

The project is being developed incrementally.

- [x] Initial Maven project setup.
- [x] Modular package structure.
- [x] Initial user and role model classes.
- [ ] Password hashing implementation.
- [ ] Excel-based user repository.
- [ ] User registration.
- [ ] User authentication.
- [ ] Session management.
- [ ] Role-based authorization.
- [ ] Database integration.
- [ ] Expense management implementation.
- [ ] Income and revenue management.
- [ ] Invoice management.
- [ ] Accounting engine implementation.
- [ ] Bank and transaction management.
- [ ] Budget and tax management.
- [ ] Financial reports and analytics.
- [ ] Dashboard implementation.
- [ ] Automated testing.
- [ ] Application-wide integration.

The checklist reflects development progress and will be updated as functionality is implemented and tested.

---

## Security Considerations

Fintrix is being designed with security and financial data integrity in mind.

Planned security measures include:

- BCrypt-based password hashing.
- Role-based access control.
- Input validation.
- Authentication and session management.
- Audit logging.
- Restricted access to sensitive financial records.
- Secure data storage and backup mechanisms.

The current Excel-based user storage is intended for initial development and prototyping. A database-backed repository is planned for more reliable persistence and concurrent access.

---

## Contributing

Contributions, suggestions, and improvements are welcome.

To contribute:

1. Fork the repository.
2. Create a new feature branch.
3. Implement your changes.
4. Test your implementation.
5. Submit a pull request with a clear description of the changes.

---

## License

This project is currently under development. Licensing information will be added when the project license is finalized.

---

**Project:** Fintrix – Business Finance Management System  
**Version:** 1.0.0  
**Language:** Java  
**Build Tool:** Apache Maven  
**Repository:** [GitHub – Fintrix](https://github.com/28-Sounak/Fintrix)