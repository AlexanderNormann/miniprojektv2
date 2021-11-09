package com.example.wishlistv2.domain.model;

public class Vare {

  private String navn;
  private String storrelse;
  private String beskrivelse;
  private String farve;
  private int pris;
  private String URL;
  private int id;

  public String getNavn() {
    return navn;
  }

  public void setNavn(String navn) {
    this.navn = navn;
  }

  public String getStorrelse() {
    return storrelse;
  }

  public void setStorrelse(String storrelse) {
    this.storrelse = storrelse;
  }

  public String getBeskrivelse() {
    return beskrivelse;
  }

  public void setBeskrivelse(String beskrivelse) {
    this.beskrivelse = beskrivelse;
  }

  public String getFarve() {
    return farve;
  }

  public void setFarve(String farve) {
    this.farve = farve;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPris() {
    return pris;
  }

  public void setPris(int pris) {
    this.pris = pris;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public Vare(String navn, String størrelse, String beskrivelse, String farve, int id, int pris) {
    this.navn = navn;
    this.storrelse = størrelse;
    this.beskrivelse = beskrivelse;
    this.farve = farve;
    this.pris = pris;
    this.id = id;
  }

  public Vare(String navn, String størrelse, String beskrivelse, String farve, int pris, String URL) {
    this.navn = navn;
    this.storrelse = størrelse;
    this.beskrivelse = beskrivelse;
    this.farve = farve;
    this.URL = URL;
    this.pris = pris;
  }

  public Vare(){

  }
}
