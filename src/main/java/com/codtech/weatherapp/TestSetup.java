package com.codtech.weatherapp;

import java.util.Scanner;

public class TestSetup {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter city names (comma-separated, e.g., Hyderabad,Mumbai,New York): ");
        String input = scanner.nextLine();

        // Split input by comma and trim spaces
        String[] cities = input.split(",");

        for (String city : cities) {
            city = city.trim();
            if (!city.isEmpty()) {
                try {
                    System.out.println(weatherService.getWeather(city));
                } catch (Exception e) {
                    System.out.println("Error: Unable to retrieve weather data for " + city);
                }
                System.out.println("---------------------------");
            }
        }
    }
}
