Car-Choice Hub
CarChoice-Hub is a Spring Boot project that helps manage Car and Customer entities with full CRUD operations. It also includes features such as:

Car price range filtering

Customer login

Customer loan approval status filter

Graceful project exit via API

📌 Technologies Used
Java 17+

Spring Boot

Spring Web

Spring Validation (Jakarta)

Hibernate / JPA (via DAO layer)

MySQL (assumed for persistence)

Postman (for testing APIs)

🔧 Project Structure
Copy
Edit
com.tka.CarChoice_Hub2
│
├── controller
│   ├── CarController.java
│   └── CustomerController.java
│
├── service
│   ├── CarService.java
│   └── CustomerService.java
│
├── dao
│   ├── CarDao.java
│   └── CustomerDao.java
│
├── dto
│   ├── CarUpdateDTO.java
│   └── CustomerUpdateDTO.java
│
├── entity
│   ├── Car.java
│   └── Customer.java
📚 API Endpoints
🚗 Car APIs
Method	Endpoint	Description
POST	/car/insertCar	Insert new car
PUT	/car/updateCar/{id}	Update car by ID
DELETE	/car/deleteCar/{id}	Delete car by ID
GET	/car/byId/{id}	Get car by ID
GET	/car/getAll	Get all cars
GET	/car/price/{startPrice}/{endPrice}	Get cars by price range
POST	/car/exit	Shutdown application

👤 Customer APIs
Method	Endpoint	Description
POST	/customer/insertCustomer	Insert new customer
PUT	/customer/updateCustomer/{id}	Update customer by ID
DELETE	/customer/deleteCustomer/{id}	Delete customer by ID
GET	/customer/getCustomerById/{id}	Get customer by ID
GET	/customer/getAllCustomer	Get all customers
POST	/customer/login	Login (basic check)
GET	/customer/status/{loanApprovalStatus}	Get customers by loan approval status
POST	/customer/exit	Shutdown application

🔐 Validation & DTO
All insert/update APIs use @Valid to validate request bodies.

DTOs are used to ensure clean update operations:

CarUpdateDTO

CustomerUpdateDTO

📌 How to Run the Project
Clone this repo:

bash
Copy
Edit
git clone https://github.com/your-username/CarChoice-Hub.git
cd CarChoice-Hub
Update application.properties with your DB credentials.

Run the project using your IDE or:

bash
Copy
Edit
mvn spring-boot:run
Use Postman to test the endpoints.

✅ Sample JSON (Insert Car)
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
✅ Sample JSON (Insert Customer)
json
Copy
Edit
{
  "name": "Samarth Ghule",
  "email": "samarth@example.com",
  "password": "samarth@123",
  "phoneNumber": "9876543210",
  "loanApprovalStatus": "Approved"
}
✍️ Author
Samarth Prabhakar Ghule
Java Full Stack Developer | Kiran Academy, Pune
📧 Email: samarthghule89@gmail.com
📱 Mobile: +91 8080799587
🎓 MCA Student | BCA Graduate

📄 License
This project is open-source and free to use under the MIT License.

Let me know if you want:

Swagger integration

SQL schema

DTO and Entity examples

Exception handling using @ControllerAdvice
