package com.kaczmarek.githubstars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserData {

  @JsonProperty("public_repos")
  private Integer repoCount;

  public Integer getRepoCount() {
    return repoCount;
  }

  public void setRepoCount(Integer repoCount) {
    this.repoCount = repoCount;
  }
}
