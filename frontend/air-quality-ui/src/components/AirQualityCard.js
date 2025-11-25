import React from "react";

function getAQIClass(aqi) {
  if (aqi <= 50) return "good-bg";
  if (aqi <= 100) return "moderate-bg";
  if (aqi <= 200) return "unhealthy-bg";
  return "hazardous-bg";
}

function AirQualityCard({ data }) {
  if (!data) return null;

  return (
    <div className={`aq-card ${getAQIClass(data.aqi)}`}>
      <h2 className="aq-title">{data.cityName}</h2>

      <div className="badge">AQI: {data.aqi}</div>

      <p className="dominant-text">
        <strong>Dominant Pollutant:</strong> {data.dominantPollutant}
      </p>

      <h3 className="pollutant-title">Pollutants</h3>

      <div className="pollutant-grid">
        {data.pollutants &&
          Object.entries(data.pollutants).map(([key, val]) => (
            <div className="pollutant-item" key={key}>
              <span className="pollutant-name">{key.toUpperCase()}</span>
              <span className="pollutant-value">{val}</span>
            </div>
          ))}
      </div>
    </div>
  );
}

export default AirQualityCard;
