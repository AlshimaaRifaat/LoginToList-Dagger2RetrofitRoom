package unilever.it.org.actualsample.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
   // Button btnGetList;
    private List<Product> productList;
    RecyclerView rvProducts;
    ProductListAdapter itemsAdapter;
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


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //btnGetList=view.findViewById(R.id.btnGetList);



        /*Product product=new Product(22,"tttt","des");
        long count=productRepository.insert(product);

        Toast.makeText(mContext, "count: "+count, Toast.LENGTH_SHORT).show();

*/
       /* btnGetList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mViewModel.getProductList();
            }
        });*/
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(ProductListViewModel.class);
        getProductList();


    }

    private void getProductList() {
        Observer productsObserver = new Observer<DataHolderDTO<Product>>() {
            @Override
            public void onChanged(@Nullable DataHolderDTO<Product> data) {
              /*  if (data != null ) {
                    productList = data.getDataList();
                } else {
                    productList = new ArrayList<>();
                }*/
                Toast.makeText(mContext,"size: "+ data.getDataList().size(), Toast.LENGTH_SHORT).show();
              /*  mViewModel.getList().removeObserver(this);
                mViewModel.removeTransactions();*/
                rvProducts.setLayoutManager(new LinearLayoutManager(mContext));
                itemsAdapter = new ProductListAdapter(mContext);
                itemsAdapter.setAdapter(data.getDataList());
                rvProducts.setAdapter(itemsAdapter);
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