package com.example.wishlistv2.domain.servives;

import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.respositories.BrugerRepository;
import com.example.wishlistv2.respositories.VareImpl;
import com.example.wishlistv2.respositories.VareRepository;

public class Services {
  private BrugerRepository brugerRepository;
  private VareRepository vareRepository;
public Services(VareImpl vareRepository){
  this.vareRepository = vareRepository;
}


  public Vare opretVare(String navn, String størrelse, String beskrivelse, String farve, int pris, String URL) throws LoginSampleException {
    Vare vare = new Vare(navn, størrelse, beskrivelse, farve, pris, URL);
    return vareRepository.tilføjVare(vare);
  }

  public Vare gemVare(Vare vare) throws LoginSampleException {
    return vareRepository.tilføjVare(vare);
  }

  /*
  public void gem(Bruger bruger){
    brugerRepository.gem(bruger);

  }

   */
}
