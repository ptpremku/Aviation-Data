import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;

public class AirportSearchByLocationCoordinates {

    public void findAirport(double lat, double lon, int radius, String key) {

        String responseLink = "https://aviation-reference-data.p.rapidapi.com/airports/search?lat=" + lat + "&lon=" + lon + "&radius=" + radius;

        System.out.println("Loading....");

        HttpResponse<String> response = Unirest.get(responseLink)
                .header("X-RapidAPI-Key", key)
                .header("X-RapidAPI-Host", "aviation-reference-data.p.rapidapi.com")
                .asString();

        if (response.getStatus() == 200) {
            // Parse the response body to JSON
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(response.getBody(), JsonArray.class);

            // Iterate through each object in the array
            for (JsonElement element : jsonArray) {
                if (element instanceof JsonObject airport) {

                    // Extract specific fields from each object
                    String iataCode = airport.get("iataCode").getAsString();
                    String icaoCode = airport.get("icaoCode").getAsString();
                    String name = airport.get("name").getAsString();
                    String countryCode = airport.get("alpha2countryCode").getAsString();
                    double latitude = airport.get("latitude").getAsDouble();
                    double longitude = airport.get("longitude").getAsDouble();

                    // Print the extracted information
                    System.out.println("Airport: " + name);
                    System.out.println("IATA Code: " + iataCode);
                    System.out.println("ICAO Code: " + icaoCode);
                    System.out.println("Country Code: " + countryCode);
                    System.out.println("Latitude: " + latitude);
                    System.out.println("Longitude: " + longitude);
                    System.out.println();
                }
            }
        } else {
            System.out.println("Error: " + response.getStatusText());
        }}
}
