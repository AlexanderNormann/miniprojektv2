package com.example.wishlistv2.domain.model;

public class Wishlist {


  private String navn;
  private String beskrivelse;
  private int id;

  public Wishlist() {
  }

  public Wishlist(String navn, String beskrivelse) {
    this.navn = navn;
    this.beskrivelse = beskrivelse;
  }

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
  }

  public String getBeskrivelse() {
    return beskrivelse;
  }

  public void setBeskrivelse(String beskrivelse) {
    this.beskrivelse = beskrivelse;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
