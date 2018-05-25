package com.odw.ridesharing.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

public class Pickup {

    private int pickupID;
    private Customer pickupCustomer;
    private Driver pickupDriver;
    private Location origin;
    private Location destination;
    private MonetaryAmount pickupCost;

    public Pickup() {
        this(-1, new Customer(), new Driver(), new Location(), new Location());
    }

    /**
     * Initialize a Pickup with IDs from car, driver, and customer
     * 
     * Includes the ride to and from
     * 
     * @param carID_
     *            This car's unique id
     * 
     * @param driverID_
     *            This driver's unique id
     * 
     * @param customerID_
     *            This customer's unique id
     * 
     * @param origin_
     *            the starting location of the driver in longitude and latitude
     * 
     * @param destination_
     *            the destination location in longitude and latitude
     */
    /* @formatter:off */
    public Pickup(int pickupId__,
                  Customer pickupCustomer_,
                  Driver pickupDriver_,
                  Location origin_,
                  Location destination_) {
        setPickupID(pickupId__);
        setCustomer(pickupCustomer_);
        setDriver(pickupDriver_);
        setOrigin(origin_);
        setDestination(destination_);

        pickupCost = Money.of(0.d, RuntimeConstants.USD_CURRENCY_CODE);
    }
    /* @formatter:on */

    /**
     * Returns the pickup's information in String format.
     * 
     * @return The pickup information as a String.
     */
    /* @formatter:off */
    public String toString(String delimiter_) {
        return "PickupID: " + getPickupID() + " " + delimiter_ + " " +
               "Customer First Name: " + pickupCustomer.getFirstName() + " " + delimiter_ + " " +
               "Customer Last Name: " + pickupCustomer.getLastName() + " " + delimiter_ + " " + 
               "CustomerID: " + pickupCustomer.getUserID() + " " + delimiter_ + " " + 
               "Driver First Name: " + pickupDriver.getFirstName() + " " + delimiter_ + " " +
               "Driver Last Name: " + pickupDriver.getLastName() + " " + delimiter_ + " " +
               "DriverID: " + pickupDriver.getUserID() + " " + delimiter_ + " " + 
               "Origin (latitude, longitude): " + origin.toString() + " " + delimiter_ + " " +
               "Destination (latitude, longitude): " + destination.toString() + " " + delimiter_ + " " +
               "Total Cost: " + pickupCost.with(Monetary.getDefaultRounding()).toString() + " " + delimiter_;
    }
    /* @formatter:on */
    
    /**
     * Returns the pickup's information in String format.
     * 
     * @return The pickup information as a String.
     */
    @Override
    public String toString() {
        return toString("|");
    }

    /**
     * Get the unique ID of the pickup.
     * 
     * @return the pickup's ID.
     */
    public int getPickupID() {
        return pickupID;
    }

    /**
     * Get the unique ID of the pickup.
     * 
     * @param pickupID_
     *            pickupID_ The new ID for the pickup to be set to.
     */
    public void setPickupID(int pickupID_) {
        pickupID = pickupID_;
    }

    /**
     * Get the driver of this pickup.
     * 
     * @return the driver of this pickup.
     */
    public Driver getDriver() {
        return pickupDriver;
    }

    /**
     * Set the driver of this pickup.
     * 
     * @param newDriver_
     *            The driver to be set.
     */
    public void setDriver(Driver newDriver_) {
        pickupDriver = newDriver_;
    }

    /**
     * Get the customer of this pickup.
     * 
     * @return the customer of this pickup.
     */
    public Customer getCustomer() {
        return pickupCustomer;
    }

    /**
     * Set the customer of this pickup.
     * 
     * @param newCustomer_
     *            The customer to be set.
     */
    public void setCustomer(Customer newCustomer_) {
        pickupCustomer = newCustomer_;
    }

    /**
     * Get the location of the pickup's starting point as a location object.
     * 
     * @return the starting point of the pickup
     */
    public Location getOrigin() {
        return origin;
    }

    /**
     * Set the location of the pickup's starting point as a location object.
     * 
     * @param origin_
     *            The new starting point of the Pickup to be set.
     */
    public void setOrigin(Location origin_) {
        origin = origin_;
    }

    /**
     * Get the location of the pickup's ending point as a location object.
     * 
     * @return The end location of the Pickup to be executed
     */
    public Location getDestination() {
        return destination;
    }

    /**
     * Set the location of the pickup's ending point as a location object.
     * 
     * @param newDestination_
     *            The new ending point of the Pickup to be set.
     */
    public void setDestination(Location newDestination_) {
        destination = newDestination_;
    }

    /**
     * Gets the cost of the pickup as a double.
     * 
     * @return the cost of the pickup.
     */
    public double getPickupCost() {
        return pickupCost.getNumber().doubleValue();
    }

    /**
     * Sets the cost of the pickup.
     * 
     * @param totalCost_
     *            The value to set to.
     */
    public void setPickupCost(double totalCost_) {
        pickupCost = Money.of(totalCost_, RuntimeConstants.USD_CURRENCY_CODE);
    }

}
