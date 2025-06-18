🚗 CarChoice-Hub
Overview
The CarChoice-Hub is a Spring Boot-based REST API designed to manage car and customer information for a car dealership or loan management system.
It provides functionalities such as adding, updating, retrieving, deleting car and customer details, checking car price range, and tracking customer loan approval status.

Features
Add new cars and customers to the system.

Update existing car and customer details.

Retrieve information using various filters (ID, price range, loan status).

Delete car or customer records.

Check car availability by price range.

Track customers by loan approval status.

Customer login functionality.

Exit API to safely terminate the application.

Technologies Used
Backend: Spring Boot, Hibernate, MySQL

API Testing: Postman

Setup Instructions
Clone the Repository:

sh
Copy
Edit
git clone https://github.com/your-username/CarChoice-Hub.git
Navigate to the Project Directory:

sh
Copy
Edit
cd CarChoice-Hub
Configure Database:

Update application.properties with your MySQL database credentials.

Build and Run the Application:

sh
Copy
Edit
mvn spring-boot:run
Access APIs via Postman or Browser:

Example endpoint: http://localhost:8080/car/getAll

API Endpoints
🔹 Car APIs
1. Add a Car
URL: /car/insertCar

Method: POST

Request Body:

json
Copy
Edit
{
  "model": "Hyundai Creta",
  "brand": "Hyundai",
  "price": 1350000,
  "fuelType": "Petrol",
  "transmission": "Manual"
}
2. Get All Cars
URL: /car/getAll

Method: GET

3. Get a Car by ID
URL: /car/byId/{id}

Method: GET

4. Update a Car
URL: /car/updateCar/{id}

Method: PUT

Request Body (Example):

json
Copy
Edit
{
  "model": "Updated Creta",
  "price": 1450000
}
5. Delete a Car
URL: /car/deleteCar/{id}

Method: DELETE

6. Get Cars by Price Range
URL: /car/price/{startPrice}/{endPrice}

Method: GET

7. Exit API
URL: /car/exit

Method: POST

Description: Safely terminates the application.

