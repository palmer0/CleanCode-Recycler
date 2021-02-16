package es.ulpgc.eite.cleancode.visitcanary.app;

import es.ulpgc.eite.cleancode.visitcanary.categories.CategoryListState;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.ProductItem;
import es.ulpgc.eite.cleancode.visitcanary.product.ProductDetailState;
import es.ulpgc.eite.cleancode.visitcanary.products.ProductListState;

public class CatalogMediator  {

  private CategoryListState categoryListState = new CategoryListState();
  private ProductListState productListState = new ProductListState();
  private ProductDetailState productDetailState = new ProductDetailState();

  private CategoryItem category;
  private ProductItem product;

  private static CatalogMediator INSTANCE;

  private CatalogMediator() {

  }

  public static void resetInstance() {
    INSTANCE = null;
  }


  public static CatalogMediator getInstance() {
    if(INSTANCE ==null){
      INSTANCE = new CatalogMediator();
    }

    return INSTANCE;
  }

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
