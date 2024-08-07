package com.test2.Test2.mapper;

import com.test2.Test2.dto.request.UserCreationRequest;
import com.test2.Test2.dto.request.UserUpdateRequest;
import com.test2.Test2.dto.response.UserResponse;
import com.test2.Test2.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);
}
