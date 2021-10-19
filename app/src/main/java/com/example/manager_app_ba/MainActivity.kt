package com.example.manager_app_ba

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

        mDatabase.child("User").addListenerForSingleValueEvent(object : ValueEventListener{
            var str = ""
            override fun onDataChange(snapshot: DataSnapshot) {
                for(dataSnapshot : DataSnapshot in snapshot.children){
                    str += dataSnapshot.key
                }
                binding.newText.setText(str)
                Log.d("str",str)
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}