package com.kaczmarek.githubstars.entity;

import java.util.List;

public class RepositoryList {

  private final String user;
  private final List<Repository> repositories;

  public RepositoryList(String user, List<Repository> repositories) {
    this.user = user;
    this.repositories = repositories;
  }

  public String getUser() {
    return user;
  }

  public List<Repository> getRepositories() {
    return repositories;
  }
}
