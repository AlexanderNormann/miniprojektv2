package com.example.wishlistv2.domain.servives;


import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.respositories.BrugerRepository;
import com.example.wishlistv2.respositories.BrugerRepositoryImpl;

public class LoginService {

  private BrugerRepository brugerRepository = null;

  public LoginService(BrugerRepositoryImpl brugerRepository) {
    this.brugerRepository = brugerRepository;

  }

  public Bruger login(String email, String kodeord) throws LoginSampleException{
    return brugerRepository.login(email, kodeord);
  }
  
  public Bruger opretBruger (String fornavn, String efternavn, String email, String kodeord) throws LoginSampleException{
    Bruger bruger = new Bruger(fornavn, efternavn, email, kodeord);

    return brugerRepository.opretBruger(bruger);
  }

  /*
  public void gem(Bruger bruger) {
    brugerRepository.gem(bruger);
  }
  public void opret1(Bruger bruger) throws LoginSampleException{
  this.brugerRepository.opret1(bruger);
  }

  public void opretBruger1(Bruger bruger) throws LoginSampleException {
    this.brugerRepository.opretBruger1(bruger);
  }
  public void opretBruger3(Bruger bruger) throws LoginSampleException{
    Bruger bruger1 = new Bruger();
  }

*/
}
