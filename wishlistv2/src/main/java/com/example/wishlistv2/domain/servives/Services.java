package com.example.wishlistv2.domain.servives;

import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.respositories.BrugerRepository;
import com.example.wishlistv2.respositories.VareImpl;
import com.example.wishlistv2.respositories.VareRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class Services implements VareRepository {
  private BrugerRepository brugerRepository;
  private VareRepository vareRepository;
  private VareImpl vareimpl;

  public Services(){
    this.vareimpl = new VareImpl();
  }

  public Vare opretVare(String navn, String størrelse, String beskrivelse, String farve, int pris, String URL) throws LoginSampleException {
    Vare vare = new Vare(navn, størrelse, beskrivelse, farve, pris, URL);
    return vareRepository.tilføjVare(vare);
  }

  public Vare gemVare(Vare vare) throws LoginSampleException {
    return vareRepository.tilføjVare(vare);
  }

  @Override
  public Vare tilføjVare(Vare vare) throws LoginSampleException {
    return null;
  }

  public ArrayList<Vare> hentAlleVarer() {
    return vareimpl.hentliste();
  }



  @Override
  public Wishlist tilføjWishListe(Wishlist wishlist) throws LoginSampleException {
    return null;
  }
}
