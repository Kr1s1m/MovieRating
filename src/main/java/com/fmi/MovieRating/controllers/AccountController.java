package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.AccountDto;
import com.fmi.MovieRating.mappers.AccountMapper;
import com.fmi.MovieRating.services.AccountService;
import com.fmi.MovieRating.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/accounts/{id}")
    public AccountDto getAccountById(@PathVariable Long id) {

        return accountService.findAccountById(id).
                map(AccountMapper::fromAccountToDto).orElseThrow(() -> new IllegalStateException("Can't find this account"));
    }

    @GetMapping("/accounts/karma/{id}")
    public Long getKarmaByAccountId(@PathVariable Long id){
        return reviewService.getKarmaByAccountId(id);
    }
}
