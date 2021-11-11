package com.example.wishlistv2.domain.servives;

import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.respositories.UserRepository;
import com.example.wishlistv2.respositories.ProductImpl;
import com.example.wishlistv2.respositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Services implements ProductRepository {
  private UserRepository userRepository; //Den her bliver ikke brugt btw
  private ProductRepository productRepository;
  private ProductImpl productimpl;

  public Services(){
    this.productimpl = new ProductImpl();
  }

  /* public Products createProduct(String name, String size, String description, String color, int price, String URL) throws LoginSampleException {
    Products products = new Products(name, size, description, color, price, URL);
    return productRepository.addProduct(products); //CreateProduct bliver ikke brugt btw
  }

   */

  public Products saveProduct(Products products, User user) throws LoginSampleException {
    return productimpl.addProduct(products, user);
  }

  @Override
  public Products addProduct(Products products, User user) throws LoginSampleException {
    return null;
  }

  public ArrayList<Products> loadProducts(int id) {
    return productimpl.loadProductList(id); //Vejledning til doug (Class diagram)
  }



  @Override
  public Wishlist addToWishlist(Wishlist wishlist, User user) throws LoginSampleException {
    return null;
  }

  public Wishlist loadWishlist(Wishlist wishlist, User user) throws LoginSampleException{
    return productimpl.addToWishlist(wishlist, user);
  }
  public ArrayList<Wishlist> loadAllLists(int id){
    return productimpl.loadAllLists(id);
  }

}
