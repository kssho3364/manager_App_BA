package com.example.manager_app_ba

import android.app.ActivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.manager_app_ba.databinding.ActivityMainBinding
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val mDatabase = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mDatabase.child("User").child("admin").child("ID").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var nameList =""
                for (dataSnapshot : DataSnapshot in snapshot.children){
                    Log.d("is work?",dataSnapshot.getValue().toString())
                    nameList = nameList+dataSnapshot.getValue().toString()
                }
                binding.newText.setText(nameList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })





    }
}