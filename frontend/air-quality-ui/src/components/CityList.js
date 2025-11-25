import React from "react";

function CityList({ cities, onSelect, selectedCityId }) {
  return (
    <div className="city-list">
      {cities.map((c) => (
        <div
          key={c.cityId}
          className={`city-item ${selectedCityId === c.cityId ? "selected-city" : ""}`}
          onClick={() => onSelect(c.cityId)}
        >
          {c.cityName} ({c.latitude}, {c.longitude})
        </div>
      ))}
    </div>
  );
}

export default CityList;
