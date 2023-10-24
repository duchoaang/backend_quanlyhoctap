package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.components.JwtTokenUtils;
import com.ndh.hotrohoctap.dtos.UserDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.exceptions.InvalidParamException;
import com.ndh.hotrohoctap.models.User;
import com.ndh.hotrohoctap.repositories.UserRepository;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final JwtTokenUtils jwtTokenUtil;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final EmailService emailService;
    @Override
    public User createUser(UserDTO userDTO) throws Exception {

        String username = userDTO.getUsername();

        if(userRepository.existsByUsername(username)) {
            throw new DataIntegrityViolationException("username already exists");
        }
        User newUser = User.builder()
                .mssv(Long.parseLong(userDTO.getMssv()) )
                .name(userDTO.getName())
                .email(userDTO.getEmail())
                .active(true)
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .userRole("USER")
                .build();
        String password = userDTO.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        newUser.setPassword(encodedPassword);
        emailService.sendEmail(userDTO.getEmail(),"Tài khoản được tạo mới","Tài khoản sinh viên của bạn đã được tạo với username:" + userDTO.getUsername() + " và mật khẩu: " + userDTO.getPassword());
        System.out.println("Da vao day gui mail");
        return userRepository.save(newUser);
    }

    @Override
    public String login(String username, String password) throws DataNotFoundException, InvalidParamException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isEmpty()){
            throw new DataNotFoundException("Invalid username / password");
        }
        User existingUser = optionalUser.get();
        if(!passwordEncoder.matches(password, existingUser.getPassword())) {
            throw new BadCredentialsException("Wrong password ko trung nhau");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                username, password
        );
        authenticationManager.authenticate(authenticationToken);
        return jwtTokenUtil.generateToken(optionalUser.get());
    }

    @Override
    public void disableUser(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false); // Đặt trạng thái active thành false
            userRepository.save(user); // Lưu thay đổi vào cơ sở dữ liệu

        } else {

        }
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public Boolean existingUser(String username) {
        return userRepository.existsByUsername(username);
    }


    @Override
    public User getUserInfoByToken(String token) {

        final String username = jwtTokenUtil.extractUsername(token);
        return (User) userDetailsService.loadUserByUsername(username);
    }

    @Override
    public Optional<User> getUserById(Long id) {
      Optional<User> user =  userRepository.findById(id);
        return  user;
    }
}
