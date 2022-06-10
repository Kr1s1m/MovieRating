package com.fmi.MovieRating.controllers;

import com.fmi.MovieRating.dtos.IndividualDto;
import com.fmi.MovieRating.mappers.IndividualMapper;
import com.fmi.MovieRating.services.IndividualServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.fmi.MovieRating.mappers.IndividualMapper.fromIndividualToDto;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class IndividualController {

    @Autowired
    private IndividualServiceImpl individualService;

    @GetMapping("/individuals")
    public List<IndividualDto> getAllIndividuals(){
        return individualService.list().stream()
                .map(individual -> fromIndividualToDto(individual))
                .collect(Collectors.toList());

    }

    @GetMapping("/individuals/{id}")
    public Optional<IndividualDto> getIndividualById(@PathVariable Integer id) {

        return individualService.getIndividualById(id).
                map(IndividualMapper::fromIndividualToDto);
    }

    @GetMapping("/individuals/movie-page/{movie_id}")
    public List<IndividualDto> getIndividualsByMovieId(@PathVariable Integer movie_id) {

        return individualService.getIndividualsByMovieId(movie_id).stream()
                .map(IndividualMapper::fromIndividualInfoToDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/individuals")
    public IndividualDto createIndividual(@RequestBody IndividualDto individualDto){

        return fromIndividualToDto(individualService.createIndividual(individualDto));
    }

    @DeleteMapping("/individuals/{id}")
    public void deleteIndividual(@PathVariable Integer id){
        individualService.deleteIndividual(id);
    }
}
