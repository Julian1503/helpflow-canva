# **HelpFlow AI - Intelligent Help Content Tagging and Search**

Welcome to **HelpFlow AI**, a scalable and modular microservice designed to process help content, automatically tag it with relevant keywords using Natural Language Processing (NLP), and facilitate fast, intelligent search using Elasticsearch.

---

## **Project Overview**

HelpFlow AI consists of two main components:

1. **Backend Service**: A Java-based service built with Spring Boot to handle CRUD operations, Elasticsearch indexing, and integration with the AI service for tagging.
2. **AI Tagging Microservice**: A lightweight Python Flask application powered by spaCy for automatic tagging of content using NLP.

This project demonstrates modern microservice architecture with a focus on **scalability**, **modularity**, and **real-world use cases**, aligned with Canva's goals of enhancing content discoverability and user experience.

---

## **Features**

- **Content Management**: Add, edit, and manage help articles via a REST API.
- **Automatic Tagging**: Articles are analyzed using NLP, and relevant tags are generated.
- **Intelligent Search**: Elasticsearch provides fast and relevant search results, including recommendations.
- **Multi-language Support**: Supports both English and Spanish content.
- **Scalable Design**: Dockerized microservices for easy deployment and scaling.

---

## **Technologies Used**

### **Backend**
- **Java 23**: Main programming language.
- **Spring Boot**: REST API, data management, and Elasticsearch integration.
- **MySQL**: Relational database for content storage.
- **Elasticsearch**: Full-text search and recommendation engine.
- **Redis**: Caching for frequently accessed data.

### **AI Microservice**
- **Python 3.11**: Programming language for the AI service.
- **Flask**: Lightweight web framework for serving the NLP API.
- **spaCy**: NLP library for text processing and tagging.
- **Gunicorn**: Production-ready WSGI server.

### **DevOps**
- **Docker & Docker Compose**: Containerization for backend, AI service, MySQL, Elasticsearch, and Redis.
- **Postman**: API testing.
- **GitHub Actions**: CI/CD pipeline for automated testing and deployment.

---

## **System Architecture**

![System Architecture Diagram](assets/Diagram_Arch.png)

1. **User Requests**:
    - Users interact with the backend via REST APIs for adding or searching articles.
2. **Tagging Service**:
    - The backend sends article content to the AI microservice for automatic tagging.
3. **Search and Recommendations**:
    - Articles are indexed in Elasticsearch and searched for relevant results.

---

## **Class Diagram**

![Class Diagram](path/to/class-diagram.png)

The system is designed using clean architecture principles, separating concerns into distinct layers (controller, service, repository, and domain).

---

## **Setup and Installation**

### **1. Clone the repository**
```bash
git clone https://github.com/your-repo/helpflow-ai.git
cd helpflow-ai
```

### **2. Backend Setup**
- Navigate to the `backend` directory:
  ```bash
  cd backend
  ```
- Build and run the Spring Boot application:
  ```bash
  mvn spring-boot:run
  ```

### **3. AI Service Setup**
- Navigate to the `ai-tagging` directory:
  ```bash
  cd ai-tagging
  ```
- Install dependencies:
  ```bash
  pip install -r requirements.txt
  ```
- Run the Flask app:
  ```bash
  flask run
  ```

### **4. Run with Docker Compose**
To run the entire system (backend, AI service, MySQL, Elasticsearch, Redis) with Docker Compose:
```bash
docker-compose up
```

---

## **How to Use**

### **1. Add a Help Article**
Send a POST request to `/articles` (backend API) with the following payload:
```json
{
  "title": "How to use Canva",
  "content": "Canva is a great tool for designing.",
  "language": "en"
}
```

### **2. Search for Articles**
Send a GET request to `/search` with a query parameter:
```
/search?query=design
```

### **3. Automatic Tagging**
The AI microservice automatically generates tags for your articles, e.g., `"Canva", "design", "tool"`.

---

## **Testing**
Run the following to test the services:
- **Backend Tests**:
  ```bash
  mvn test
  ```
- **AI Service Tests**:
  ```bash
  pytest
  ```

---

## **Contributing**
Contributions are welcome! Please create a pull request or open an issue for suggestions or bug reports.

---

## **License**
This project is licensed under the MIT License. See `LICENSE` for more details.

---

If you need any further clarification or adjustments, let me know! 🚀