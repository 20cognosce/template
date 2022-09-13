package leetcode.ozon;

import java.util.List;
import java.util.Map;

public class ParkingService {

    // Нужно написать написать сервис для управления стоянкой автомобилей.
    // Каждый а/м имеет уникальный номер, название марки, год выпуска.
    // На стоянку можно поставить или забрать с неё автомобиль.


    /*id; start; end


    {
        List<ParkingPlace> allParking = new ArrayList();

        Map<ParkingPlace, Car> rentParking = new ConcurrentHashMap();


        public boolean park(ParkingPlace parkingPlace, Car car) {

        lock.lock();
        if (rentParking.contains(parkingPlace) {
            return false;
            //throw new RuntimeException("ParkingPlace is already taken");
        }

        // Thread 1

        rentParking.put(parkingPlace, car);
        car.setParkingPlace(parkingPlace);
        lock.unlock();
        // Thread2

        return true;
    }

        public boolean unpark(Car car) {
        ParkingPlace currentCarParkingPlace = car.getParkingPlace();

        if (Objects.equals(car, rentParking.get(currentCarParkingPlace))) {
            rentParking.remove(currentCarParkingPlace);
            return true;
        }

        return false;
    }

        {
            public class ParkingPlace {

                private final Long id;
            }


            public class Car {

                private final Long id;
                private final String code;

                private Long ParkingPlaceId;

            }


            for() {

                new Thread() -> {


                }.start();
            }

        = newThreadPool(1000);

            /// сделать метод для получения статистики (количество а/м по маркам)

        }*/
}
