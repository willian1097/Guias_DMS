package com.example.guia09_dsm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guia09_dsm.databinding.ActivityMainBinding
import retrofit2.Retrofit
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.annotation.Nullable
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    var binding: ActivityMainBinding? = null
    var dogAdapter: DogAdapter? = null
    var images: MutableList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initRecyclerView()
        binding!!.searchDogs.setOnQueryTextListener(this as OnQueryTextListener)
    }

    private fun initRecyclerView() {
        dogAdapter = DogAdapter(images)
        binding!!.listDogs.layoutManager = LinearLayoutManager(this)
        binding!!.listDogs.adapter = dogAdapter
    }

    private val apiService: ApiService
        private get() {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/breed/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }

    private fun searchByName(raza: String) {
        val batch: Call<DogsResponse?>? = apiService.getDogsByBreed(raza)
        batch?.enqueue(object : Callback<DogsResponse?> {
            override fun onResponse(
                @Nullable call: Call<DogsResponse?>?,
                @Nullable response: Response<DogsResponse?>?
            ) {
                if (response != null && response.body() != null) {
                    val responseImages: List<String> = response.body()!!.getImages() as List<String>
                    images.clear()
                    images.addAll(responseImages)
                    dogAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(@Nullable call: Call<DogsResponse?>?, @Nullable t: Throwable?) {
                if (t != null) {
                    showError()
                }
            }
        })
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        if (!query.isEmpty()) {
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}