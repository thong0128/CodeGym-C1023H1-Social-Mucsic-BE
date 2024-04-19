package com.social_music.controller;

import com.social_music.model.JwtResponse;
import com.social_music.model.AppUser;
import com.social_music.service.impl.AppUserServiceImpl;
import com.social_music.service.impl.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AppUserServiceImpl userService;
    public static Long current_id;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AppUser user) {
        Authentication authentication
                = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        AppUser currentUser = userService.findByUsername(user.getUsername());
        JwtResponse a = new JwtResponse(currentUser.getId(), jwt, userDetails.getUsername(), userDetails.getUsername(), userDetails.getAuthorities());
        current_id = currentUser.getId();
        return ResponseEntity.ok(a);
    }
    static public Long getId(){
        return current_id;
    }
    @GetMapping("/users")
    public ResponseEntity<Iterable<AppUser>> listUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/users/create")
    public ResponseEntity<AppUser> createUser(@RequestBody AppUser user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> userById(@PathVariable Long id){
        Optional<AppUser> customerOptional = userService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        AppUser user = customerOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}