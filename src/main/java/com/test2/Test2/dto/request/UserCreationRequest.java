package com.test2.Test2.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserCreationRequest {
    @Size(min = 6, message = "INVALID_USERNAME")
    String userName;
    @Size(min = 8, message = "INVALID_PASSWORD")
    String password;
    @NotBlank(message = "Please fill your full name.")
    String fullName;
    @Min(value = 18 , message = "User must be greater than 18 years old.")
    int age;
    String address;
}
