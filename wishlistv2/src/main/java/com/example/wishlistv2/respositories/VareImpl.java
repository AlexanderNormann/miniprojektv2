package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VareImpl implements VareRepository {

  @Autowired
  public VareImpl() {
  }

  @Override
  public Vare tilføjVare(Vare vare) throws LoginSampleException {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Varer (varenavn, varestr, beskrivelse, farve, pris, URL) values (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, vare.getNavn());
      preparedStatement.setString(2, vare.getStorrelse());
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

    } catch (SQLException er) {
      throw new LoginSampleException(er.getMessage());
    }

  }

  @Override
  public Wishlist tilføjWishListe(Wishlist wishlist) throws LoginSampleException {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into wishlist(navn, beskrivelse) values (?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, wishlist.getNavn());
      preparedStatement.setString(2, wishlist.getBeskrivelse());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);
      wishlist.setId(id);
      return wishlist;

    } catch (SQLException er) {
      throw new LoginSampleException(er.getMessage());
    }
  }


  public ArrayList<Vare> hentliste (){
    ArrayList<Vare> vareliste = new ArrayList<>();

    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from wishlist.varer";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Vare vare = new Vare();
        vare.setNavn(resultSet.getString("varenavn"));
        vare.setStorrelse(resultSet.getString("varestr"));
        vare.setBeskrivelse(resultSet.getString("beskrivelse"));
        vare.setFarve(resultSet.getString("farve"));
        vare.setURL(resultSet.getString("url"));
        vare.setPris((Integer.parseInt(resultSet.getString("pris"))));
        vareliste.add(vare);
      }


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return vareliste;

  }
  public ArrayList<Wishlist> hentWishlist(){
    ArrayList<Wishlist> listofwishes = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from wishlist.wishlist";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Wishlist wishlist = new Wishlist();
        wishlist.setNavn(resultSet.getString("navn"));
        wishlist.setBeskrivelse(resultSet.getString("beskrivelse"));
        listofwishes.add(wishlist);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listofwishes;
  }






}


