package com.kaczmarek.githubstars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

  private String name;
  private String description;
  private Integer stars;

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public int getStars() {
    return stars;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setStars(Integer stars) {
    this.stars = stars;
  }
}
