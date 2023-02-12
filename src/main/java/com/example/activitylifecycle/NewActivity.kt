package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class NewActivity : AppCompatActivity() /*View.OnClickListener*/{
    /*override fun onClick(p0: View?) {
        Toast.makeText(
            this@NewActivity,
            "hello u cliclked on toast",
            Toast.LENGTH_SHORT
        ).show()
    }*/
    lateinit var sharedPreferences: SharedPreferences
    lateinit var fav : EditText
    lateinit var pas : EditText
    lateinit var btn1 : Button
    lateinit var gfp  : TextView
    lateinit var reg  : TextView
    val  favchar = "naruto"
    val passcode = arrayOf("9","8","4","1")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences= getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isloggedIn = sharedPreferences.getBoolean("isloggedIn",false)
        setContentView(R.layout.activity_new)
        if(isloggedIn){
            val intent = Intent(this@NewActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            /*setContentView(R.layout.activity_new)*/

        }

        title = "LOGIN"

        fav = findViewById(R.id.fav)
        pas = findViewById(R.id.pas)
        btn1 = findViewById(/* id = */ R.id.btn1)
        gfp = findViewById(R.id.gfp)
        reg = findViewById(R.id.reg)




        btn1.setOnClickListener {
            /*Toast.makeText(
                this@NewActivity,
                "hello u cliclked on toast",
                Toast.LENGTH_SHORT
            ).show()*/
            val favourite = fav.text.toString()
            val pass =pas.text.toString()
            var postofpeople="SANJANAFAMILY"
            val intent = Intent(this@NewActivity, MainActivity::class.java)
            if(favourite==favchar) {
                if(pass==passcode[0]){
                    postofpeople="FAMILY<3"
                    savePreferences(postofpeople)

            /*we use class.java as there are some dependencies there*/


            startActivity(intent)
            }}
            else{
                Toast.makeText(
                    this@NewActivity,
                    "Mother fucker",
                    Toast.LENGTH_SHORT
                ).show()

            }

        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title: String)
    {
        sharedPreferences.edit().putBoolean("isloggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()

    }

}