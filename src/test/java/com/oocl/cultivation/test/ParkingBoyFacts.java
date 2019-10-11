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
        ParkingTicket parkingTicket= new ParkingTicket();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        //WHEN
        Car car= parkingBoy.fetch(parkingTicket);

        //THEN
        assertNotNull(car);
    }
}
