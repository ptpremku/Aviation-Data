import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;

public class SearchORAutoCompleteAirlines {
    public void airlineLookup(String name, String APIKEY){

        System.out.println("\n");
        System.out.println("Loading....");
        System.out.println("\n");

        HttpResponse<String> response = Unirest.get("https://aviation-reference-data.p.rapidapi.com/airline/search?name=" + name)
                .header("X-RapidAPI-Key", APIKEY)
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
                    String alpha3countryCode = airport.get("alpha3countryCode").getAsString();
                    String callSign = airport.get("callSign").getAsString();
                    String iataCode = airport.get("iataCode").getAsString();
                    String icaoCode = airport.get("icaoCode").getAsString();
                    String airportName = airport.get("name").getAsString();


                    // Print the extracted information
                    System.out.println("Alpha 3 Country Code: " + alpha3countryCode);
                    System.out.println("Call Sign: " + callSign);
                    System.out.println("Iata Code: " + iataCode);
                    System.out.println("ICAO Code: " + icaoCode);
                    System.out.println("Airport Name: " + airportName);
                    System.out.println();
                }
            }
        } else {
            System.out.println("Error: No Airports Were Found or Something Went Wrong");
        }

    }
}
