import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new Main().print();
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Choice: ");
        input = sc.nextInt();

        while (input == 1 || input == 2 || input == 3 || input == 4 || input == 5){

            if (input == 1){
                double lat, lon;
                int radius;
                String APIKEY;
                System.out.println("Enter Latitude:");
                lat = sc.nextDouble();

                System.out.println("Enter Longitude:");
                lon = sc.nextDouble();

                System.out.println("Enter Radius:");
                radius = sc.nextInt();

                sc.nextLine();

                System.out.println("Enter APIKEY:");
                APIKEY = sc.nextLine();

                new Main().findAirportByLocationCoordinates(lat,lon,radius, APIKEY);
                System.out.println("\n");
                new Main().print();
                System.out.println("Enter Your Choice: ");
                input = sc.nextInt();
            }

            else if (input == 2){
                String airplaneCode, APIKEY;
                Scanner myObj = new Scanner(System.in);

                System.out.println("Enter APIKEY:");
                APIKEY = myObj.nextLine();

                System.out.println("Enter Airplane Code:");
                airplaneCode = myObj.nextLine();

                new Main().airplaneLookupViaCode(airplaneCode, APIKEY);
                System.out.println("\n");
                new Main().print();
                System.out.println("Enter Your Choice: ");
                input = sc.nextInt();
            }

            else if (input == 3){
                String airlineName, APIKEY;
                Scanner myObj = new Scanner(System.in);

                System.out.println("Enter APIKEY:");
                APIKEY = myObj.nextLine();

                System.out.println("Enter Airline Name (OR Prefix):");
                airlineName = myObj.nextLine();

                new Main().allAirlineLookupViaName(airlineName, APIKEY);
                System.out.println("\n");
                new Main().print();
                System.out.println("Enter Your Choice: ");
                input = sc.nextInt();
            }

            else if (input == 4){
                String code, APIKEY;
                Scanner myObj = new Scanner(System.in);

                System.out.println("Enter APIKEY:");
                APIKEY = myObj.nextLine();

                System.out.println("Enter Code");
                code = myObj.nextLine();

                new Main().airlineLookupViaName(code, APIKEY);
                System.out.println("\n");
                new Main().print();
                System.out.println("Enter Your Choice: ");
                input = sc.nextInt();
            }

            else if (input == 5) {
                System.out.println("This program will quit now");
                break;
            }

            else {
                System.out.println("Invalid Input. Try again");
                System.out.println("\n");
                new Main().print();
                System.out.println("Enter Your Choice: ");
                input = sc.nextInt();
            }
        }


    }

    public void findAirportByLocationCoordinates(double lat, double lon, int radius, String key){
        new AirportSearchByLocationCoordinates().findAirport(lat, lon, radius, key);
    }

    public void airplaneLookupViaCode(String airplaneCode, String APIKEY){
        new AircraftCode().aircraftLookup(airplaneCode, APIKEY);
    }

    public void allAirlineLookupViaName(String airlineName, String APIKEY){
        new SearchORAutoCompleteAirlines().airlineLookup(airlineName, APIKEY);
    }

    public void airlineLookupViaName(String code, String APIKEY){
        new AirlineSearchViaIATAorICAO().retriveAirlineSearchViaIATAorICAO(code, APIKEY);
    }

    public void print(){
        System.out.println("Choices: ");
        System.out.println("1. Find Airport by Location Coordinates");
        System.out.println("2. Find Airplane by Airplane Code");
        System.out.println("3. Find All Airlines by Searching or Autocompleting Airlines by Name");
        System.out.println("4. Get Airline/Airport Information by IATA or ICAO code");
        System.out.println("5. Exit");
    }
}
