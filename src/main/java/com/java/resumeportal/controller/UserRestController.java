package com.java.resumeportal.controller;

import com.java.resumeportal.entity.resumeData.UserProfile;
import com.java.resumeportal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class UserRestController {

    @Autowired
    UserProfileRepository userProfileRepository;

    @GetMapping("/view/{userId}")
    public String view(@PathVariable String userId, Model model){
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile= userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        System.out.println(userProfile.getJobs());
        System.out.println(userProfile.getEducations());
        System.out.println(userProfile.getSkills());

       // model.addAttribute("job", userProfile.getJobs());
        return "profile-templates/" + userProfile.getId() + "/index";
    }

    // if we add manually user profile and job data.....

//    public String home(){
//        UserProfile profile1 = new UserProfile();
//        profile1.setId(4);
//        profile1.setDesignation("designation");
//        profile1.setUserName("guman");
//        profile1.setFirstName("Guman");
//        profile1.setLastName("Singh");
//        profile1.setTheme(1);
//        Job job1 = new Job();
//        job1.setCompany("company 1");
//        job1.setDesignation("designation");
//        job1.setId(1);
//        job1.setStartDate(LocalDate.of(2020,1,2));
//        job1.setEndDate(LocalDate.of(2020,3,11));
//        Job job2 = new Job();
//        job2.setCompany("company 2");
//        job2.setDesignation("designation");
//        job2.setId(1);
//        job2.setStartDate(LocalDate.of(2019,5,2));
//        job2.setEndDate(LocalDate.of(2020,2,25));
//        profile1.setJobs(Arrays.asList(job1,job2));
//        userProfileRepository.save(profile1);
//
//        return "profile";
//    }

}
