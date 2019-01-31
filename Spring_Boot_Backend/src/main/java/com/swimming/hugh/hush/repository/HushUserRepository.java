package com.swimming.hugh.hush.repository;

import com.swimming.hugh.hush.domin.HushUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HushUserRepository extends CrudRepository<HushUser, Long> {
    public HushUser findHushUserByUsername(String username);
}
