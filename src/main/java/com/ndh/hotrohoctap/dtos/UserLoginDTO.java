package com.ndh.hotrohoctap.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty("username")
    @NotBlank(message = "Username không được trống")
    private String username;
    @JsonProperty("password")
    @NotBlank(message = "Password không được trống")
    private String password;
}
