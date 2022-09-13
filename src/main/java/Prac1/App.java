package Prac1;

public class App {

    public static void main(String[] args) {

        System.out.println(Geocoder.getGeolocationFromCoordinates(55.67, 37.48).toString() + "\n");

        Geocoder.getGeolocationFromQuery("Москва, МИРЭА - Российский технологический университет")
                .forEach(item -> System.out.println(item.toString()));
    }
}
