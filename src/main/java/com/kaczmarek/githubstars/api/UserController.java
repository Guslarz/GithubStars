package com.kaczmarek.githubstars.api;

import com.kaczmarek.githubstars.entity.RepositoryList;
import com.kaczmarek.githubstars.entity.TotalStars;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/{user}", produces = "application/json")
public class UserController {

  @GetMapping("/list")
  public RepositoryList list(@PathVariable String user) {
    return null;
  }

  @GetMapping("/total")
  public TotalStars total(@PathVariable String user) {
    return null;
  }
}
