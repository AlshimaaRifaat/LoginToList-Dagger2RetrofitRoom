package unilever.it.org.actualsample.base;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    protected T businessObject ;

    public abstract void bindData(T businessObject) ;

    public BaseViewHolder(View itemView) {
        super(itemView);
    }
}
