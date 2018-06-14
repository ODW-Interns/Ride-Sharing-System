package com.odw.ridesharing.exceptions;

/**
 * 
 * Thrown when customer is not found in the database
 *
 */
public class CustomerNotFoundException extends Exception {

    private static final long serialVersionUID = 8011630503202520471L;
    
   /**
    * [TODO]
    * @param message_
    */
   public CustomerNotFoundException(String message_) {
       super(message_);
   }

}
