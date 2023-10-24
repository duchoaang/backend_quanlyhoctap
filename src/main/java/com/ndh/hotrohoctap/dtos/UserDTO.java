package com.ndh.hotrohoctap.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotEmpty(message = "Mã số sinh viên không được trống")
    @JsonProperty("mssv")
    private String mssv;

    @NotEmpty(message = "Họ tên không được trống")
    @JsonProperty("name")
    private String name;

    @NotEmpty(message = "Email không được trống")
    @JsonProperty("email")
    private String email;

    @NotEmpty(message = "Tên người dùng không được trống")
    @JsonProperty("username")
    private String username;

    @NotEmpty(message = "Nhập lại mật khẩu không được trống")
    @JsonProperty("retypePassword")
    private String retypePassword;

    @NotEmpty(message = "Mật khẩu không được trống")
    @JsonProperty("password")
    private String password;


}
