package devs.redfox.local_e_commerce.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product:ProductModel)

    @Delete
    suspend fun deleteProduct(product:ProductModel)

    @Query("SELECT * FROM products")
    fun getAllProducts():List<ProductModel>

    @Query("SELECT * FROM products WHERE productId = :id")
    fun isExit(id:String):ProductModel
}