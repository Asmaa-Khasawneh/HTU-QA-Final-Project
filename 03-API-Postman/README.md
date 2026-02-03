# API Testing – Postman

This folder contains the Postman API testing implementation for the Loyalty+ Store backend using DummyJSON.

The collection covers authentication, core retail-related endpoints, and negative test scenarios, with automated assertions and environment variables.

---

## Folder Contents

- Postman Collection file  
- Postman Environment file  
- CSV file used for data-driven testing  
- Newman HTML report (generated separately)

---

## Environment Setup

The environment includes the following variables:
- baseUrl
- accessToken
- userId
- dynamic IDs used across requests

All requests are parameterized and do not contain hardcoded values.

---

## Authentication Flow

- Authentication is handled using the login endpoint.
- The access token is captured dynamically and stored as an environment variable.
- Protected endpoints use the Bearer token for authorization.

---

## Running the Collection

1. Import the Postman collection file.
2. Import the Postman environment file.
3. Import the CSV file used for data-driven testing.
4. Run the collection using Postman Runner or Newman.


---

## Data-Driven Testing

- A CSV file is used to perform data-driven testing for one endpoint.
- The collection runner iterates over the dataset and validates responses using automated tests.

---

## Notes & Assumptions

- DummyJSON simulates write operations and may not persist data.
- All test data used is non-sensitive and for testing purposes only.
