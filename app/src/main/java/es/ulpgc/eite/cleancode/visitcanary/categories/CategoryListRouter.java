package es.ulpgc.eite.cleancode.visitcanary.categories;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.products.ProductListActivity;


public class CategoryListRouter implements CategoryListContract.Router {

  public static String TAG = CategoryListRouter.class.getSimpleName();

  private CatalogMediator mediator;


  public CategoryListRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToProductListScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, ProductListActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  }

  @Override
  public void passDataToProductListScreen(CategoryItem item) {
    mediator.setCategory(item);
  }

}
