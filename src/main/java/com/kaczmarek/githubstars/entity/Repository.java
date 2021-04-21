package com.kaczmarek.githubstars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Class containing data about single repository.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

  private String name;
  private int stars;

  public String getName() {
    return name;
  }

  public int getStars() {
    return stars;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStars(Integer stars) {
    this.stars = stars;
  }
}
