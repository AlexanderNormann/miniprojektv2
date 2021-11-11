package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository {
 Products addProduct(Products products) throws LoginSampleException;

 Wishlist addToWishlist(Wishlist wishlist, User user) throws LoginSampleException;

}
