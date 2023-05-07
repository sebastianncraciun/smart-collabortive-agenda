package com.example.smartagenda.activities

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.smartagenda.R
import com.example.smartagenda.databinding.ActivityMyProfileBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.squareup.picasso.Picasso
import model.User
import utils.Constants


class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyProfileBinding

    private lateinit var googleSignInClient: GoogleSignInClient

    private lateinit var myUserDetails: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMyProfile)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "My Profile"
        binding.toolbarMyProfile.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
        binding.userInfo.text = intent.getStringExtra("name") + "\n" + intent.getStringExtra("email")
        Picasso.get()
            .load(intent.getStringExtra("photoUrl"))
            .into(binding.userImg)

        binding.btnLogout.setOnClickListener{
            signOut()
        }
    }

    private fun signOut() {
        googleSignInClient.signOut()
            .addOnCompleteListener(this) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
    }
}