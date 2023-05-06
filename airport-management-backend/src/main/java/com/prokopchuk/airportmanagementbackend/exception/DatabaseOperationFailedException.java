package com.prokopchuk.airportmanagementbackend.exception;

public class DatabaseOperationFailedException extends RuntimeException {

  public DatabaseOperationFailedException(String message) {
    super(message);
  }

}
