package es.ulpgc.eite.cleancode.visitcanary.categories;

import android.util.Log;

import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

public class CategoryListModel implements CategoryListContract.Model {

  public static String TAG = CategoryListModel.class.getSimpleName();

  private RepositoryContract repository;

  public CategoryListModel(RepositoryContract repository) {
    this.repository = repository;

  }

  @Override
  public void fetchCategoryListData(
      final RepositoryContract.GetCategoryListCallback callback) {

    Log.e(TAG, "fetchCategoryListData()");

    repository.loadCatalog(new RepositoryContract.FetchCatalogDataCallback() {

      @Override
      public void onCatalogDataFetched(boolean error) {
        if(!error) {
          repository.getCategoryList(callback);
        }
      }
    });

  }

}
