import React, { useState } from "react";
import SearchBar from "./components/SearchBar";
import CityList from "./components/CityList";
import AirQualityCard from "./components/AirQualityCard";
import { searchCity, getAirQuality } from "./api/api";
import "./App.css";

function App() {
  const [city, setCity] = useState("");
  const [cities, setCities] = useState([]);
  const [aqi, setAqi] = useState(null);
  const [selectedCityId, setSelectedCityId] = useState(null);

  const handleSearch = async () => {
    setAqi(null);
    setSelectedCityId(null);
    const result = await searchCity(city);
    setCities(result);
  };

  const handleCitySelect = async (id) => {
    setSelectedCityId(id);
    const data = await getAirQuality(id);
    setAqi(data);
  };

  return (
    <div className="App">
      <h1>Air Quality Search</h1>

      <SearchBar city={city} setCity={setCity} onSearch={handleSearch} />

      <div className="dashboard-container">
        <div className="left-panel">
          <CityList 
            cities={cities} 
            onSelect={handleCitySelect} 
            selectedCityId={selectedCityId}
          />
        </div>

        <div className="right-panel">
          {aqi && <AirQualityCard data={aqi} />}
        </div>
      </div>
    </div>
  );
}

export default App;
 