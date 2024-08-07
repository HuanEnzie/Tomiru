package com.test2.Test2.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.test2.Test2.dto.request.ApiResponse;
import com.test2.Test2.dto.request.UserCreationRequest;
import com.test2.Test2.dto.request.UserUpdateRequest;
import com.test2.Test2.dto.response.UserResponse;
import com.test2.Test2.entity.User;
import com.test2.Test2.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserController {
    private final UserService userService;

    @PostMapping
    public ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setResult(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{userName}")
    public UserResponse updateUser(@PathVariable String userName, @RequestBody @Valid UserUpdateRequest request){
        return userService.updateUser(userName, request);
    }

    @GetMapping("/{userName}")
    public UserResponse getUser(@PathVariable String userName){
        return userService.getFindByUserName(userName);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Successfully delete.");
    }
}
