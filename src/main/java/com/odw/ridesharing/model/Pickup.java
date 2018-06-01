package com.odw.ridesharing.model;

import javax.money.Monetary;
import javax.money.MonetaryAmount;

import org.javamoney.moneta.Money;

/**
 * Pickup class is an inputType that relates the Customer to the Driver and
 * contains a Location object for the Driver to pick up and drop off the
 * Customer. Pickup also stores the ride cost.
 */
public class Pickup {

    private int pickupID;
    private Customer pickupCustomer;
    private Driver pickupDriver;
    private Location origin;
    private Location destination;
    private MonetaryAmount pickupCost;

    /**
     * Creates a default pickup to be modified later.
     */
    public Pickup() {
        this(-1, new Customer(), new Location(), new Location());
    }

    /**
     * Create a new pickup with a specified ID, customer, origin location, and
     * destination location. Note that driver is to be assigned through
     * PickupScheduler.
     * 
     * @param pickupID_
     *            The pickup's identification number.
     * 
     * @param pickupCustomer_
     *            The customer associated with this pickup.
     * 
     * @param origin_
     *            The starting location of the pickup.
     * 
     * @param destination_
     *            The destination location of the pickup.
     */
    /* @formatter:off */
    public Pickup(int pickupID_,
                  Customer pickupCustomer_,
                  Location origin_,
                  Location destination_) {
        setPickupID(pickupID_);
        setCustomer(pickupCustomer_);
        setOrigin(origin_);
        setDestination(destination_);

        pickupCost = Money.of(0.d, RuntimeConstants.USD_CURRENCY_CODE);
    }
    /* @formatter:on */

    /**
     * Returns the pickup's information in String format excluding the pickup's
     * driver information, pickup cost information, and origin/destination
     * locations. Used for created pickups that are not scheduled yet.
     * 
     * @return The pickup information as a String.
     */
    /* @formatter:off */
    public String toStringPreScheduled(String delimiter_) {
        return delimiter_ + " " +
               "PickupID: " + getPickupID() + " " + delimiter_ + " " +
               "CustomerID: " + pickupCustomer.getUserID() + " " + delimiter_ + " " +
               "Customer First Name: " + pickupCustomer.getFirstName() + " " + delimiter_ + " " +
               "Customer Last Name: " + pickupCustomer.getLastName() + " " + delimiter_; 
    }
    /* @formatter:on */

    /**
     * Gets all of the pickup's information as a string separated by a specified
     * delimiter.
     * 
     * @param delimiter_
     *            The specified delimiter to separate the values.
     * @return Returns all the information related to the current pickup.
     */
    /* @formatter:off */
    public String toString(String delimiter_) {
        return delimiter_ + " " +
               "PickupID: " + getPickupID() + " " + delimiter_ + " " +
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
     * Returns all of the pickup's information in String format.
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
