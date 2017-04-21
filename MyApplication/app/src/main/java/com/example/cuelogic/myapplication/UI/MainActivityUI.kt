package com.example.cuelogic.myapplication.UI

import android.graphics.Color
import android.text.InputType
import android.util.Log
import android.view.Gravity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.*
import android.widget.*
import com.example.cuelogic.myapplication.Avtivity.MainActivity
import org.jetbrains.anko.custom.async
import java.net.URL
import java.net.URL.*

/**
 * Created by cuelogic on 05/04/17.
 */
class MainActivityUI : AnkoComponent<MainActivity> {
    lateinit var btnLogin: Button
    lateinit var edUsername: EditText
    lateinit var edPassword: EditText
    lateinit var lblLoginMsg: TextView
    override fun createView(ui: AnkoContext<MainActivity>) = ui.apply {


        verticalLayout {
            gravity = Gravity.CENTER
            padding = dip(18)
            edUsername = editText {
                hint = "Username"
                textSize = 24f
               // requestFocus()
            }
            edPassword = editText {
                hint = "Password"
                textSize = 24f
                inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD

            }
            btnLogin = button("Login") {
                textSize = 26f
                backgroundColor = Color.DKGRAY
                textColor = Color.WHITE
            }.lparams {
                width = matchParent
                height = wrapContent
                marginStart = dip(50)
                marginEnd = dip(50)
                topMargin = dip(10)
            }
            lblLoginMsg = textView() {
                textSize = 24f
            }.lparams {
                gravity=Gravity.CENTER
                padding=dip(10)
            }
        }

    }.view
}
