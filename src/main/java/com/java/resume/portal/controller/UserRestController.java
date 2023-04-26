package com.java.resume.portal.controller;

import com.java.resume.portal.entity.resumeData.*;
import com.java.resume.portal.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
public class UserRestController {

    @Autowired
    UserProfileRepository userProfileRepository;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model, Principal principal, @RequestParam(required = false)String add){
        String userId = principal.getName();
        model.addAttribute("userId", userId);
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));
        UserProfile userProfile= userProfileOptional.get();
        if("job".equals(add)){
            userProfile.getJobs().add(new Job());
        } else if ("education".equals(add)) {
            userProfile.getEducations().add(new Education());
        } else if ("skills".equals(add)) {
            userProfile.getSkills().add(new Skills());
        } else if ("hobbies".equals(add)) {
            userProfile.getHobbies().add(new Hobbies());
        }

        model.addAttribute("userProfile",userProfile);
        return "profile-edit";
    }

    @GetMapping("/delete")
    public String edit(Model model, Principal principal, @RequestParam String type, @RequestParam int index){
        String userId = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));
        UserProfile userProfile= userProfileOptional.get();
        if("job".equals(type)){
            userProfile.getJobs().remove(index);
        } else if ("education".equals(type)) {
            userProfile.getEducations().remove(index);
        } else if ("skills".equals(type)) {
            userProfile.getSkills().remove(index);
        } else if ("hobbies".equals(type)) {
            userProfile.getHobbies().remove(index);
        }
        userProfileRepository.save(userProfile);
        return "redirect:/edit" ;

    }


    @PostMapping("/edit")
    public String postEdit(Model model, Principal principal, @ModelAttribute UserProfile userProfile){
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userName);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userName));
        UserProfile savedUserProfile= userProfileOptional.get();
        userProfile.setId(savedUserProfile.getId());
        userProfile.setUserName(userName);
        userProfileRepository.save(userProfile);
        return "redirect:/view/" + userName;
    }

    @GetMapping("/view/{userId}")
    public String view(Principal principal, @PathVariable String userId, Model model){
        if(principal != null && principal.getName() != " "){
            boolean currentUserProfile = principal.getName().equals(userId);
            model.addAttribute("currentUserProfile", currentUserProfile);
        }
        String userName = principal.getName();
        Optional<UserProfile> userProfileOptional = userProfileRepository.findByUserName(userId);
        userProfileOptional.orElseThrow(() -> new RuntimeException("Not found: " + userId));

        model.addAttribute("userId", userId);
        UserProfile userProfile= userProfileOptional.get();
        model.addAttribute("userProfile", userProfile);
        System.out.println(userProfile.getJobs());
        System.out.println(userProfile.getEducations());
        System.out.println(userProfile.getSkills());

        // model.addAttribute("job", userProfile.getJobs());
        return "profile-templates/" + userProfile.getTheme() + "/index";
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
