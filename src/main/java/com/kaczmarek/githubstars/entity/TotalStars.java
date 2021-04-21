package com.kaczmarek.githubstars.entity;

public class TotalStars {

  private final String user;
  private final int stars;

  public TotalStars(String user, int stars) {
    this.user = user;
    this.stars = stars;
  }

  public String getUser() {
    return user;
  }

  public int getStars() {
    return stars;
  }
}
