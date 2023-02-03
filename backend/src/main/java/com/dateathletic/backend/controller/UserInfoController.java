package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.service.userservice.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/search-by")
public class UserInfoController {
    private final UserInfoService service;

    @GetMapping
    public Page<UserInfo> findAll(@RequestParam int page, @RequestParam int size){
        PageRequest pageRequest = PageRequest.of(page, size);
        return service.findAll(pageRequest);
    }

    @GetMapping("/firstname/{firstname}")
    public UserInfo findUserByfirstName(@PathVariable String firstname){
        Optional<UserInfo> user = service.getUserByFirstname(firstname);
        return user.orElse(null);
    }

    @GetMapping("/lastname/{lastname}")
    public UserInfo findUserBylastName(@PathVariable String lastname){
        Optional<UserInfo> user = service.getUserByLastname(lastname);
        return user.orElse(null);
    }

    @GetMapping("/dob/{dob}")
    public Page<UserInfo> findAllByDob(@PathVariable String doB, @RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByDoB(doB, pageable);
    }

    @GetMapping("/firstname2/{firstname}")
    public Page<UserInfo> findAllByFirstname(@PathVariable String firstname, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByFirstname(firstname, pageable);
    }

    @GetMapping("/lastname2/{lastname}")
    public Page<UserInfo> findAllByLastname(@PathVariable String lastname, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByLastname(lastname, pageable);
    }

    @GetMapping("/gender/{gender}")
    public Page<UserInfo> findAllByGender(@PathVariable String gender, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByGender(gender, pageable);
    }

    @GetMapping("/genderpreference/{genderpreference}")
    public Page<UserInfo> findAllByGenderpreference(@PathVariable String genderPreference, @RequestParam int page, @RequestParam int size) {
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByGenderPreference(genderPreference, pageable);
    }

    @GetMapping("/city/{city}")
    public Page<UserInfo> findAllByCity(@PathVariable String city, @RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByCity(city, pageable);
    }

    @GetMapping("/interests/{interests}")
    public Page<UserInfo> findAllByInterests(@PathVariable String interests, @RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page, size);
        return service.findAllByInterests(interests, pageable);
    }
}
