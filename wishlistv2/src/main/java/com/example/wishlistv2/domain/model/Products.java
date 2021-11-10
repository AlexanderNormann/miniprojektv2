package com.example.wishlistv2.domain.model;

public class Products {

  private String name;
  private String size;
  private String description;
  private String color;
  private int price;
  private String URL;
  private int id;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public Products(String name, String size, String description, String color, int id, int price) {
    this.name = name;
    this.size = size;
    this.description = description;
    this.color = color;
    this.price = price;
    this.id = id;
  }

  public Products(String name, String size, String description, String color, int price, String URL) {
    this.name = name;
    this.size = size;
    this.description = description;
    this.color = color;
    this.URL = URL;
    this.price = price;
  }

  public Products(){

  }
}
