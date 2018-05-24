package com.odw.ridesharing.model.exceptions;

public class InvalidUserArgumentsException extends Exception{
   
    /**
     * 
     */
    private static final long serialVersionUID = 3313711250466662808L;

    /**
    *
    */
   public InvalidUserArgumentsException() {}

   /**
    *
    */
   public InvalidUserArgumentsException(String message_) {
       super(message_);

   }

   /**
    *
    */
   public InvalidUserArgumentsException(Throwable cause_) {
       super(cause_);

   }

   /**
    *
    */
   public InvalidUserArgumentsException(String message_, Throwable cause_) {
       super(message_, cause_);

   }

   /**
    *
    */
   public InvalidUserArgumentsException(String message_, Throwable cause_, boolean enableSuppression_, boolean writableStackTrace_) {
       super(message_, cause_, enableSuppression_, writableStackTrace_);

   }
}
