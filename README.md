# ✅ CarChoice-Hub 🚗

**CarChoice-Hub** is a Spring Boot project that helps manage **Car** and **Customer** entities with full CRUD operations. It also includes features such as:

- 🔍 Car price range filtering  
- 🔐 Customer login  
- 📝 Customer loan approval status filter  
- 🛑 Graceful project exit via API  

---

## 📌 Technologies Used

- Java 17+  
- Spring Boot  
- Spring Web  
- Spring Validation (Jakarta)  
- Hibernate / JPA (via DAO layer)  
- MySQL (assumed for persistence)  
- Postman (for testing APIs)  

---

## 🔧 Project Structure

```
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
```

---

## 📚 API Endpoints

### 🚗 Car APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/car/insertCar` | Insert new car |
| PUT    | `/car/updateCar/{id}` | Update car by ID |
| DELETE | `/car/deleteCar/{id}` | Delete car by ID |
| GET    | `/car/byId/{id}` | Get car by ID |
| GET    | `/car/getAll` | Get all cars |
| GET    | `/car/price/{startPrice}/{endPrice}` | Get cars by price range |
| POST   | `/car/exit` | Shutdown application |

### 👤 Customer APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST   | `/customer/insertCustomer` | Insert new customer |
| PUT    | `/customer/updateCustomer/{id}` | Update customer by ID |
| DELETE | `/customer/deleteCustomer/{id}` | Delete customer by ID |
| GET    | `/customer/getCustomerById/{id}` | Get customer by ID |
| GET    | `/customer/getAllCustomer` | Get all customers |
| POST   | `/customer/login` | Login (basic check) |
| GET    | `/customer/status/{loanApprovalStatus}` | Get customers by loan status |
| POST   | `/customer/exit` | Shutdown application |

---

## 🔐 Validation & DTO

All insert/update APIs use `@Valid` for validating request bodies.

DTOs are used to ensure clean and specific update operations:

- `CarUpdateDTO`  
- `CustomerUpdateDTO`

---

## 🚀 How to Run the Project

### 1. Clone this repository:

```bash
git clone https://github.com/your-username/CarChoice-Hub.git
cd CarChoice-Hub
```

### 2. Configure the database

Update the `application.properties` file with your MySQL DB credentials.

### 3. Run the project

Use your IDE or terminal:

```bash
mvn spring-boot:run
```

### 4. Test the APIs

Use **Postman** or your browser to test the endpoints.

---

## ✅ Sample JSONs

### ➕ Insert Car

```json
{
    "brand": "Škoda",
    "model": "Kushaq",
    "fuelType": "Petrol",
    "seatCapacity": "5",
    "enginePower": "1498",
    "price": "1150000"
}
```

### ➕ Insert Customer

```json
{
  "fullName": "Anjali Sharma",
  "email": "anjalisharma@example.com",
  "phoneNumber": "9123456789",
  "address": "12 Rose Garden, New Delhi",
  "pinCode": "110001",
  "enquiryDate": "2024-12-18",
  "paymentMethod": "Cash on Delivery",
  "testDriveInterest": "No",
  "testDriveDate": "2024-12-29",
  "testDriveResult": "Neutral",
  "downPaymentAmount": 1800.00,
  "loanProvider": "ICICI Bank",
  "loanApprovalStatus": "Pending",
  "monthlyInstallmentBudget": 550.00,
  "customerCategory": "Middle Class",
  "car": {
    "id": 1
  }
}
```

---

## ✍️ Author

**Samarth Prabhakar Ghule**  
Java Full Stack Developer | Kiran Academy, Pune  
🎓 MCA Student | BCA Graduate  
📧 **Email**: [samarthghule89@gmail.com](mailto:samarthghule89@gmail.com)  
📱 **Mobile**: +91 8080799587
