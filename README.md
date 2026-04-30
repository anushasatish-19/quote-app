#  CI/CD Pipeline for Spring Boot Application using Jenkins, Docker & AWS ECS

##  Project Overview

This project demonstrates an end-to-end **CI/CD pipeline** for a Spring Boot application.
The pipeline automates build, test, containerization, and deployment to AWS.

A simple Quote Generator REST API is used as the application to focus on DevOps practices rather than complex business logic.

---

##  Architecture Flow

```
Developer → GitHub Push → Jenkins (Webhook Trigger)
→ Maven Build & Test
→ SonarQube analysis with enforced Quality Gates
→ Docker Image Build
→ Push to Amazon ECR
→ Deploy to Amazon ECS
→ Application Accessible via Endpoint
```

---

##  Tech Stack

* **Backend:** Java, Spring Boot
* **Build Tool:** Maven
* **CI/CD:** Jenkins
* **Containerization:** Docker
* **Cloud:** AWS

  * Amazon ECR (Container Registry)
  * Amazon ECS (Container Orchestration)

---

##  Application Details

This is a simple REST API that manages quotes.

###  Endpoints

* `GET /quotes` → Fetch all quotes
* `POST /quotes` → Add a new quote

---

##  Dockerization

The application is containerized using Docker.

### Build Image

```
docker build -t quote-app .
```

### Run Container

```
docker run -p 8080:8080 quote-app
```

---

##  CI/CD Pipeline (Jenkins)

The pipeline automates:

* Source code checkout from GitHub
* Build using Maven
* Run tests
* Enforced Quality Gates to block deployment on code issues
* Build Docker image
* Push image to Amazon ECR
* Deploy latest image to Amazon ECS

---

##  AWS Deployment

* Docker images are stored in **Amazon ECR**
* Application is deployed using **Amazon ECS**
* ECS service ensures high availability and scalability

---

##  Screenshots
<p align="center">
 ### 1. Jenkins pipeline execution
 <img alt="cicd-pipeline-jenkins" src="https://github.com/user-attachments/assets/005d740f-ab9d-4767-8dca-07233098864c"        width="800" />
 <br>
 ### 2. Sonar Dashboard
 <img width="800" alt="Sonar-server" src="https://github.com/user-attachments/assets/8b8aceb0-8b00-4e86-b206-cb10a084eb91" />
 <br>
 ### 3. Application output in browser
 <img width="400" alt="application" src="https://github.com/user-attachments/assets/e2274bda-25c2-4d9a-a00f-86e375fbdf29" />
 <br>
</p?

* Docker build logs
* ECS service running

---

##  Project Structure

```
quote-app/
├── src/
├── pom.xml
├── Dockerfile
├── Jenkinsfile
└── README.md
```

---

##  How to Run Locally

### 1. Build the project

```
mvn clean package
```

### 2. Run the application

```
java -jar target/*.jar
```

### 3. Access API

```
http://localhost:8080/quotes
```

---

##  Key Learnings

* Implemented end-to-end CI/CD pipeline
* Integrated Docker with Jenkins
* Deployed containerized application on AWS ECS
* Understood cloud-based deployment workflows

---

##  Note

This project focuses on **DevOps pipeline implementation**.
The application is intentionally kept simple to highlight automation, containerization, and cloud deployment.

---

##  Author

GitHub: https://github.com/anushasatish-19

