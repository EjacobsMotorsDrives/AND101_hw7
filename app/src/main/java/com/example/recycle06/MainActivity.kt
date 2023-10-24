package com.example.recycle06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers

class MainActivity : AppCompatActivity() {
    private lateinit var pokeListImage: MutableList<String>
    private lateinit var pokeListForm: MutableList<String>
    private lateinit var pokeListAbil: MutableList<String>
    private lateinit var rvPoke: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPoke = findViewById(R.id.poke_list)
        pokeListImage = mutableListOf()
        pokeListForm = mutableListOf()
        pokeListAbil = mutableListOf()



        getPokeImageURL()

    }

    private fun getPokeImageURL() {
        val client = AsyncHttpClient()

        client[" https://pokeapi.co/api/v2/pokemon/charizard", object : JsonHttpResponseHandler() {
            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JsonHttpResponseHandler.JSON
            ) {
                Log.d("Poke Success", "$json")
                //entry 1

                pokeListImage.add(
                    (json.jsonObject.getJSONObject("sprites").get("back_default")).toString()
                )

                pokeListAbil.add( //"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(0)).getString("base_stat")
                        .toString()
                )
                pokeListForm.add( //"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(0).getJSONObject("stat").getString("name")).toString()
                )

                //entry 2
                pokeListImage.add(
                    (json.jsonObject.getJSONObject("sprites").get("back_shiny")).toString()
                )
                pokeListAbil.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(1)).getString("base_stat")
                    .toString()
                )
                pokeListForm.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(1).getJSONObject("stat").getString("name")).toString()
                )

                //entry 3
                pokeListImage.add(
                    (json.jsonObject.getJSONObject("sprites").get("front_default")).toString()
                )
                pokeListAbil.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(2)).getString("base_stat")
                    .toString()
                )
                pokeListForm.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(2).getJSONObject("stat").getString("name")).toString()
                )

                //entry 4
                pokeListImage.add(
                    (json.jsonObject.getJSONObject("sprites").get("front_shiny")).toString()
                )
                pokeListAbil.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(3)).getString("base_stat")
                        .toString()
                )
                pokeListForm.add(//"fat"
                    (json.jsonObject.getJSONArray("stats").getJSONObject(3).getJSONObject("stat").getString("name")).toString()
                )

                val adapter = Adapter_Poke(pokeListImage,pokeListForm,pokeListAbil)
                rvPoke.adapter = adapter
                rvPoke.layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }]



}
}