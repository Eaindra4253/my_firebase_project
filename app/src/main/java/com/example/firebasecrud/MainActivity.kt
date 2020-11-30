package com.example.firebasecrud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = FirebaseDatabase.getInstance()

        var databaseRef = database.reference


        btn_register.setOnClickListener {

            val edtPatientName = edt_patient_name.text.toString()
            val edtPatientAge = edt_patient_age.text.toString()
            val edtPatientAddress = edt_patient_address.text.toString()

            databaseRef.child("Record").child("Data").child("Patient").child("Name")
                .setValue(edtPatientName)
            databaseRef.child("Record").child("Data").child("Patient").child("Age")
                .setValue(edtPatientAge)
            databaseRef.child("Record").child("Data").child("Patient").child("Address")
                .setValue(edtPatientAddress)

        }

    }
}