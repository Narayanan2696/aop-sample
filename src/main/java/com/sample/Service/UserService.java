package com.sample.Service;

import com.sample.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  public List<UserDto> getUsers() {
    return List.of(new UserDto());
  }
}
