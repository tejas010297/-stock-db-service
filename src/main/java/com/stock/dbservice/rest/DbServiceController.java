package com.stock.dbservice.rest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stock.dbservice.model.Quote;
import com.stock.dbservice.repo.DbServiceRepo;

@RestController
@RequestMapping("/stock/db/")
public class DbServiceController {

  @Autowired
  private DbServiceRepo dbServiceRepo;

  @GetMapping(value = "/{userName}")
  public List<String> getQuotes(@PathVariable("userName") final String userName) {

    return this.dbServiceRepo.findByUserName(userName)
        .stream()
        .map(Quote::getQuote)
        .collect(Collectors.toList());
  }

  @PostMapping()
  public boolean saveQuote(@RequestBody Quote quote) {

    return Objects.nonNull(this.dbServiceRepo.save(quote));
  }
}
