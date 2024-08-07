package com.test2.Test2.service;

import com.test2.Test2.dto.request.UserUpdateRequest;
import com.test2.Test2.dto.response.UserResponse;
import com.test2.Test2.entity.User;
import com.test2.Test2.exception.AppException;
import com.test2.Test2.exception.ErrorCode;
import com.test2.Test2.mapper.UserMapper;
import com.test2.Test2.repository.UserRepository;
import com.test2.Test2.dto.request.UserCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private UserMapper userMapper;
    public User createUser(UserCreationRequest request) {

        if(userRepository.existsByUserName(request.getUserName()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request);

        return userRepository.save(user);

    }

    public UserResponse updateUser(String userName, UserUpdateRequest request) {
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found."));

        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));

    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public UserResponse getFindByUserName(String userName) {
        return userMapper.toUserResponse(userRepository.findByUserName(userName)
                .orElseThrow(() -> new RuntimeException("User not found.")));
    }

    public User getFindById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        Long usrId = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found")).getId();
        userRepository.deleteById(usrId);
    }

}
