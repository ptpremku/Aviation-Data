import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;

public class Main {
    public static void main(String[] args) {
        // Making the API call
        HttpResponse<String> response = Unirest.get("https://aviation-reference-data.p.rapidapi.com/airports/search?lat=-54.810&lon=-68.315&radius=100")
                .header("X-RapidAPI-Key", "e335238e38msh8c1b127fe2e2215p129e09jsnaf8ccd0edf0a")
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
        }

        System.out.println("Response code: " + response.getStatus());
        System.out.println("Response body: " + response.getBody());
    }
}
