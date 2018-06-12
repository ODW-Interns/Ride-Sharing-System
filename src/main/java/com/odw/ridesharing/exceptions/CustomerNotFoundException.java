package com.odw.ridesharing.exceptions;

/**
 * 
 * Throw when customer is not found in the database
 *
 */
public class CustomerNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 8011630503202520471L;

    /**
    *
    */
   public CustomerNotFoundException() {
   }

   /**
    *
    */
   public CustomerNotFoundException(String message_) {
       super(message_);

   }

   /**
    *
    */
   public CustomerNotFoundException(Throwable cause_) {
       super(cause_);

   }

   /**
    *
    */
   public CustomerNotFoundException(String message_, Throwable cause_) {
       super(message_, cause_);

   }

   /**
    *
    */
   public CustomerNotFoundException(String message_, Throwable cause_, boolean enableSuppression_, boolean writableStackTrace_) {
       super(message_, cause_, enableSuppression_, writableStackTrace_);

   }

}
