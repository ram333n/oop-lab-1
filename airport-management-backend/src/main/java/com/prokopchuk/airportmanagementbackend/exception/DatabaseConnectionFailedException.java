package com.prokopchuk.airportmanagementbackend.exception;

public class DatabaseConnectionFailedException extends RuntimeException {

  public DatabaseConnectionFailedException(String message) {
    super(message);
  }

}
