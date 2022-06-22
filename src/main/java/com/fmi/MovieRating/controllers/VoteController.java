package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.ApiResponse;
import com.fmi.MovieRating.dtos.VoteDto;
import com.fmi.MovieRating.models.Account;
import com.fmi.MovieRating.services.AccountService;
import com.fmi.MovieRating.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class VoteController {

    @Autowired
    VoteService voteService;

    @Autowired
    AccountService accountService;

    @PostMapping("/vote")
    @PreAuthorize("hasAuthority('Admin') or hasAuthority('User')")
    public ResponseEntity<?> vote(@RequestBody VoteDto voteDto) {

        try {
            Account account = accountService.getCurrentAccount();
            voteService.vote(voteDto,account);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
