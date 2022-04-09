package com.change.service;

import com.change.dto.UserDto;
import com.change.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDto> getUserList(){
        //database e baglan userlari al dto ya convert et
        //userRepository.findAll();
        //donen datayi org.mapstruct.mapper ile dto ya maplemen gerekiyor
       return List.of(new UserDto("baris"));
    }
}
