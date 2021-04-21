package com.kaczmarek.githubstars.entity;

/**
 * Class representing total number of stars of certain user
 */
public class TotalStars {

  private final int stars;

  public TotalStars(int stars) {
    this.stars = stars;
  }

  public int getStars() {
    return stars;
  }
}
