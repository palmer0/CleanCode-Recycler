package es.ulpgc.eite.cleancode.visitcanary.categories;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.visitcanary.app.CatalogMediator;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;
import es.ulpgc.eite.cleancode.visitcanary.data.RepositoryContract;


public class CategoryListPresenter implements CategoryListContract.Presenter {

  public static String TAG = CategoryListPresenter.class.getSimpleName();

  private WeakReference<CategoryListContract.View> view;
  private CategoryListState state;
  private CategoryListContract.Model model;
  //private CategoryListContract.Router router;
  private CatalogMediator mediator;


  public CategoryListPresenter(CatalogMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCategoryListState();
  }

//  public CategoryListPresenter(CategoryListState state) {
//    this.state = state;
//  }

  @Override
  public void fetchCategoryListData() {
    // Log.e(TAG, "fetchCategoryListData()");

    // call the model
    model.fetchCategoryListData(new RepositoryContract.GetCategoryListCallback() {

      @Override
      public void setCategoryList(List<CategoryItem> categories) {
        state.categories = categories;

        view.get().displayCategoryListData(state);
      }
    });

  }

  private void passDataToProductListScreen(CategoryItem item) {
    mediator.setCategory(item);
  }

  @Override
  public void selectCategoryListData(CategoryItem item) {
    //router.passDataToProductListScreen(item);
    passDataToProductListScreen(item);
    //router.navigateToProductListScreen();
    view.get().navigateToProductListScreen();
  }


  @Override
  public void injectView(WeakReference<CategoryListContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CategoryListContract.Model model) {
    this.model = model;
  }

//  @Override
//  public void injectRouter(CategoryListContract.Router router) {
//    this.router = router;
//  }
}
