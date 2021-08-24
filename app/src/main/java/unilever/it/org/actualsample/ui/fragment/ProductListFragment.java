package unilever.it.org.actualsample.ui.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import unilever.it.org.actualsample.R;
import unilever.it.org.actualsample.base.BaseFragment;
import unilever.it.org.actualsample.database.DataHolderDTO;
import unilever.it.org.actualsample.database.Product;
import unilever.it.org.actualsample.ui.adapter.ProductListAdapter;
import unilever.it.org.actualsample.viewmodel.ProductListViewModel;


public class ProductListFragment extends BaseFragment {


    public ProductListViewModel mViewModel;
    RecyclerView rvProducts;
    ProductListAdapter itemsAdapter;

    EditText etSearch;
    String referenceKey;
    public ProductListFragment() {
        // Required empty public constructor
    }


    public static ProductListFragment newInstance() {
        ProductListFragment fragment = new ProductListFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void OnCreateViewJob(View view) {
        super.OnCreateViewJob(view);
        rvProducts = view.findViewById(R.id.rvProducts);
        etSearch = view.findViewById(R.id.etSearch);
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(ProductListViewModel.class);
       getProductList();

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged( Editable text) {
                referenceKey = text.toString();
                if(referenceKey.isEmpty()){
                    getProductList();
                }else {
                    getSearchResultList(referenceKey);
                }

            }
        });


    }

    private void getSearchResultList(String title) {
        Observer productSearchObserver = new Observer<DataHolderDTO<Product>>() {
            @Override
            public void onChanged(@Nullable DataHolderDTO<Product> data) {

                Toast.makeText(mContext,"size: "+ data.getDataList().size(), Toast.LENGTH_SHORT).show();

                rvProducts.setLayoutManager(new LinearLayoutManager(mContext));
                itemsAdapter = new ProductListAdapter(mContext);
                itemsAdapter.setAdapter(data.getDataList());
                rvProducts.setAdapter(itemsAdapter);

            }
        };
        mViewModel.searchList().observe(getViewLifecycleOwner(), productSearchObserver);
        mViewModel.getSearchResultList(title);
    }

    private void getProductList() {
        Observer productsObserver = new Observer<DataHolderDTO<Product>>() {
            @Override
            public void onChanged(@Nullable DataHolderDTO<Product> data) {

                Toast.makeText(mContext,"size: "+ data.getDataList().size(), Toast.LENGTH_SHORT).show();

                rvProducts.setLayoutManager(new LinearLayoutManager(mContext));
                itemsAdapter = new ProductListAdapter(mContext);
                itemsAdapter.setAdapter(data.getDataList());
                rvProducts.setAdapter(itemsAdapter);
                itemsAdapter.notifyDataSetChanged();
            }
        };
        mViewModel.getList().observe(getViewLifecycleOwner(), productsObserver);
        mViewModel.getProductList();


    }

    @Override
    protected int setProperFragmentView() {
        return R.layout.fragment_list;
    }



    private void getList() {
       /* productRepository.findAll().observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> products) {
                Toast.makeText(mContext, String.format("Product size: %s",products.get(0).getTitle()+ products.size()), Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}