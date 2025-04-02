package com.codtech.weatherapp;

	import com.google.gson.JsonObject;
	import com.google.gson.JsonParser;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;

	public class WeatherService {
	    
	    private static final String API_KEY = "3a0990f489c8af2b0c27b8421a15cceb"; 
	    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

	    public String getWeather(String city) {
	        try {
	            String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
	            URL url = new URL(urlString);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("GET");

	            if (connection.getResponseCode() == 200) {
	                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
	                JsonObject responseJson = JsonParser.parseReader(reader).getAsJsonObject();

	                String cityName = responseJson.get("name").getAsString();
	                JsonObject main = responseJson.getAsJsonObject("main");
	                double temperature = main.get("temp").getAsDouble();
	                double feelsLike = main.get("feels_like").getAsDouble();

	                return "City: " + cityName + "\nTemperature: " + temperature + "°C\nFeels Like: " + feelsLike + "°C";
	            } else {
	                return "Error: Unable to retrieve weather data.";
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error: An exception occurred.";
	        }
	    }
	}


