import React from "react";

function SearchBar({ city, setCity, onSearch }) {
  return (
    <div className="search-bar">
      <input
        type="text"
        value={city}
        placeholder="Enter city name"
        onChange={(e) => setCity(e.target.value)}
      />
      <button onClick={onSearch}>Search</button>
    </div>
  );
}

export default SearchBar;
