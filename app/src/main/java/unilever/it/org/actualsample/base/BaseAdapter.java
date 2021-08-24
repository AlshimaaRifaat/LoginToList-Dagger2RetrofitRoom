package unilever.it.org.actualsample.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public  abstract class BaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    protected Context mContext;
    protected List<T> mlstAdapter;

    public BaseAdapter(Context objView) {
        mContext = objView;
        mlstAdapter = new ArrayList<T>();
    }

    protected abstract BaseViewHolder getHolderInstance(View view);

    protected abstract int getHolderResourceId();

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // LayoutInflater inflater = LayoutInflater.from(mContext);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(getHolderResourceId(), parent, false);
        return getHolderInstance(view);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        T obj = mlstAdapter.get(position);
        holder.bindData(obj);
    }

    public void add(List<T> items) {
        int previousDataSize = this.mlstAdapter.size();
        this.mlstAdapter.addAll(items);
        notifyItemRangeInserted(previousDataSize, items.size());
    }


    @Override
    public int getItemCount() {
        return this.mlstAdapter.size();
    }

    public List<T> getAdapter() {
        return this.mlstAdapter;
    }

    public void setAdapter(List<T> mlstAdapter) {
        this.mlstAdapter = mlstAdapter;
        this.notifyDataSetChanged();
    }


    public void delete(int position) {
        this.mlstAdapter.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mlstAdapter.size());
    }

}
