package com.kaczmarek.githubstars.entity;

public class TotalStars {

  private String user;
  private Integer stars;

  public TotalStars(String user, Integer stars) {
    this.user = user;
    this.stars = stars;
  }

  public String getUser() {
    return user;
  }

  public Integer getStars() {
    return stars;
  }
}
