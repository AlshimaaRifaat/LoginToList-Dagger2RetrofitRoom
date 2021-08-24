package unilever.it.org.actualsample.ui.adapter;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import unilever.it.org.actualsample.R;
import unilever.it.org.actualsample.base.BaseAdapter;
import unilever.it.org.actualsample.base.BaseViewHolder;
import unilever.it.org.actualsample.database.Product;

public class ProductListAdapter extends BaseAdapter<Product> {

    public ProductListAdapter(Context context) {
        super(context);
    }

    @Override
    protected BaseViewHolder getHolderInstance(View view) {
        return new ViewHolder(view);
    }

    @Override
    protected int getHolderResourceId() {
        return R.layout.item_product;
    }

    public static class ViewHolder extends BaseViewHolder<Product> {
        TextView tv_Title;
        TextView tv_desc;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_Title = itemView.findViewById(R.id.tv_title);
            tv_desc = itemView.findViewById(R.id.tv_desc);

        }

        @Override
        public void bindData(Product businessObject) {
            this.businessObject = businessObject;
            tv_Title.setText(businessObject.getTitle());
            tv_desc.setText(businessObject.getDescription());
        }

    }
}
