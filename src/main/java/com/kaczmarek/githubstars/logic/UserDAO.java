package com.kaczmarek.githubstars.logic;

import com.kaczmarek.githubstars.entity.Repository;
import com.kaczmarek.githubstars.entity.RepositoryList;
import com.kaczmarek.githubstars.entity.TotalStars;
import com.kaczmarek.githubstars.entity.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class responsible for loading data about selected GitHub user
 */
public class UserDAO {

  private static final int REPOS_PER_PAGE = 100;
  private static final String USER_URL = "https://api.github.com/users/{user}";
  private static final String REPOS_URL =
      "https://api.github.com/users/{user}/repos?page={page}&per_page={per_page}";

  private final String name;

  public UserDAO(String name) {
    this.name = name;
  }

  public RepositoryList getRepositoryList() {
    List<Repository> repositories = getRepositoryStream().collect(Collectors.toList());
    return new RepositoryList(repositories);
  }

  public TotalStars getTotalStars() {
    int starCount = getRepositoryStream().mapToInt(Repository::getStars).sum();
    return new TotalStars(starCount);
  }

  private UserData getUserData() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new UserErrorHandler());

    ResponseEntity<UserData> userDataResponseEntity =
        restTemplate.getForEntity(USER_URL, UserData.class, name);

    return userDataResponseEntity.getBody();
  }

  private Stream<Repository> getSingleRepositoriesPage(int page) {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setErrorHandler(new UserErrorHandler());

    ResponseEntity<Repository[]> responseEntity =
        restTemplate.getForEntity(REPOS_URL, Repository[].class, name, page, REPOS_PER_PAGE);

    Repository[] repositories = responseEntity.getBody();
    if (repositories == null) return Stream.of();
    return Arrays.stream(repositories);
  }

  private Stream<Repository> getRepositoryStream() {
    UserData userData = getUserData();
    return IntStream.range(0, (int) Math.ceil((double) userData.getRepoCount() / REPOS_PER_PAGE))
        .mapToObj(this::getSingleRepositoriesPage)
        .flatMap(stream -> stream);
  }
}
