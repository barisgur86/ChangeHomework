package com.change.service;

import com.change.dto.UserDto;
import com.change.dto.UserDtoMapper;
import com.change.entity.User;
import com.change.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoMapper userDtoMapper;

    public List<UserDto> getUserList(){
        //database e baglan userlari al dto ya convert et
      List <User> userList = new ArrayList<User>();
       userRepository.findAll().forEach(user-> userList.add(user));
       List<UserDto> userDtoList = new ArrayList<UserDto>();
               userList.forEach(user-> userDtoList.add(userDtoMapper.usertoDto(user)));

        //donen datayi org.mapstruct.mapper ile dto ya maplemen gerekiyor
       // List<User> userList= List.of(new User("baris"));
        return userDtoList;
    }
    public void saveOrUpdate(UserDto userDto)
    {
        System.out.println(userDto.getName());
        User user = userDtoMapper.dtoToUser(userDto);
        System.out.println(user.getName());
        userRepository.save(user);
    }

    public void delete(long id)
    {
        userRepository.deleteById(id);
    }

    public UserDto updateUser(UserDto userDto)
    {

        User userDb = userRepository.findById(userDto.getId()).get();
        userDb.setName(userDto.getName());
        userRepository.save(userDb);
        userDto =userDtoMapper.usertoDto(userDb);

        return userDto;
    }
}
