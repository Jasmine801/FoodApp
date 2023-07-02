package com.mamedli.foodapp.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mamedli.foodapp.R
import com.mamedli.foodapp.databinding.FragmentMainBinding
import com.mamedli.foodapp.db.CategoryAdapter
import com.mamedli.foodapp.db.CategoryApi
import com.mamedli.foodapp.db.RetrofitInstance
import com.mamedli.foodapp.entities.CategoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var categoryArrayList: ArrayList<CategoryItem>
    private lateinit var adapter: CategoryAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        binding.rcView.setHasFixedSize(true)

        val category = CategoryItem(0, "", "")
        adapter = CategoryAdapter(category)
        binding.rcView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/058729bd-1402-4578-88de-265481fd7d54/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val categoryService = retrofit.create(CategoryApi::class.java)

        categoryService.getCategories().enqueue(object : Callback<CategoryItem>
        {
            override fun onFailure(call: Call<CategoryItem>, t: Throwable) {
                Log.e("TAG", "Error fetching data", t)
            }

            override fun onResponse(call: Call<CategoryItem>, response: Response<CategoryItem>) {
                val categoryList = response.body()
                Log.d("TAG", "Data received: $categoryList")
                if(categoryList != null) {
                    adapter.setData(categoryList)
                }
            }
        }
        )
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}