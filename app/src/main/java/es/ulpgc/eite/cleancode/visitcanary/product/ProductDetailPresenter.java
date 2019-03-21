package es.ulpgc.eite.cleancode.visitcanary.product;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.visitcanary.data.ProductItem;


public class ProductDetailPresenter implements ProductDetailContract.Presenter {

  public static String TAG = ProductDetailPresenter.class.getSimpleName();

  private WeakReference<ProductDetailContract.View> view;
  private ProductDetailViewModel viewModel;
  private ProductDetailContract.Model model;
  private ProductDetailContract.Router router;

  public ProductDetailPresenter(ProductDetailState state) {
    viewModel = state;
  }


  @Override
  public void injectView(WeakReference<ProductDetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ProductDetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(ProductDetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchProductDetailData() {
    // Log.e(TAG, "fetchProductDetailData()");

    // set passed state
    ProductItem product = router.getDataFromProductListScreen();
    if(product != null) {
        viewModel.product = product;
    }
    view.get().displayProductDetailData(viewModel);

  }


}
