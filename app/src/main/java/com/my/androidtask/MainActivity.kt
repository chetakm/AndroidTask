package com.my.androidtask


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var imageView:ImageView
    lateinit var adapter: NewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getData()


    }
   override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_item, menu)
        return true
    }

    private fun getData() {
        val data=DataService.datainstance.getData()
        data.enqueue(object :Callback<List<Info>>{
            override fun onResponse(call: Call<List<Info>>, response: Response<List<Info>>) {
                val ndata=response.body()
                if (ndata!=null) {
                    adapter = NewAdapter(this@MainActivity,ndata)
                    recyclerView.adapter=adapter
                    recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<List<Info>>, t: Throwable) {
                Log.d("New","Faileds")
            }

        })
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun Start(view: android.view.View) {
        Toast.makeText(applicationContext,"Started",Toast.LENGTH_SHORT).show()
        textView2.maxHeight=200
    }


}