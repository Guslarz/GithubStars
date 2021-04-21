package com.kaczmarek.githubstars.api;

import com.kaczmarek.githubstars.entity.RepositoryList;
import com.kaczmarek.githubstars.entity.TotalStars;
import com.kaczmarek.githubstars.logic.UserDAO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** Class providing REST API mapping for requesting github user data */
@RestController
@RequestMapping(value = "/user/{username}", produces = "application/json")
public class UserController {

  /**
   * Method for accessing list of all GitHub repositories of selected user
   * @param username GitHub username of selected user
   * @return object for response containing said list
   */
  @GetMapping("/list")
  public RepositoryList list(@PathVariable String username) {
    UserDAO user = new UserDAO(username);
    return user.getRepositoryList();
  }

  /**
   * Method for accessing total number of stars of certain user
   * @param username GitHub username of selected user
   * @return object for response containing this number
   */
  @GetMapping("/total")
  public TotalStars total(@PathVariable String username) {
    UserDAO user = new UserDAO(username);
    return user.getTotalStars();
  }
}
