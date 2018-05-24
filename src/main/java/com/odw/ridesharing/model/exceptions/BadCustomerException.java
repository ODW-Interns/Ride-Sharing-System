package com.odw.ridesharing.model.exceptions;

public class BadCustomerException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 8011630503202520471L;

    /**
    *
    */
   public BadCustomerException() {
   }

   /**
    *
    */
   public BadCustomerException(String message_) {
       super(message_);

   }

   /**
    *
    */
   public BadCustomerException(Throwable cause_) {
       super(cause_);

   }

   /**
    *
    */
   public BadCustomerException(String message_, Throwable cause_) {
       super(message_, cause_);

   }

   /**
    *
    */
   public BadCustomerException(String message_, Throwable cause_, boolean enableSuppression_, boolean writableStackTrace_) {
       super(message_, cause_, enableSuppression_, writableStackTrace_);

   }

}
