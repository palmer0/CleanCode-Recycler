package es.ulpgc.eite.cleancode.visitcanary.product;

import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;
import es.ulpgc.eite.cleancode.visitcanary.data.ProductItem;


public class ProductDetailRouter implements ProductDetailContract.Router {

  public static String TAG = ProductDetailRouter.class.getSimpleName();

  private CatalogMediator mediator;

  public ProductDetailRouter(CatalogMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ProductItem getDataFromProductListScreen() {
    ProductItem product = mediator.getProduct();
    return product;
  }
}
