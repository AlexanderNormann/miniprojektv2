package com.example.wishlistv2.respositories;


import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.servives.LoginSampleExeption;

public interface UserRepository {

  public User login(String email, String kodeord) throws LoginSampleExeption;

  public User createUser(User user) throws LoginSampleExeption;


}
