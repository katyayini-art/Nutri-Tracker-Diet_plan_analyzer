package com.nutri.service;

import java.util.List;
import java.util.Optional;   // 🔥 This import add చేయాలి

import org.springframework.stereotype.Service;

import com.nutri.model.User;
import com.nutri.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ✅ Register User
    public User saveUser(User user) {
        return userRepository.save(user);
    }
  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
}
public void deleteUser(Long id) {
    userRepository.deleteById(id);
}

    // ✅ Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ 🔥 ADD THIS LOGIN METHOD BELOW
    public String loginUser(String email, String password) {

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isPresent()) {
            if(user.get().getPassword().equals(password)) {
                return "Login Successful";
            } else {
                return "Wrong Password";
            }
        }

        return "User Not Found";
    }
}