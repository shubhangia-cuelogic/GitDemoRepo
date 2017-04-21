package com.example.cuelogic.myapplication.Avtivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.R.menu
import android.app.ProgressDialog
import android.util.Log
import android.view.MenuInflater
import android.widget.ProgressBar
import com.example.cuelogic.myapplication.Adapter.DashboardAdapter
import com.example.cuelogic.myapplication.DataProvider.Product
import com.example.cuelogic.myapplication.UI.DashboardActivityUI
import com.example.cuelogic.myapplication.R
import com.example.cuelogic.myapplication.DataProvider.User
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL


class DashboardActivity : AppCompatActivity() {
    lateinit var AddAccount: Menu
    lateinit var user: User
    lateinit var dashBoardUI: DashboardActivityUI
    lateinit var progressDialog: ProgressDialog
    var productList: MutableList<Product> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashBoardUI = DashboardActivityUI()
        dashBoardUI.setContentView(this)

        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Loading...")
        progressDialog.show()
        doAsync {

            val result = URL("https://mobiletest-hackathon.herokuapp.com/getdata/").readText()
            Log.d("Request", result)
            uiThread {

                val jResults = JSONObject(result)
                val arrJson = jResults.getJSONArray("products")

                for (i in 0..arrJson.length() - 1) {
                    val obj = arrJson.getJSONObject(i)
                    val bean: Product = Product()

                    bean.productPrice = obj.getString("price")
                    bean.productName = obj.getString("productname")
                    bean.productImg = obj.getString("productImg")
                    bean.vendorName = obj.getString("vendorname")
                    bean.vendorAddress = obj.getString("vendoraddress")

                    productList.add(bean)
                    progressDialog.dismiss()
                }
                dashBoardUI.rcList.adapter = DashboardAdapter(productList)
                dashBoardUI.rcList.adapter.notifyDataSetChanged()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.add_account, menu)
        return super.onCreateOptionsMenu(menu)
    }


}
