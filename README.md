# airqualitysearchapplication
A simple Air Quality Index (AQI) search app using Spring Boot and React. The backend provides fast, cached AQI data from external APIs, while the frontend offers a clean interface to search cities and view real-time air quality details.


🌍 Air Quality Search Application

A full-stack application that allows users to search any city and view live Air Quality Index (AQI) data.
Users can:

🔍 Search a city by name

📍 View a list of matching cities

💡 Select a city and view detailed AQI information

🎨 See colored AQI indication (Good / Moderate / Unhealthy / Hazardous)

📊 View pollutant values in a clean dashboard UI

This project is built using:

Component	Technology
Backend	Spring Boot (Java)
Frontend	ReactJS
Communication	REST API
Live AQI Source	WAQI.org API


📁 Project Structure
airqualitysearchapplication/
│
├── airqualitysearchapplication/
│   ├── src/
│   ├── pom.xml
│   └── README.md (Backend info)
│
├── frontend/
│   ├── src/
│   ├── public/
│   └── package.json
│
└── README.md (This file)

🔧 Requirements Before Running

Software	Required Version
Java	17 or above
Node.js	v16 or above
npm	6 or above
Git	Latest Version
Internet	Required for live AQI data


🚀 How to Run the Project (Step-by-Step for Beginners)

Follow each step exactly, even if you’ve never run a project before.

🟦 STEP 1 — Clone the Repository

Open Command Prompt / PowerShell and run:

git clone https://github.com/mr-vinay02/airqualitysearchapplication.git


Then go into the folder:

cd airqualitysearchapplication

🟩 STEP 2 — Run the Backend (Spring Boot API)

Go into backend folder:

cd airqualitysearchapplication

Configure your application.yml with your AQICN.org API token:

aqicn:
  api:
    base-url: https://api.waqi.info
    token: YOUR_API_TOKEN_HERE


(You can get the API token from: https://aqicn.org/data-platform/token/)

Start the backend:

./mvnw spring-boot:run


OR (if using IntelliJ):

Open project → Run AirQualityApplication.java

The backend will run at:

👉 http://localhost:8080

🟨 STEP 3 — Run the Frontend (React UI)

Open a new terminal (don’t close backend).

Go to frontend:

cd ../frontend


Install dependencies:

npm install


Start the app:

npm start


Frontend will open automatically at:

👉 http://localhost:3000

🎯 Application Workflow

User types a city name

Frontend sends request to backend:

GET /api/air-quality/search?city=Delhi


Backend fetches AQI data from WAQI API and returns results

User clicks a result → frontend calls:

GET /api/air-quality/{cityId}


Detailed AQI card shown (with color-coded background)

🧪 Testing

Backend testing via Postman or browser:

http://localhost:8080/api/air-quality/search?city=Bangalore


Frontend UI testing by selecting cities

📸 Features Preview

✔ Search bar centered
✔ Selectable city list
✔ Selected city highlighted
✔ AQI card with:

AQI Level	Color
0–50	🟢 Green (Good)
51–100	🟡 Moderate
101–200	🟠 Unhealthy
201+	🔴 Hazardous
📦 Build for Production

Backend:

cd backend
mvn clean package


Frontend:

cd frontend
npm run build

🤝 Contribution

Feel free to fork, improve UI, add charts, or optimize performance.

📝 License

This project is created for learning and demonstration purposes.

❤️ Made by Vinay
