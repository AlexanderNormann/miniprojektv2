package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

public class ProductImpl implements ProductRepository {

  @Autowired
  public ProductImpl() {
  }

  @Override
  public Products addProduct(Products products) throws LoginSampleException {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Product (productname, productsize, description, color, price, URL) values (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, products.getName());
      preparedStatement.setString(2, products.getSize());
      preparedStatement.setString(3, products.getDescription());
      preparedStatement.setString(4, products.getColor());
      preparedStatement.setInt(5, products.getPrice());
      preparedStatement.setString(6, products.getURL());
      preparedStatement.executeUpdate();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);
      products.setId(id);
      return products;

    } catch (SQLException er) {
      throw new LoginSampleException(er.getMessage());
    }

  }

  @Override
  public Wishlist addToWishlist(Wishlist wishlist) throws LoginSampleException {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into list(name, description) values (?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, wishlist.getName());
      preparedStatement.setString(2, wishlist.getDescription());
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


  public ArrayList<Products> loadList(){
    ArrayList<Products> vareliste = new ArrayList<>();

    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from wishlist.product";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Products products = new Products();
        products.setName(resultSet.getString("productname"));
        products.setSize(resultSet.getString("productsize"));
        products.setDescription(resultSet.getString("description"));
        products.setColor(resultSet.getString("color"));
        products.setURL(resultSet.getString("url"));
        products.setPrice((Integer.parseInt(resultSet.getString("price"))));
        vareliste.add(products);
      }


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return vareliste;

  }
  public ArrayList<Wishlist> loadAllLists(){
    ArrayList<Wishlist> listofwishes = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from wishlist.list";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Wishlist wishlist = new Wishlist();
        wishlist.setName(resultSet.getString("name"));
        wishlist.setDescription(resultSet.getString("description"));
        listofwishes.add(wishlist);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listofwishes;
  }






}


