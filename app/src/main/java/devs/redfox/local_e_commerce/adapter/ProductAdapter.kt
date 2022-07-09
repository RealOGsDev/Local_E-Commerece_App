package devs.redfox.local_e_commerce.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import devs.redfox.local_e_commerce.databinding.CategoryItemBinding
import devs.redfox.local_e_commerce.databinding.ProductItemBinding
import devs.redfox.local_e_commerce.model.AddProductModel
import kotlin.math.log

class ProductAdapter(val context:Context, val list : ArrayList<AddProductModel>)
    :RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

       class ProductViewHolder(val binding: ProductItemBinding, val context: Context):
    RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(layoutInflater, parent, false)
        return ProductViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = list[position]

        Glide.with(context).load(data.productCoverImg).into(holder.binding.imageView)
        holder.binding.textView2.text = data.productName
        holder.binding.textView3.text = data.productCategory
        holder.binding.textView4.text = data.productMrp

        holder.binding.button.text = data.productSp
    }

    override fun getItemCount(): Int {
        return list.size
    }

}