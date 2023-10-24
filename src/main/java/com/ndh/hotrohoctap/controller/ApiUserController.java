package com.ndh.hotrohoctap.controller;

import com.ndh.hotrohoctap.dtos.UserDTO;
import com.ndh.hotrohoctap.dtos.UserLoginDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.exceptions.InvalidParamException;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.services.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.FieldError;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class ApiUserController {
    private final IUserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAllBaiTap() {
        List<User> listUser = userService.getAllUser();
        return ResponseEntity.ok(listUser);
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO,
                                        BindingResult result){
       try {
           if (result.hasErrors()) {
               List<String> errorMessages = result.getFieldErrors()
                       .stream()
                       .map(FieldError::getDefaultMessage)
                       .toList();

           }


           if(!userDTO.getPassword().equals(userDTO.getRetypePassword())){
               return ResponseEntity.badRequest().body("password not match");
           }
           Boolean existingUser = userService.existingUser(userDTO.getUsername());
           if (existingUser) {
               System.out.println("da vao toi");
               return ResponseEntity
                       .status(HttpStatus.BAD_REQUEST)  // Đặt mã lỗi HTTP
                       .body("Người dùng đã tồn tại.");

           }
           userService.createUser(userDTO);
           return ResponseEntity.ok("Dang ki thanh cong");
       }
       catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
       }

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginDTO userLoginDTO) throws InvalidParamException, DataNotFoundException {
        try{
            String token = userService.login(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            return ResponseEntity.ok(token);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/current-user")
    public ResponseEntity<?> currentUser(@RequestBody String token) {
        try {
            // Gọi dịch vụ để kiểm tra token và lấy thông tin người dùng
            User userInfo = userService.getUserInfoByToken(token);

            if (userInfo != null) {
                return ResponseEntity.ok(userInfo);
            } else {
                return ResponseEntity.badRequest().body("Invalid or expired token.");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getDiemById(@PathVariable Long id) throws Exception {
        Optional<User> diemBaiTaps = userService.getUserById(id);
//
//        List<DiemMonHocDTO> diemMonHocDTOs = diemBaiTaps.stream()
//                .map(diemMonHoc -> new DiemMonHocDTO(
//                        diemMonHoc.getBaiTap().getTenBaiTap(),
//                        diemMonHoc.getDiem(), diemMonHoc.getThoiGian()))
//                .collect(Collectors.toList());

        return ResponseEntity.ok(diemBaiTaps);

    }

}
