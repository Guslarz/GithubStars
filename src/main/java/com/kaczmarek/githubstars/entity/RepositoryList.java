package com.kaczmarek.githubstars.entity;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

/**
 * Class representing list of repositories of certain user
 */
public class RepositoryList {

  @JsonValue
  private final List<Repository> repositories;

  public RepositoryList(List<Repository> repositories) {
    this.repositories = repositories;
  }

  public List<Repository> getRepositories() {
    return repositories;
  }
}
