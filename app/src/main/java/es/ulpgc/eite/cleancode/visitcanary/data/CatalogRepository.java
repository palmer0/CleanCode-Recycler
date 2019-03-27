package es.ulpgc.eite.cleancode.visitcanary.data;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CatalogRepository implements RepositoryContract {

  public static String TAG = CatalogRepository.class.getSimpleName();


  public static final String JSON_FILE = "catalog.json";
  public static final String JSON_ROOT = "categories";

  private static CatalogRepository INSTANCE;

  private Context context;
  private List<CategoryItem> categories;

  public static RepositoryContract getInstance(Context context) {
    if(INSTANCE == null){
      INSTANCE = new CatalogRepository(context);
    }

    return INSTANCE;
  }

  private CatalogRepository(Context context) {
    this.context = context;
    //categories = new ArrayList();
  }

  @Override
  public void loadCatalog(final FetchCatalogDataCallback callback) {


    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {

        boolean error = !loadCatalogFromJSON(loadJSONFromAsset());

        if(callback != null) {
          callback.onCatalogDataFetched(error);
        }
      }
    });

  }

  @Override
  public void getProductList(
      final CategoryItem category, final GetProductListCallback callback) {

    getProductList(category.id, callback);
  }


  @Override
  public void getProductList(
      final int categoryId, final GetProductListCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {
          callback.setProductList(loadProducts(categoryId));
        }
      }
    });

  }



  @Override
  public void getProduct(final int id, final GetProductCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {
          callback.setProduct(loadProduct(id));
        }
      }
    });
  }



  @Override
  public void getCategory(final int id, final GetCategoryCallback callback) {

    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {
          callback.setCategory(loadCategory(id));
        }
      }


    });

  }



  @Override
  public void getCategoryList(final GetCategoryListCallback callback) {
    AsyncTask.execute(new Runnable() {

      @Override
      public void run() {
        if(callback != null) {
          callback.setCategoryList(loadCategories());
        }
      }
    });

  }



  private boolean loadCatalogFromJSON(String json) {
    Log.e(TAG, "loadCatalogFromJSON()");

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    try {

      JSONObject jsonObject = new JSONObject(json);
      JSONArray jsonArray = jsonObject.getJSONArray(JSON_ROOT);

      categories = new ArrayList();

      if (jsonArray.length() > 0) {

        final List<CategoryItem> categories = Arrays.asList(
            gson.fromJson(jsonArray.toString(), CategoryItem[].class)
        );


        for (CategoryItem category: categories) {
          insertCategory(category);
        }

        for (CategoryItem category: categories) {
          for (ProductItem product: category.items) {
            product.categoryId = category.id;

          }
        }

        return true;
      }

    } catch (JSONException error) {
      Log.e(TAG, "error: " + error);
    }

    return false;
  }



  private String loadJSONFromAsset() {
    //Log.e(TAG, "loadJSONFromAsset()");

    String json = null;

    try {

      InputStream is = context.getAssets().open(JSON_FILE);
      int size = is.available();
      byte[] buffer = new byte[size];
      is.read(buffer);
      is.close();
      json = new String(buffer, "UTF-8");

    } catch (IOException error) {
      Log.e(TAG, "error: " + error);
    }

    return json;
  }

  private List<ProductItem> loadProducts(int categoryId) {
    List<ProductItem> products = new ArrayList();

    for (CategoryItem category: categories) {
      if(category.id == categoryId) {
        products = category.items;
      }
    }

    return products;
  }


  private ProductItem loadProduct(int id) {
    for (CategoryItem category: categories) {
      for (ProductItem product: category.items) {
        if(product.id == id) {
          return product;
        }
      }
    }

    return null;
  }

  private CategoryItem loadCategory(int id) {
    for (CategoryItem category: categories) {
      if(category.id == id) {
        return category;
      }
    }

    return null;
  }

  private void insertCategory(CategoryItem category) {
    categories.add(category);
  }

  private List<CategoryItem> loadCategories() {
    return categories;
  }

}
