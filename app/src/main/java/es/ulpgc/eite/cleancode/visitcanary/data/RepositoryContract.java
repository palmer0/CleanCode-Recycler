package es.ulpgc.eite.cleancode.visitcanary.data;

import java.util.List;

public interface RepositoryContract {

  interface FetchCatalogDataCallback {
    void onCatalogDataFetched(boolean error);
  }

  interface GetProductListCallback {
    void setProductList(List<ProductItem> products);
  }

  interface GetProductCallback {
    void setProduct(ProductItem product);
  }

  interface GetCategoryListCallback {
    void setCategoryList(List<CategoryItem> categories);
  }

  interface GetCategoryCallback {
    void setCategory(CategoryItem category);
  }


  void loadCatalog(CatalogRepository.FetchCatalogDataCallback callback);

  void getProductList(
      CategoryItem category, CatalogRepository.GetProductListCallback callback);

  void getProductList(
      int categoryId, CatalogRepository.GetProductListCallback callback);

  void getProduct(int id, CatalogRepository.GetProductCallback callback);
  void getCategory(int id, CatalogRepository.GetCategoryCallback callback);
  void getCategoryList(CatalogRepository.GetCategoryListCallback callback);

}
