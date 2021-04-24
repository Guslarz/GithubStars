package com.kaczmarek.githubstars.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSetter;

/** Class containing data about single repository. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository {

  private String name;
  private int stars;

  public String getName() {
    return name;
  }

  @JsonGetter("stars")
  public int getStars() {
    return stars;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonSetter("stargazers_count")
  public void setStars(Integer stars) {
    this.stars = stars;
  }
}
