package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.servives.LoginSampleException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class VareImpl implements VareRepository{

  @Override
  public Vare tilføjVare(Vare vare) throws LoginSampleException {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Varer (varenavn, varestr, beskrivelse, farve, pris, URL) values (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, vare.getNavn());
      preparedStatement.setString(2, vare.getStørrelse());
      preparedStatement.setString(3, vare.getBeskrivelse());
      preparedStatement.setString(4, vare.getFarve());
      preparedStatement.setInt(5, vare.getPris());
      preparedStatement.setString(6, vare.getURL());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);
      vare.setId(id);
      return vare;

    }catch(SQLException er){
      System.out.println("Fejl, du har ikke intastet korrekte oplysninger");
    }
    return null;
  }
}
