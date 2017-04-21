package com.example.cuelogic.myapplication.Avtivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.jetbrains.anko.*
import android.content.Intent
import com.example.cuelogic.myapplication.UI.MainActivityUI

class MainActivity : AppCompatActivity() {


    lateinit var mainUI: MainActivityUI
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainUI = MainActivityUI()
        mainUI.setContentView(this)
        SetListner()
    }

    private fun SetListner() {
        var b: String? = ""
        b=null

        mainUI.btnLogin.setOnClickListener(View.OnClickListener {
            if (mainUI.edUsername.text.toString().equals("Shubhangi") && mainUI.edPassword.text.toString().equals("Shubhangi")) {
                mainUI.lblLoginMsg.text = "Successfully loged in"
                // mainUI.lblLoginMsg.text=b.toString();
//                if (b != null) {
                    print(b?.length);
                //}
                val intent = Intent(this, DashboardActivity::class.java)
                startActivity(intent)
            }
        })
    }


}

