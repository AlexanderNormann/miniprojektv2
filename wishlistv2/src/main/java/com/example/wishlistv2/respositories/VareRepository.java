package com.example.wishlistv2.respositories;

import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.servives.LoginSampleException;

public interface VareRepository {
 Vare tilføjVare(Vare vare) throws LoginSampleException;

}
