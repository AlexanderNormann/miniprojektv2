package com.example.wishlistv2.domain.model;

public class Wishlist {


  private String name;
  private String description;
  private int id;

  public Wishlist() {
  }

  public Wishlist(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
