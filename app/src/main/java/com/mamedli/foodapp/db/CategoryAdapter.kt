package com.mamedli.foodapp.db

import android.graphics.drawable.BitmapDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mamedli.foodapp.R
import com.mamedli.foodapp.databinding.CategoryItemBinding
import com.mamedli.foodapp.entities.CategoryItem
import com.squareup.picasso.Picasso


class CategoryAdapter(private val categoryList: MutableList<CategoryItem>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val binding = CategoryItemBinding.bind(view)

        fun setData(categoryItem: CategoryItem?) = with(binding){
            tvCtegoryName.text = categoryItem?.name
            Picasso.get().load(categoryItem?.imageUrl).into(imFood)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(categoryList[position])
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }
}