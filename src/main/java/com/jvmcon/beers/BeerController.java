package com.jvmcon.beers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/beer")
public class BeerController {
    @Autowired
    private BeerRepository beerRepository;

    @GetMapping
    public List<Beer> listBeers() {
        return beerRepository.findAll();
    }

    @PostMapping
    public void addBeer(@RequestBody Beer beer) {
        beer.setId(UUID.randomUUID().toString());
        beerRepository.save(beer);
    }

    @PutMapping
    public void editBeer(@RequestBody Beer beer) {
        beerRepository.save(beer);
    }

    @DeleteMapping
    public void deleteBeer(@RequestParam String beerId) {
        beerRepository.deleteById(beerId);
    }
}
