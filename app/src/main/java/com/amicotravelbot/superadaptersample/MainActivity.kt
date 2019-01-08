package com.amicotravelbot.superadaptersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.amicotravelbot.superadapter.SuperAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.text_item.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showListOfNames()
    }

    /**
     * Show a list of names created using a SuperAdapter
     */
    private fun showListOfNames(){

        val listOfNames = arrayListOf(
            "Mark",
            "Emily",
            "John",
            "Frankie",
            "Alex",
            "Taylor"
        )

        val adapter = SuperAdapter.create(
            listOfNames,                                        //items in recyclerView
            R.layout.text_item,                                 //layout to inflate
            object : SuperAdapter.OnViewLoadedListener {        //listener used to bind item to view and to listen to click
                override fun onViewClicked(itemView: View, any: Any) {
                    val selectedName = any as String
                    Toast.makeText(this@MainActivity, selectedName, Toast.LENGTH_LONG).show()
                }

                override fun onViewLoaded(itemView: View, any: Any) {
                    val name = any as String
                    itemView.text1.text = name
                }
            }
        )

        list_of_items.layoutManager = LinearLayoutManager(this)
        list_of_items.adapter = adapter

    }
}
