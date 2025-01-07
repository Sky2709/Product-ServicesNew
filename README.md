# **Product Service**

**Description**

The Product Service is a backend application built using Spring Boot, providing functionalities to manage products and
integrate with third-party APIs for product data. This service is designed to handle product operations, including
CRUD (Create, Read, Update, Delete) operations, and is extendable to support additional third-party product services in
the future.

**Features**

* Manage Products: Create, retrieve, update, and delete product information.
* Third-party API Integration: Fetch product data from external APIs like Fake Store API.
* Extensible Product Service Architecture: Easily integrate with additional third-party product services.

**Tech Stack**

* Languages: Java
* Frameworks: Spring Boot
* Database: MySQL
* Third-party APIs: Fake Store API
* Build Tool: Maven

**Setup Instructions**

1. Clone the repository.
   `git clone https://github.com/Sky2709/Product-service.git
   cd Product-service`
2. Build the project:
   `./mvnw clean install`
3. Configure environment variables:
   Set the necessary configurations in the application.properties file for connecting with third-party APIs:
   `fakeStore.api.url=https://fakestoreapi.com
   fakeStore.api.paths.products=/products
   fakeStore.api.paths.categories=/categories`
4. Run the application:
   `./mvnw spring-boot:run`

**Usage Instructions**

* Manage Products:
  -> Get All Products: Use the endpoint:
  `GET /products/`
  -> Get Product by ID: Use the endpoint:
  `GET /products/{id}`
  -> Add New Product: Use the endpoint:
  `POST /products/`
  Request Body:
  `{  
  "title": "New Product",  
  "price": 2000,  
  "category": "Electronics",  
  "description": "A new electronic product.",  
  "image": "image_url_here"  
  }`
  -> Update Product: Use the endpoint:
  `PUT /products/{id}`
  Request Body:
  `{  
  "title": "Updated Product",  
  "price": 2500,  
  "category": "Electronics",  
  "description": "Updated product description.",  
  "image": "updated_image_url_here"  
  }`
  -> Delete Product: Use the endpoint:
  `DELETE /products/{id}`

* Third-party API Integration:
  -> Fetch product data from the Fake Store API using endpoints:
  `GET /products/, GET /categories/, and GET /products/category/{name}.`

**Architecture**

* The service follows a modular architecture:
* Controller Layer: Handles HTTP requests and responses.
* Service Layer: Contains business logic and interacts with third-party APIs.
* Data Access Layer: Manages database interactions for product data.
* Third-party Integration: Implements the strategy for interacting with external APIs.

**Contribution**

* Contributions are welcome! Follow these steps:
* Fork the repository.
* Create a new branch: `git checkout -b feature-name`.
* Commit your changes: `git commit -m 'Add feature-name'`.
* Push to the branch: `git push origin feature-name`.
* Open a pull request.

**License**
This project is licensed under the MIT License.

**Contact**

* Author: Akash Kumar
* GitHub: [Sky2709](https://github.com/Sky2709)
* LinkedIn: [Akash Kumar](https://www.linkedin.com/in/akashkr98/)

**Future Plans**

* Enhance third-party API integration for additional product services.
* Improve product data management and validation.
* Add more product-related features such as filtering and sorting.





