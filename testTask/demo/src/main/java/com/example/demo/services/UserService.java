package com.example.demo.services;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;


//можно было не добавлять, но я решил добавить, чтобы контроллеры выглядели аккуратно и чисто
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findByIndex(@PathVariable Integer id) {
        return userRepository.findById(id);
    }

    public User createNewUser(@RequestBody User user){
        return userRepository.save(user);
    }

    public User updateUser(@PathVariable Integer id, @RequestBody User userToUpdate){
        Optional<User> foundUser = userRepository.findById(id);
        User updatedUser = foundUser.get();
        updatedUser.setName(userToUpdate.getName());
        updatedUser.setEmail(userToUpdate.getEmail());
        updatedUser.setRegistrationDate(userToUpdate.getRegistrationDate());
        return userRepository.save(updatedUser);
    }

    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}
