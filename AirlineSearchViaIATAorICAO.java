import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;

public class AirlineSearchViaIATAorICAO {

    public void retriveAirlineSearchViaIATAorICAO(String code, String APIKEY) {
        String responseLink = "https://aviation-reference-data.p.rapidapi.com/airline/" + code;

        System.out.println("\n");
        System.out.println("Loading....");
        System.out.println("\n");

        HttpResponse<String> response = Unirest.get(responseLink)
                .header("X-RapidAPI-Key", APIKEY)
                .header("X-RapidAPI-Host", "aviation-reference-data.p.rapidapi.com")
                .asString();

        if (response.getStatus() == 200) {
            // Parse the response body to JSON
            Gson gson = new Gson();
            JsonObject aircraftOrAirport = gson.fromJson(response.getBody(), JsonObject.class);

            String icaoCode = aircraftOrAirport.get("icaoCode").getAsString();
            String iataCode = aircraftOrAirport.get("iataCode").getAsString();
            String name = aircraftOrAirport.get("name").getAsString();
            String callSign = aircraftOrAirport.get("callSign").getAsString();
            String alpha3countryCode = aircraftOrAirport.get("alpha3countryCode").getAsString();

            System.out.println("Icao Code: " + icaoCode);
            System.out.println("Iata Code: " + iataCode);
            System.out.println("Name: " + name);
            System.out.println("Call Sign: " + callSign);
            System.out.println("Alpha3 Country Code: " + alpha3countryCode);

        } else {
            System.out.println("Error: Airline not found or Something else went wrong");
        }

    }

}
