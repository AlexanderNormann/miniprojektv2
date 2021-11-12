package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleExeption;
import com.example.wishlistv2.domain.servives.ProductSampleExeption;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
 Products addProduct(Products products, User user) throws LoginSampleExeption, ProductSampleExeption;

 Wishlist addToWishlist(Wishlist wishlist, User user) throws LoginSampleExeption, ProductSampleExeption;

}
