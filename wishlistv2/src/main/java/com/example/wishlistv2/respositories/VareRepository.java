package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VareRepository {
 Vare tilføjVare(Vare vare) throws LoginSampleException;

 Wishlist tilføjWishListe (Wishlist wishlist) throws LoginSampleException;

}
