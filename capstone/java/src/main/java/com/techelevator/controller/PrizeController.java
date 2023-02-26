package com.techelevator.controller;

import com.techelevator.dao.PrizeDetailsDao;
import com.techelevator.dao.UserDetailsDao;
import com.techelevator.model.PrizeDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
@RequestMapping("/prizes")
public class PrizeController {

    private PrizeDetailsDao prizeDetailsDao;
    private UserDetailsDao userDetailsDao;

    public PrizeController(PrizeDetailsDao prizeDetailsDao, UserDetailsDao userDetailsDao){
        this.prizeDetailsDao = prizeDetailsDao;
        this.userDetailsDao = userDetailsDao;
    }


    //PrizeDetailsDao Methods start here **********


    //Get all prizes
    @GetMapping("")
    public List<PrizeDetails> getAllPrizes() {
        return prizeDetailsDao.getPrizeList();
    }

    //Get prize by prize_id
    @GetMapping("/{prizeId}")
    public PrizeDetails getPrizeByPrizeId(@PathVariable int prizeId) {
        PrizeDetails prize = prizeDetailsDao.getPrizeByPrizeId(prizeId);
        if (prize != null) {
            return prize;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "That Prize ID does not exist");
        }
    }

    //Add new prize
    @PostMapping("")
    public PrizeDetails addPrize(@Valid @RequestBody PrizeDetails newPrize) {
            return prizeDetailsDao.addPrize(newPrize);
    }

    //Edit a prize
    @PutMapping("/{prizeId}")
    public PrizeDetails updatePrize(@Valid @RequestBody PrizeDetails updatedPrize, @PathVariable int prizeId) {
        if (updatedPrize.getPrize_id() != prizeId) {
            prizeDetailsDao.updatePrize(updatedPrize);
            return prizeDetailsDao.getPrizeByPrizeId(prizeId);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The prizeId provided does not match the prize you're attempting to update");
        }
    }

    //Delete a prize
    @DeleteMapping("/{prizeId}")
    public void deletePrize(@PathVariable int prizeId) {
        prizeDetailsDao.deletePrize(prizeId);
    }

}
