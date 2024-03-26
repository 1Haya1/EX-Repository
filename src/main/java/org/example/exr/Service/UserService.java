package org.example.exr.Service;

import lombok.RequiredArgsConstructor;
import org.example.exr.Api.ApiException;
import org.example.exr.Model.User;
import org.example.exr.Reopsitory.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){

        return userRepository.findAll();
    }

    public void addUser(User user){

       userRepository.save(user);
    }


    public void updateUser(Integer id,User user){
        User c=userRepository.findUserById(id);

        if(c==null){
            throw new ApiException("wrong id");
        }

        c.setUsername(user.getUsername());
        c.setName(user.getName());
        c.setPassword(user.getPassword());
        c.setEmail(user.getEmail());
        c.setAge(user.getAge());
        c.setRole(user.getRole());
        userRepository.save(c);

    }
    public void deleteUser(Integer id) {
        User c = userRepository.findUserById(id);
        if (c == null) {
            throw new ApiException("wrong id");
        }
        userRepository.delete(c);
    }



    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findUserByUsernameAndPassword(username,password);
        if (user != null ) {
            throw new ApiException("wrong username or password");
        }
            return user;
        }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    public List<User> getUsersWithAgeOrAbove(Integer age) {
        return userRepository.findByAgeGreater(age);
    }







}
