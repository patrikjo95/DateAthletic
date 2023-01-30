package com.dateathletic.backend.service.userservice;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.userservice.uc.UserServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceCrud {
    private final UserRepository userRepository;
    private final UserInfoRepository userInfoRepository;

    public boolean existsByUsernameAndEmail(String username, String email){
        return userRepository.existsByUsernameOrEmail(username, email);
    }
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
    @Override
    public void registerUser(User user) {
        userRepository.save(user);
    }
    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
    @Override
    public Optional<User> getUserByUsername(String username) {
        return getUserByUsername(username);
    }
    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
    @Override
    public void updateUserInfoById(Long id, UpdateUserDto dto) {
        Optional<User> rawUser = userRepository.findById(id);
        UserInfo userInfo = rawUser.orElseThrow().getUserInfo();

        userInfo.setFirstname(dto.firstname());
        userInfo.setLastname(dto.lastname());
        userInfo.setGender(dto.gender());
        userInfo.setBio(dto.bio());
        userInfo.setDoB(dto.doB());
        userInfo.setCity(dto.city());
        userInfo.setGenderPreference(dto.genderPreference());

        userInfoRepository.save((userInfo));
    }
    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}