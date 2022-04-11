package com.change.service;

import com.change.dto.UserDto;
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

    public List<User> getUserList(){
        //database e baglan userlari al dto ya convert et
      List <User> userList = new ArrayList<User>();
       userRepository.findAll().forEach(user-> userList.add(user));



        // List<UserDto> userDtoLıst=new ArrayList<User>();
        //for (User user:userList) {
      //      UserDto userDto = new UserDto();
    //        userDto.setName(user.getName());
  //          userDtoLıst.add(userDto);
//        }
        //donen datayi org.mapstruct.mapper ile dto ya maplemen gerekiyor
       // List<User> userList= List.of(new User("baris"));
        return userList;
    }
    public void saveOrUpdate(User user)
    {
        userRepository.save(user);
    }

    public void delete(long id)
    {
        userRepository.deleteById(id);
    }

    public User updateUser(User user)
    {
        User userDb = userRepository.findById(user.getId()).get();
        userDb.setName(user.getName());
        userRepository.save(userDb);

        return userDb;
    }
}
