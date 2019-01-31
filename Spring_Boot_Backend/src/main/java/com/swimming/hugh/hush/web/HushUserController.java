package com.swimming.hugh.hush.web;

import com.swimming.hugh.hush.domin.HushUser;
import com.swimming.hugh.hush.service.HushUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class HushUserController {
    @Autowired
    HushUserService hushUserService;

    @GetMapping("")
    public ResponseEntity<HushUser> login(HushUser hushUser) {
        HushUser storedHushUser = hushUserService.findHushUserByUsername(hushUser.getUsername());
        if (storedHushUser == null || !storedHushUser.getPassword().equals(hushUser.getPassword())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(storedHushUser, HttpStatus.ACCEPTED);
        }
    }

    @PostMapping("")
    public ResponseEntity<HushUser> register(HushUser hushUser) {
        HushUser storedHushUser = hushUserService.saveHushUser(hushUser);
        if (storedHushUser == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(storedHushUser, HttpStatus.CREATED);
        }
    }
}
