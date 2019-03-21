package es.ulpgc.eite.cleancode.visitcanary.data;

public class ProductItem {

  public int id;

  public String content;
  public String details;
  public String picture;

  public int categoryId;


  @Override
  public String toString() {
    return content;
  }
}