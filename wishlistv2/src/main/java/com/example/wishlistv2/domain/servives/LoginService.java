package com.example.wishlistv2.domain.servives;


import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.respositories.BrugerRepository;
import com.example.wishlistv2.respositories.BrugerRepositoryImpl;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

  private BrugerRepository brugerRepository;

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
}
