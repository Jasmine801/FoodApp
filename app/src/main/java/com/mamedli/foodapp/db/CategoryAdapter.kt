package com.mamedli.foodapp.db

import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mamedli.foodapp.R
import com.mamedli.foodapp.databinding.CategoryItemBinding
import com.mamedli.foodapp.entities.CategoryItem
import com.mamedli.foodapp.entities.CategoryList
import com.squareup.picasso.Picasso


class CategoryAdapter(private var categoryList: CategoryList) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = CategoryItemBinding.bind(view)

        fun setData(categoryItem: CategoryList) = with(binding){
            tvCtegoryName.text = categoryItem.name
            if(!categoryItem.imageUrl.isNullOrEmpty()){
                Picasso.get().load(categoryItem.imageUrl).into(imFood)
            }
            /*else {
                Picasso.get().load(categoryItem.imageUrl).into(imFood)
            }*/
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categoryList
        holder.setData(category)
    }

    override fun getItemCount() =  1


     fun setData(categoryList: CategoryList){
        this.categoryList = categoryList
        notifyDataSetChanged()
    }
}