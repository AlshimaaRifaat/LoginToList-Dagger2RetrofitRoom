package unilever.it.org.actualsample.DAOs;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Observable;
import unilever.it.org.actualsample.base.ServiceWrapper;
import unilever.it.org.actualsample.database.Product;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM Product where title = :title")
    List<Product> searchByTitle(String title);

    @Query("SELECT * FROM Product")
   List<Product> findAll();



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Product product);

  /*  @Delete
    int  delete(Product product);*/

    @Query("DELETE FROM Product")
    public void deleteAll();
}
