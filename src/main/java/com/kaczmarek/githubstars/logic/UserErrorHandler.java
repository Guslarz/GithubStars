package com.kaczmarek.githubstars.logic;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

/**
 * Custom error handler for RestTemplate.
 * Actually used to respond to request for nonexistent user
 * with 404 rather than 500 error
 */
public class UserErrorHandler extends DefaultResponseErrorHandler {

  @Override
  public void handleError(ClientHttpResponse response) throws IOException {
    if (response.getStatusCode() == HttpStatus.NOT_FOUND)
      throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    super.handleError(response);
  }
}
