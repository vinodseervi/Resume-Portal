package com.java.resumeportal.repository;

import com.java.resumeportal.entity.User;
import com.java.resumeportal.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUserName(String userName);
}

