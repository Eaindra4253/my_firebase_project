package com.example.firebasecrud

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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

            val patientRecord = Record(edtPatientName, edtPatientAge, edtPatientAddress)
            databaseRef = database.reference
            databaseRef = database.getReference("/Record/Data/Patient/")
            databaseRef.setValue(patientRecord)


            edt_patient_name.setText("")
            edt_patient_age.setText("")
            edt_patient_address.setText("")
        }

        btn_retrieve.setOnClickListener {
            // Read from the database
            databaseRef.addValueEventListener(object : ValueEventListener {

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val value = dataSnapshot.getValue(Record::class.java)
                    val patientName = value?.name
                    val patientAge = value?.age
                    val patientAddress = value?.address
                    edt_patient_name.setText(patientName)
                    edt_patient_age.setText(patientAge)
                    edt_patient_address.setText(patientAddress)
                }

                override fun onCancelled(error: DatabaseError) {
                    // Failed to read value
                    Log.w("TAG", "Failed to read value.", error.toException())
                }
            })
        }

    }
}