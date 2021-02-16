package es.ulpgc.eite.cleancode.visitcanary.categories;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;

interface CategoryListContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCategoryListData(CategoryListViewModel viewModel);

    void navigateToProductListScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchCategoryListData();
    void selectCategoryListData(CategoryItem item);
  }

  interface Model {
    void fetchCategoryListData(
        RepositoryContract.GetCategoryListCallback callback);
  }


//  interface Router {
//
//    void navigateToProductListScreen();
//    void passDataToProductListScreen(CategoryItem item);
//  }

}