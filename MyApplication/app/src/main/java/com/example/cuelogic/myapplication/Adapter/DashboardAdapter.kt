package com.example.cuelogic.myapplication.Adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.*
import android.view.*
import org.jetbrains.anko.*
import android.widget.*
import com.example.cuelogic.myapplication.DataProvider.*
import com.squareup.picasso.Picasso


/**
 * Created by cuelogic on 06/04/17.
 */
class DashboardAdapter(var productList: List<Product>) : RecyclerView.Adapter<LaunchMenuItemViewHolder>() {
    lateinit var contex: Context
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): LaunchMenuItemViewHolder? {

        return LaunchMenuItemViewHolder(LunchMenuItemUI().createView(AnkoContext.Companion.create(parent!!.context, parent)))
    }

    override fun onBindViewHolder(holder: LaunchMenuItemViewHolder?, position: Int) {
        var product: Product = productList[position]
        holder?.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

class LunchMenuItemUI : AnkoComponent<ViewGroup> {

    lateinit var txtProductName: TextView
    lateinit var txtProductPrice: TextView
    lateinit var txtVendorName: TextView
    lateinit var txtVendorAddress: TextView
    lateinit var imgProduct: ImageView
    override fun createView(ui: AnkoContext<ViewGroup>) = ui.apply {
        verticalLayout {
            padding = dip(18)
            imgProduct = imageView {
                id = 3
            }.lparams {
                width = wrapContent
                height = wrapContent
                gravity = Gravity.CENTER
            }
            txtProductName = textView() {
                id = 1
                textSize = 24f
                textColor = Color.BLACK
            }.lparams {
                width = wrapContent
                height = wrapContent
                gravity = Gravity.CENTER
            }
            txtProductPrice = textView() {
                id = 2
                textSize = 18f
            }.lparams {
                width = wrapContent
                height = wrapContent
                gravity = Gravity.CENTER
            }
            txtVendorName = textView() {
                id = 4
                textSize = 18f
            }.lparams {
                width = wrapContent
                height = wrapContent
                gravity = Gravity.CENTER
            }
            txtVendorAddress = textView() {
                id = 5
                textSize = 18f
            }.lparams {
                width = wrapContent
                height = wrapContent
                gravity = Gravity.CENTER
            }
        }

    }.view
}


class LaunchMenuItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.find(1)
    val price: TextView = itemView.find(2)
    val image: ImageView = itemView.find(3)
    val vendorName: TextView = itemView.find(4)
    val vendorAddress: TextView = itemView.find(5)
    fun bind(product: Product) {

        name.text = product.productName
        price.text = product.productPrice
        vendorName.text = product.vendorName
        vendorAddress.text = product.vendorAddress
        Picasso.with(itemView.context)
                .load(product?.productImg)
                .into(image)


    }
}
