package com.example.wishlistv2.controllers;


import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import com.example.wishlistv2.domain.servives.LoginService;
import com.example.wishlistv2.domain.servives.Services;
import com.example.wishlistv2.respositories.BrugerRepositoryImpl;

import com.example.wishlistv2.respositories.VareImpl;
import org.apache.juli.logging.Log;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class FrontController {

private LoginService loginService = new LoginService(new BrugerRepositoryImpl());
private Services services = new Services(new VareImpl());

  @GetMapping("/")
  public String index() { return "index"; }

  @PostMapping("/login")
  public String loginBruger(WebRequest request) throws LoginSampleException {
    String email = request.getParameter("email");
    String kodeord = request.getParameter("kodeord");

    Bruger bruger = loginService.login(email, kodeord);

    request.setAttribute("bruger", bruger, WebRequest.SCOPE_SESSION);

    return "/";
  }

 /* @GetMapping("/opret")
  public String opret(WebRequest request) throws LoginSampleException{
    String fornavn = request.getParameter("fornavn");
    String efternavn = request.getParameter("efternavn");
    String email = request.getParameter("email");
    String kodeord = request.getParameter("kodeord");
    String gentagkodeord = request.getParameter("gentagkodeord");


    if (kodeord.equals(gentagkodeord)){
      Bruger bruger = loginService.opretBruger(fornavn, efternavn, email, kodeord);
      request.setAttribute("bruger", bruger, WebRequest.SCOPE_SESSION);

    return "opretbruger";
   } else {
      throw  new LoginSampleException("koderne stemmer ikke overens");

   }

  }

  */



  @PostMapping("/gemBruger")
  public String gemBruger(@ModelAttribute("Bruger") Bruger bruger) throws LoginSampleException {
    //System.out.println(bruger.getEfternavn());
    loginService.opretBruger(bruger.getFornavn(), bruger.getEfternavn(), bruger.getEmail(), bruger.getKodeord());
    //loginService.gem(bruger);
    return "redirect:/";
  }

  @PostMapping("/loginBruger")
  public String loginBruger(@ModelAttribute ("Bruger") Bruger bruger) throws LoginSampleException{
    loginService.login(bruger.getEmail(), bruger.getKodeord());
    return "wishsite";
  }

  @PostMapping("/gemVare")
  public String gemVare(@ModelAttribute("Vare") Vare vare) throws LoginSampleException {
    services.opretVare(vare.getNavn(), vare.getStørrelse(), vare.getBeskrivelse(), vare.getFarve(), vare.getPris(), vare.getURL());
    return "wishsite";
  }
/*
  @PostMapping("/visOpretBruger")
  public String visOpretBruger(Model model){
    Bruger bruger = new Bruger();
    model.addAttribute("bruger", bruger);
    return "null";
 }
 */

/*
  @GetMapping("opret1")
  public String opret1(@ModelAttribute ("bruger") Bruger bruger) throws LoginSampleException {
  loginService.opretBruger1(bruger);

return "opretbruger";


  }
*/
  @GetMapping("opret2")
  public String opret2 (@ModelAttribute ("bruger") Bruger bruger) throws LoginSampleException {
    //System.out.println(bruger.getEfternavn());
    //loginService.opretBruger("x", "x", "5", "x");
    return "opretbruger";
  }

  @GetMapping("/login1")
  public String login1 (@ModelAttribute("bruger") Bruger bruger) throws LoginSampleException{
    return "login";
  }


  @GetMapping ("/wishsite")
  public String wishsite(){
    return "wishsite";
  }

  /*
  @PostMapping("opret3")
  public String opret3 (@ModelAttribute("bruger") Bruger bruger) throws LoginSampleException{
    loginService.opretBruger3(bruger);
    return "redirect:/";
  }

  @GetMapping("opret4")
  public String opret4(Model model){
  Bruger bruger = new Bruger();
  model.addAttribute("bruger", bruger);
  return "opretbruger";
  }
  */

}
