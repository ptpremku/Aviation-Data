import com.google.gson.Gson;
import com.google.gson.JsonObject;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.Unirest;

public class AircraftCode {

    public void aircraftLookup(String aircraftCode, String APIKEY){
        String responseLink = "https://aviation-reference-data.p.rapidapi.com/icaoType/" + aircraftCode;


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
            JsonObject aircraft = gson.fromJson(response.getBody(), JsonObject.class);

            String manufacturer = aircraft.get("manufacturer").getAsString();
            String modelName = aircraft.get("modelName").getAsString();

            System.out.println("Manufacturer: " + manufacturer);
            System.out.println("Model Name: " + modelName);
        } else {
            System.out.println("Error: Aircraft not found or Something else went wrong");
        }
    }
}
