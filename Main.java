import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        new Main().print();
        int input;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Choice: ");
        input = sc.nextInt();

        while (input == 1 || input == 2 || input == 3 || input == 4 || input == 5 || input == 6 || input == 7 || input == 8 || input == 9){

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
                input = sc.nextInt();
            }
            else {
                break;
            }
        }


    }

    public void findAirportByLocationCoordinates(double lat, double lon, int radius, String key){
        new AirportSearchByLocationCoordinates().findAirport(lat, lon, radius, key);
    }

    public void print(){
        System.out.println("1. Find Airport by Location Coordinate");
    }
}
