package com.swimming.hugh.hush.service;

import com.swimming.hugh.hush.domin.HushUser;
import com.swimming.hugh.hush.repository.HushUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HushUserService {
    @Autowired
    private HushUserRepository hushUserRepository;

    public HushUser saveHushUser(HushUser hushUser) {
        if(hushUserRepository.findHushUserByUsername(hushUser.getUsername()) != null) {
            return null;
        } else {
            return hushUserRepository.save(hushUser);
        }
    }
    public HushUser findHushUserByUsername(String username) {
        return hushUserRepository.findHushUserByUsername(username);
    }
}
