package es.ulpgc.eite.cleancode.visitcanary.products;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.ProductItem;
import es.ulpgc.eite.cleancode.visitcanary.product.ProductDetailActivity;


public class ProductListRouter implements ProductListContract.Router {

  public static String TAG = ProductListRouter.class.getSimpleName();

  private CatalogMediator mediator;

  public ProductListRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToProductDetailScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ProductDetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToProductDetailScreen(ProductItem item) {

    mediator.setProduct(item);
  }

  @Override
  public CategoryItem getDataFromCategoryListScreen() {
    CategoryItem category = mediator.getCategory();
    return category;
  }

}
