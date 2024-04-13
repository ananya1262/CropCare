package com.learning.cropcare.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.learning.cropcare.R

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        var mAuth=FirebaseAuth.getInstance().currentUser
        Handler().postDelayed({
            if(mAuth!=null )
            {
                if(mAuth.email!=null && mAuth.email.toString().length>0)
                {
                    if(mAuth.isEmailVerified)
                    {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                    else
                    {
                        startActivity(Intent(this, SignInActivity::class.java))
                        finish()
                    }
                }
                else
                {
                    if(mAuth.phoneNumber!=null)
                    {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                }
            }
            else
            {
                startActivity(Intent(this, LanguageActivity::class.java))
                finish()

            }
        },3000)
    }
}