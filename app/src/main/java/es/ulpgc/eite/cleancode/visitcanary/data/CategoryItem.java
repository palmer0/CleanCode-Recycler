package es.ulpgc.eite.cleancode.visitcanary.data;


import com.google.gson.annotations.SerializedName;

import java.util.List;


public class CategoryItem {

  public int id;

  public String content;
  public String details;

  @SerializedName("products")
  public List<ProductItem> items;

  @Override
  public String toString() {
    return content;
  }
}