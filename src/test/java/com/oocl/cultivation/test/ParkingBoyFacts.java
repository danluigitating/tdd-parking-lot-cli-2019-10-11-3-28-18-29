package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.ParkingTicket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingBoyFacts {
    @Test
    void should_park_car_to_parking_lot_by_parking_boy() {
        //GIVEN
        Car car = new Car();
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        ParkingTicket parkingTicket= parkingBoy.park(car);

        //THEN
        assertNotNull(parkingTicket);
    }

    @Test
    void should_fetch_car_by_parking_ticket_from_parking_boy() {
        //GIVEN
        ParkingLot parkingLot = new ParkingLot();
        ParkingTicket parkingTicket;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car= new Car();

        //WHEN
        parkingTicket= parkingBoy.park(car);
        car= parkingBoy.fetch(parkingTicket);

        //THEN
        assertNotNull(car);
    }

    @Test
    void should_return_multiple_parking_ticket_when_parking_boy_park_multiple_cars_in_parking_lot() {
        //GIVEN
        Car car1= new Car();
        Car car2= new Car();
        ParkingLot parkingLot= new ParkingLot();
        ParkingBoy parkingBoy= new ParkingBoy(parkingLot);

        //WHEN
        ParkingTicket parkingTicket1= parkingBoy.park(car1);
        car1= parkingBoy.fetch(parkingTicket1);
        ParkingTicket parkingTicket2= parkingBoy.park(car2);
        car2= parkingBoy.fetch(parkingTicket2);

        //THEN
        assertNotNull(parkingTicket1);
        assertNotNull(parkingTicket2);
        assertNotEquals(parkingTicket1, parkingTicket2);
    }

    @Test
    void should_return_null_car_when_parking_boy_park_fetches_null_ticket() {
        //GIVEN
        ParkingLot parkingLot= new ParkingLot();
        ParkingBoy parkingBoy= new ParkingBoy(parkingLot);

        //WHEN
        Car car = parkingBoy.fetch(null);

        //THEN
        assertNull(car);
    }

    @Test
    void should_return_null_car_when_parking_boy_park_fetches_incorrect_ticket() {
        //GIVEN
        ParkingLot parkingLot= new ParkingLot();
        ParkingBoy parkingBoy= new ParkingBoy(parkingLot);

        //WHEN
        ParkingTicket parkingTicket= parkingBoy.park(new Car());
        Car car = parkingBoy.fetch(new ParkingTicket());

        //THEN
        assertNull(car);
        assertNotNull(parkingTicket);
    }

    @Test
    void should_return_null_car_when_parking_boy_park_fetches_used_ticket() {
        //GIVEN
        ParkingLot parkingLot= new ParkingLot();
        ParkingBoy parkingBoy= new ParkingBoy(parkingLot);

        //WHEN
        ParkingTicket parkingTicket= parkingBoy.park(new Car());
        Car car1 = parkingBoy.fetch(parkingTicket);
        Car car2 = parkingBoy.fetch(parkingTicket);

        //THEN
        assertNotNull(car1);
        assertNull(car2);
    }

    @Test
    void should_return_null_parking_ticket_when_parking_lot_capacity_is_reached() {
        //GIVEN
        ParkingLot parkingLot= new ParkingLot();
        ParkingBoy parkingBoy= new ParkingBoy(parkingLot);

        //WHEN
        ParkingTicket parkingTicket = null;
        for(int i=0; i<10; i++){
            parkingTicket = parkingBoy.park(new Car());
        }
        ParkingTicket overloadParkingTicket = parkingBoy.park(new Car());

        //THEN
        assertNotNull(parkingTicket);
        assertNull(overloadParkingTicket);
    }







}
