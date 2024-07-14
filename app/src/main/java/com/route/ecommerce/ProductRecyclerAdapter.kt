package com.route.ecommerce

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.route.domain.model.productItem
import com.route.ecommerce.databinding.ProductItemBinding

class ProductRecyclerAdapter (var list: MutableList<productItem?>?) :
    RecyclerView.Adapter<ProductRecyclerAdapter.ViewHolder>() {

    class ViewHolder(var itemBinding: ProductItemBinding) : RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    fun bindProductList(list: MutableList<productItem?>?) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.itemBinding.productName.text = list?.get(position)?.title.toString()
        holder.itemBinding.productDetails.text =list?.get(position)?.description.toString()
holder.itemBinding.prodRealPrice.text=list?.get(position)?.price.toString()
 val discountprice= ( list?.get(position)?.discountPercentage?.toInt())?.times((list?.get(position)?.price?.toInt()!!))
     ?.div(100.0)
        val thepriceafterdiscount= (list?.get(position)?.price?.toDouble())?.minus(discountprice?.toDouble()!!)
        holder.itemBinding.prodDiscountPrice.text=thepriceafterdiscount.toString()
holder.itemBinding.review.text="rating(${list?.get(position)?.rating.toString()})"
        list?.get(position)?.images?.get(0)?.let {
            Glide.with(holder.itemView)
                .load(it)
                .into(holder.itemBinding.productImage)
        }


    }
    fun binditem(productDto: productItem,position: Int){
        Log.e("list1", list.toString())
        list?.set(position, productDto)
        Log.e("list2", list.toString())
        notifyDataSetChanged()
    }

}