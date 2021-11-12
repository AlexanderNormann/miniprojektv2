package com.example.wishlistv2.domain.servives;


import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.respositories.UserRepository;
import com.example.wishlistv2.respositories.UserRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private UserRepository userRepository;

  public LoginService(UserRepositoryImpl userRepository) {
    this.userRepository = userRepository;

  }

  public User login(String email, String password) throws LoginSampleExeption {

    return userRepository.login(email, password);
  }
  
  public User createUser(String firstname, String lastname, String email, String password) throws LoginSampleExeption {
    User user = new User(firstname, lastname, email, password);

    return userRepository.createUser(user);
  }
}
