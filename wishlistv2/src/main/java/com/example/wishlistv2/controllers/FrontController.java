package com.example.wishlistv2.controllers;


import com.example.wishlistv2.domain.model.Bruger;
import com.example.wishlistv2.domain.model.Vare;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import com.example.wishlistv2.domain.servives.LoginService;
import com.example.wishlistv2.domain.servives.Services;
import com.example.wishlistv2.respositories.BrugerRepositoryImpl;

import com.example.wishlistv2.respositories.VareImpl;
import com.example.wishlistv2.respositories.VareRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class FrontController {

private LoginService loginService;
private Services services;

  public FrontController(LoginService loginService, Services services) {
    this.loginService = loginService;
    this.services = services;
  }

  @GetMapping("/")
  public String index() { return "index"; }



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
    return "wishlistoverview";
  }

  @PostMapping("/gemVare")
  public String gemVare(@ModelAttribute("Vare") Vare vare) throws LoginSampleException {
    //services.opretVare(vare.getNavn(), vare.getStørrelse(), vare.getBeskrivelse(), vare.getFarve(), vare.getPris(), vare.getURL());
    services.gemVare(vare);
    System.out.println("HEJ");
    return "wishlistoverview";
  }

  @GetMapping("/opretVare")
    public String opretVare(Model model){
     Vare vare = new Vare();
     model.addAttribute("Vare", vare);
     return "addwish";
    }

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


  @GetMapping ("/addwish")
  public String wishsite(){
    return "addwish";
  }



  @GetMapping("/visvare")
  public String visliste (Model model){
    model.addAttribute("vareliste", services.hentAlleVarer());
    return "vareliste";
  }

  @GetMapping("/wishlist")
  public String visWishlists(){
    return "wishlist";
  }

  @GetMapping("/opretwishlist")
  public String opretwishlist(Model model){
    Wishlist wishlist = new Wishlist();
    model.addAttribute("wishlist", wishlist);
    return "opretwishlist";
  }

  @PostMapping("/gemWishlist")
  public String gemWishlist (@ModelAttribute("Wishlist") Wishlist wishlist) throws LoginSampleException {
    services.gemWishlist(wishlist);
    return "wishlistoverview";
  }




}


