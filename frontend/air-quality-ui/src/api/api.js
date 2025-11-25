const BASE_URL = "http://localhost:8080/api/air-quality";

export async function searchCity(city) {
    const res = await fetch(`${BASE_URL}/search?city=${city}`);
    return res.json();
}

export async function getAirQuality(cityId) {
    const res = await fetch(`${BASE_URL}/${cityId}`);
    return res.json();
}
