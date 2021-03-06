package com.example.wishlistv2.respositories;


import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.servives.LoginSampleExeption;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

  @Override
  public User login(String email, String password) throws LoginSampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select userid from users " +  "where email = ? and password = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, password);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()){
        int id = resultSet.getInt("userid");
        User user = new User(email, password);
        user.setId(id);
        return user;
      } else {
        throw new LoginSampleExeption("kunne ikke ikke login");
      }

    } catch (SQLException ex) {
      throw new LoginSampleExeption(ex.getMessage());
    }

  }

  @Override
  public User createUser(User user) throws LoginSampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Users (firstname, lastname, email, password) values (?, ?, ?, ?) ";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, user.getFirstname());
      preparedStatement.setString(2, user.getLastname());
      preparedStatement.setString(3, user.getEmail());
      preparedStatement.setString(4, user.getPassword());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);
      user.setId(id);
      return user;

    } catch (SQLException er) {
      throw new LoginSampleExeption(er.getMessage());
    }

  }
}
