package es.ulpgc.eite.cleancode.visitcanary.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.visitcanary.categories.CategoryListState;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.ProductItem;
import es.ulpgc.eite.cleancode.visitcanary.product.ProductDetailState;
import es.ulpgc.eite.cleancode.visitcanary.products.ProductListState;

public class CatalogMediator extends Application {

  private CategoryListState categoryListState = new CategoryListState();
  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  private CategoryItem category;
  private ProductItem product;

  public CategoryListState getCategoryListState() {
    return categoryListState;
  }

  public ProductDetailState getProductDetailState() {
    return productDetailState;
  }

  public ProductListState getProductListState() {
    return productListState;
  }

  public ProductItem getProduct() {
    ProductItem item = product;
    //product = null;
    return item;
  }


  public void setProduct(ProductItem item) {
    product = item;
  }

  public void setCategory(CategoryItem item) {
    category = item;
  }

  public CategoryItem getCategory() {
    CategoryItem item = category;
    //category = null;
    return item;
  }

}
