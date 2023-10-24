package com.ndh.hotrohoctap.services;

import com.ndh.hotrohoctap.dtos.UserDTO;
import com.ndh.hotrohoctap.exceptions.DataNotFoundException;
import com.ndh.hotrohoctap.exceptions.InvalidParamException;
import com.ndh.hotrohoctap.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(UserDTO userDTO) throws Exception;

    String login(String username, String password) throws DataNotFoundException, InvalidParamException;
    void disableUser(long id);
    List<User> getAllUser();

    Boolean existingUser(String username);
    User getUserInfoByToken(String token);

    Optional<User> getUserById(Long id);

}
