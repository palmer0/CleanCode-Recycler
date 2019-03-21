package es.ulpgc.eite.cleancode.visitcanary.categories;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import es.ulpgc.eite.cleancode.visitcanary.R;
import es.ulpgc.eite.cleancode.visitcanary.data.CategoryItem;


public class CategoryListActivity
    extends AppCompatActivity implements CategoryListContract.View {

  public static String TAG = CategoryListActivity.class.getSimpleName();

  CategoryListContract.Presenter presenter;

  private CategoryListAdapter listAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_category_list);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle(R.string.app_name);
    }

    listAdapter = new CategoryListAdapter(new View.OnClickListener() {

      @Override
      public void onClick(View view) {
        CategoryItem item = (CategoryItem) view.getTag();
        presenter.selectCategoryListData(item);
      }
    });

    RecyclerView recyclerView = findViewById(R.id.category_list);
    recyclerView.setAdapter(listAdapter);

    // do the setup
    CategoryListScreen.configure(this);

    // do some work
    presenter.fetchCategoryListData();
  }

  @Override
  public void displayCategoryListData(final CategoryListViewModel viewModel) {
    Log.e(TAG, "displayCategoryListData()");

    runOnUiThread(new Runnable() {

      @Override
      public void run() {

        // deal with the data
        listAdapter.setItems(viewModel.categories);
      }

    });

  }


  @Override
  public void injectPresenter(CategoryListContract.Presenter presenter) {
    this.presenter = presenter;
  }

}
