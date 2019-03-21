package es.ulpgc.eite.cleancode.visitcanary.products;

import android.util.Log;

import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class ProductListModel implements ProductListContract.Model {

  public static String TAG = ProductListModel.class.getSimpleName();


  private RepositoryContract repository;

  public ProductListModel(RepositoryContract repository){
    this.repository = repository;
  }

  @Override
  public void fetchProductListData(
      CategoryItem category, RepositoryContract.GetProductListCallback callback) {

    Log.e(TAG, "fetchProductListData()");
    repository.getProductList(category, callback);
  }

}
