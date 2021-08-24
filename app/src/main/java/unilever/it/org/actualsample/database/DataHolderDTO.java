package unilever.it.org.actualsample.database;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import unilever.it.org.actualsample.base.DTO;
import unilever.it.org.actualsample.repository.list.DemoDatabase;

public class DataHolderDTO<T> extends DTO {

    @SerializedName("listData")
    @Expose
    private List<T> listData;

    public List<T> getDataList() {
        return listData;
    }

    public DataHolderDTO() {
    }

    public void setListData(List<T> listData) {
        this.listData = listData;
    }


 /*  @Override
    public void save(DatabaseHelper dbHelper) {

    }*/


}
