package com.odw.ridesharing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.odw.ridesharing.model.Car;
import com.odw.ridesharing.model.Coupe;
import com.odw.ridesharing.model.Sedan;
import com.odw.ridesharing.model.Suv;
import com.odw.ridesharing.service.CarFactory;

public class CarFactoryTest {

    CarFactory carFactory = new CarFactory();

    /**
     * Tests CarFactory's createCar method. Ensures that the proper concrete car is
     * being generated. Note that the assumption for this method is that the
     * ArrayList is equal to the predetermined event type values size.
     */
    @Test
    public void testCreateCar() {
        ArrayList<String> coupeCarInfo = new ArrayList<String>();
        coupeCarInfo.add("coupe");
        coupeCarInfo.add("toyota");
        coupeCarInfo.add("trueno");
        coupeCarInfo.add("white");
        coupeCarInfo.add("1986");
        ArrayList<String> sedanCarInfo = new ArrayList<String>();
        sedanCarInfo.add("sedan");
        sedanCarInfo.add("ford");
        sedanCarInfo.add("focus");
        sedanCarInfo.add("grey");
        sedanCarInfo.add("2014");
        ArrayList<String> suvCarInfo = new ArrayList<String>();
        suvCarInfo.add("suv");
        suvCarInfo.add("cadillac");
        suvCarInfo.add("escalade");
        suvCarInfo.add("black");
        suvCarInfo.add("2018");
        ArrayList<String> invalidCarInfo = new ArrayList<String>();
        invalidCarInfo.add("unknown");
        invalidCarInfo.add("must");
        invalidCarInfo.add("be");
        invalidCarInfo.add("length");
        invalidCarInfo.add("5");

        Car coupe = carFactory.createCar(coupeCarInfo);
        Car sedan = carFactory.createCar(sedanCarInfo);
        Car suv = carFactory.createCar(suvCarInfo);
        Car unknown = carFactory.createCar(invalidCarInfo);

        assertTrue(coupe instanceof Coupe);
        assertTrue(sedan instanceof Sedan);
        assertTrue(suv instanceof Suv);
        assertNull(unknown);
    }

}
