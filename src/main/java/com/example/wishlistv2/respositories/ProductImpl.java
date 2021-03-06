package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.ProductSampleExeption;
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
  public Products addProduct(Products products, User user) throws ProductSampleExeption {
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "insert into Product (productname, productsize, productdescription, color, price, URL, userID_FK) values (?, ?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, products.getName());
      preparedStatement.setString(2, products.getSize());
      preparedStatement.setString(3, products.getDescription());
      preparedStatement.setString(4, products.getColor());
      preparedStatement.setString(5, products.getPrice());
      preparedStatement.setString(6, products.getURL());
      preparedStatement.setInt(7, user.getId());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      resultSet.next();
      int id = resultSet.getInt(1);
      products.setId(id);
      return products;

    } catch (SQLException er) {
      throw new ProductSampleExeption(er.getMessage());
    }

  }

  @Override
  public Wishlist addToWishlist(Wishlist wishlist, User user) throws ProductSampleExeption {
    try{
      Connection connection = DBManager.getConnection();
      String SQL = "insert into list(listname, listdescription, userID_FK) values (?,?,?)";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setString(1, wishlist.getName());
      preparedStatement.setString(2, wishlist.getDescription());
      preparedStatement.setInt(3, user.getId());

      preparedStatement.execute();
      return null;
    } catch (SQLException er) {
      throw new ProductSampleExeption(er.getMessage());
    }
  }


  public ArrayList<Products> loadProductList(int id){
    ArrayList<Products> vareliste = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from heroku_5d6c77a39e46e76.product " + "where userID_FK = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Products products = new Products();
        products.setName(resultSet.getString("productname"));
        products.setSize(resultSet.getString("productsize"));
        products.setDescription(resultSet.getString("productdescription"));
        products.setColor(resultSet.getString("color"));
        products.setURL(resultSet.getString("url"));
        products.setId(resultSet.getInt(("productID")));
        products.setPrice((resultSet.getString("price")));
        vareliste.add(products);
      }


    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return vareliste;

  }

  public void deleteProduct(int id){
   try{
    Connection connection = DBManager.getConnection();
    String SQL = "delete from heroku_5d6c77a39e46e76.product where productID = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    preparedStatement.setInt(1, id);
    preparedStatement.execute();
   } catch(SQLException er){
     er.getMessage();
   }

  }
  public ArrayList<Wishlist> loadAllLists(int id){
    ArrayList<Wishlist> listofwishes = new ArrayList<>();
    try {
      Connection connection = DBManager.getConnection();
      String SQL = "select * from heroku_5d6c77a39e46e76.list" + " where userID_FK = ? ";
      PreparedStatement preparedStatement = connection.prepareStatement(SQL);
      preparedStatement.setInt(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()){
        Wishlist wishlist = new Wishlist();
        wishlist.setName(resultSet.getString("listname"));
        wishlist.setDescription(resultSet.getString("listdescription"));
        listofwishes.add(wishlist);
      }

    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return listofwishes;
  }






}


