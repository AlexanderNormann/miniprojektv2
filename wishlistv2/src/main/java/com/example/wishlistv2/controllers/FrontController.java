package com.example.wishlistv2.controllers;


import com.example.wishlistv2.domain.model.User;
import com.example.wishlistv2.domain.model.Products;
import com.example.wishlistv2.domain.model.Wishlist;
import com.example.wishlistv2.domain.servives.LoginSampleException;
import com.example.wishlistv2.domain.servives.LoginService;
import com.example.wishlistv2.domain.servives.Services;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

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



  @PostMapping("/saveUser")
  public String saveUser(@ModelAttribute("User") User user) throws LoginSampleException {
    //System.out.println(bruger.getEfternavn());
    loginService.createUser(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword());
    //loginService.gem(bruger);
    return "redirect:/";
  }


  @PostMapping("/loginBruger")
  public String loginBruger(@ModelAttribute ("User") User user, HttpSession httpSession) throws LoginSampleException{
    User loggedinUser = loginService.login(user.getEmail(), user.getPassword());
    httpSession.setAttribute("user", loggedinUser);
    return "wishlist_overview";
  }



  @GetMapping("/logout")
  public String logout(HttpSession httpSession){
    if(httpSession != null){
      httpSession.invalidate();
    }
    return "index";
  }

  @PostMapping("/saveProduct")
  public String gemVare(@ModelAttribute("Product") Products products, HttpSession httpSession) throws LoginSampleException {
    User user = (User)httpSession.getAttribute("user");
    System.out.println(user.getId());
    services.saveProduct(products, user);
    return "wishlist_overview";
  }

  @GetMapping("/addProduct")
    public String opretVare(Model model){
     Products products = new Products();
     model.addAttribute("Product", products);
     return "add_wish";
    }

  @GetMapping("/create")
  public String create(@ModelAttribute ("User") User user) throws LoginSampleException {
    //System.out.println(bruger.getEfternavn());
    //loginService.opretBruger("x", "x", "5", "x");
    return "create_user";
  }

  @GetMapping("/login")
  public String login(@ModelAttribute("User") User user, HttpSession hs) throws LoginSampleException{
    hs.setAttribute("user", user);
    return "login";
  }




  @GetMapping ("/addwish")
  public String wishsite(){
    return "add_wish";
  }



  @GetMapping("/showProducts")
  public String visliste (Model model, HttpSession httpSession){
    User user = (User)httpSession.getAttribute("user");
    model.addAttribute("productlist", services.loadProducts(user.getId()));
    return "product_list";
  }

  @GetMapping("/wishlist")
  public String visWishlists(){

    return "wishlist";
  }

  @GetMapping("/createWishlist")
  public String opretwishlist(Model model){
    Wishlist wishlist = new Wishlist();
    model.addAttribute("wishlist", wishlist);
    return "create_wishlist";
  }

  @GetMapping("/showWishlist")
  public String vislists(Model model, HttpSession httpSession){
    User user = (User)httpSession.getAttribute("user");
    model.addAttribute("wishlist", services.loadAllLists(user.getId()));
    System.out.println("test");
    return "wishlist";
  }

  @GetMapping("/overview")
  public String  wlo (){
    return "wishlist_overview";
  }

  @PostMapping("/saveWishlist")

  public String gemWishlist(@ModelAttribute("Wishlist") Wishlist wishlist, HttpSession httpSession) throws LoginSampleException{
    User user = (User)httpSession.getAttribute("user");
    System.out.println(user.getId());
    services.loadWishlist(wishlist, user);

    return "wishlist_overview";
  }





}


