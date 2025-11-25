🌤️ Air Quality Search – Frontend (ReactJS)

This folder contains the ReactJS frontend for the Air Quality Search Application.
The UI allows users to search for any city, view matching results, and see the air quality details of a selected city.

🚀 Features

🔍 Search for a city

📍 Display a list of matching cities from backend API

📊 View AQI details with color-coded background (Good / Moderate / Unhealthy / Hazardous)

⭐ Selected city is highlighted in the city list

🧩 Pollutants displayed in a clean 2-column grid

🎨 Smooth, modern UI built with simple CSS

🔗 Fully connected to the Spring Boot backend

🛠️ Tech Stack

ReactJS (Create React App)

JavaScript (ES6+)

CSS3

Fetch API (for backend calls)

📦 Project Structure
frontend/
│
├── public/
├── src/
│   ├── api/
│   │    └── api.js             # Backend API calls
│   ├── components/
│   │    ├── SearchBar.js
│   │    ├── CityList.js
│   │    └── AirQualityCard.js
│   ├── App.js
│   ├── App.css
│   ├── index.js
│   └── index.css
│
└── package.json

▶️ How to Run the Frontend

Make sure your backend is running first on:

http://localhost:8080


Then run the frontend:

1️⃣ Navigate to the frontend folder
cd frontend

2️⃣ Install dependencies
npm install

3️⃣ Start the development server
npm start


Your frontend will open automatically at:

👉 http://localhost:3000

🔗 Backend API Used

The frontend calls the following endpoints:

Get city list by search:
GET /api/air-quality/search?city={cityName}

Get AQI for a selected city:
GET /api/air-quality/{cityId}

🏗️ Build for Production

To generate the optimized production build:

npm run build


Output will be inside:

frontend/build/

📄 License

This frontend is part of the Air Quality Search Full-Stack Application.