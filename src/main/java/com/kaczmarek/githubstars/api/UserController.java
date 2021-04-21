package com.kaczmarek.githubstars.api;

import com.kaczmarek.githubstars.entity.RepositoryList;
import com.kaczmarek.githubstars.entity.TotalStars;
import com.kaczmarek.githubstars.logic.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/{username}", produces = "application/json")
public class UserController {

  @GetMapping("/list")
  public RepositoryList list(@PathVariable String username) {
    User user = new User(username);
    return user.getRepositoryList();
  }

  @GetMapping("/total")
  public TotalStars total(@PathVariable String username) {
    User user = new User(username);
    return user.getTotalStars();
  }
}
