package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserDetailsDao;
import com.techelevator.model.User;
import com.techelevator.model.UserDetails;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@PreAuthorize("isAuthenticated()")
public class UserController {

    private UserDao userDao;
    private UserDetailsDao userDetailsDao;

    public UserController(UserDao userDao, UserDetailsDao userDetailsDao){
        this.userDao = userDao;
        this.userDetailsDao = userDetailsDao;
    }


    //UserDao Methods start here **********


    //get all users from users table (recyclers, admins, drivers)
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }


    //get all drivers from users table (ROLE == USER, is_driver == true)
    @GetMapping("/drivers")
    public List<User> getAllDrivers() {
        return userDao.listAllDrivers();
    }


    //get all recyclers from the users table (ROLE == USER, is_driver == false)
    @GetMapping("/recyclers")
    public List<User> getAllRecyclers() {
        return userDao.listAllRecyclers();
    }

    //get user from users table, by user_id
    @RequestMapping(path="/users/{userId}", method= RequestMethod.GET)
    public User getUserById(@PathVariable int userId) {
        User user = userDao.getUserById(userId);

        if (user == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such user exists");
        } else {
            return user;
        }
    }

    //delete a user from the users table, by user_id
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId) {
        if (userDao.getUserById(userId) != null) {
            userDao.deleteUser(userId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such user exists");
        }
    }


    //UserDetailsDao methods start here **********


    //Get the total pounds of glass recycled across all users in the application
    // "How many pounds of glass has Vitrum kept out of landfills?"
    @PreAuthorize("permitAll")
    @GetMapping("/stats/total")
    public Long getTotalGlassRecycled() {
        return userDetailsDao.getTotalGlassRecycled();
    }

    //Get my Full Address - for logged-in user via Principal
    @GetMapping("/users/myDetails/address")
    public String getMyAddress(Principal principal) {
        return userDetailsDao.getFullAddressByUsername(principal.getName());
    }

    //Get my user details - for logged in user via Principal
    @GetMapping("/users/myDetails")
    public UserDetails getMyUserDetails(Principal principal) {
        return userDetailsDao.findUserDetailsByUsername(principal.getName());
    }

    //Get my Account_id - for logged-in user via Principal
    @GetMapping("/users/myDetails/accountId")
    public int getMyAccountId(Principal principal) {
        int accountId = userDetailsDao.getAccountIdByUsername(principal.getName());
        if (accountId != 0) {
            return accountId;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find a Recycler Account associated with that username");
        }
    }

    //Get all user details from user_details table
    @GetMapping("/users/details")
    public List<UserDetails> getAllUserDetails() {
        return userDetailsDao.findAllUserDetails();
    }

    //Get user detail from user_details table, using account_id
    @GetMapping("/users/details/{accountId}")
    public UserDetails getUserDetailByAccountId(@PathVariable int accountId) {
        UserDetails userDetail = userDetailsDao.findUserDetailsByAccountId(accountId);

        if (userDetail == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such user exists");
        } else {
            return userDetail;
        }
    }

    //add new user detail to user_details table --- registering a user after they've completed information form
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/users/details")
    public UserDetails addNewUserDetails(@Valid @RequestBody UserDetails newUserDetail) {
        if ((newUserDetail.getUsername()).equals(userDetailsDao.findUserDetailsByUsername(newUserDetail.getUsername()))){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "That user account already exists.");
        } else {
            return userDetailsDao.createUserDetails(newUserDetail);
        }
    }

    //update a user detail on the user_details table --- UserDetails object in Request body & account_id -- returns the updated UserDetails object
    @PutMapping("/users/details/{accountId}")
    public UserDetails updateUserDetails(@Valid @RequestBody UserDetails userDetails, @PathVariable int accountId) {
        if (userDetails.getAccount_id() != accountId) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The Account Id provided does not match the UserDetail you're trying to update");
        } else if (userDetailsDao.findUserDetailsByAccountId(accountId) == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no user associated with that Account Id");
        } else {
            userDetailsDao.updateUserDetails(userDetails);
            return userDetailsDao.findUserDetailsByAccountId(accountId);
        }
    }

    //deleting a user detail from user_details table
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/users/details/{accountId}")
    public void deleteUserDetails(@PathVariable int accountId) {
        if (userDetailsDao.findUserDetailsByAccountId(accountId) == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such Account Id exists");
        } else {
            userDetailsDao.deleteUserDetails(accountId);
        }
    }

    //Get full address in string format for Routes API, using account_id
    //example - '3001 Railroad St, Pittsburgh, PA 15201'
    @GetMapping("/users/details/{account_id}/address")
    public String getFullAddressByAccountId(@PathVariable int account_id) {
        if (userDetailsDao.findUserDetailsByAccountId(account_id) == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such username exists");
        } else {
            return userDetailsDao.getFullAddressByAccountId(account_id);
        }
    }

    //Get total amount of glass recycled for an account_id
    @GetMapping("/users/details/{account_id}/total")
    public int getTotalGlassRecycledByAccountId(@PathVariable int account_id) {
        if (userDetailsDao.findUserDetailsByAccountId(account_id) == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such username exists");
        } else {
            return userDetailsDao.getTotalGlassRecycledByAccountId(account_id);
        }
    }

    //Get current credit/point balance for an account_id
    @GetMapping("/users/details/{account_id}/balance")
    public int getCreditBalanceByAccountId(@PathVariable int account_id) {
        if (userDetailsDao.findUserDetailsByAccountId(account_id) == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such username exists");
        } else {
            return userDetailsDao.getCreditBalanceByAccountId(account_id);
        }
    }

    //Get the total amount of credits an account has redeemed towards prizes
    @GetMapping("/users/details/{account_id}/redeemed")
    public int getCreditRedeemedByAccountId(@PathVariable int account_id) {
        if (userDetailsDao.findUserDetailsByAccountId(account_id) == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No such username exists");
        } else {
            return userDetailsDao.getCreditRedeemedByAccountId(account_id);
        }
    }
}
