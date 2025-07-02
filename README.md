# 📝 To-Do List Application

A full-stack To-Do List web application built with **React** (frontend) and **Spring Boot** (backend).  
It allows users to manage their daily tasks efficiently — add, update, mark as completed, and delete tasks.

---

## 🚀 Features

- ➕ Add new tasks
- ✏️ Edit existing tasks
- ✅ Mark tasks as completed
- 🗑️ Delete completed or unwanted tasks
- 📋 Display all tasks clearly

---

## 🌐 Tech Stack

| Layer        | Technology           |
|--------------|----------------------|
| Frontend     | React, HTML, CSS     |
| Backend      | Spring Boot (Java)   |
| Database     | MySQL / H2           |
| Tools        | Git, GitHub, VS Code / IntelliJ |

---

## 📁 Folder Structure

```bash
To-Do-List/
├── backend/                     # Spring Boot application
│   ├── src/
│   │   └── main/java/com/example/todolist
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   ├── application.properties
│   └── pom.xml
├── frontend/                    # React application
│   ├── src/
│   │   ├── components/
│   │   ├── App.js
│   │   ├── index.js
│   │   └── styles/
│   ├── package.json
│   └── public/
└── README.md
