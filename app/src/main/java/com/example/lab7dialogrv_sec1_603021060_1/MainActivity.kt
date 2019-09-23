package com.example.lab7dialogrv_sec1_603021060_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_dialog_layout.view.*
import layout.Student
import layout.StudentsAdapter

class MainActivity : AppCompatActivity() {
    val studentList = arrayListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testStudentData()
        recycler_view.adapter = StudentsAdapter(this.studentList,applicationContext)
        recycler_view.layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.itemAnimator = DefaultItemAnimator()
    }

    fun addStudent(v: View) {

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_dialog_layout, null)
        val mBuilder = AlertDialog.Builder(this)
        mBuilder.setView(mDialogView)
        val mAlertDialog = mBuilder.show()

        mDialogView.btnAdd.setOnClickListener{
            studentList.add( Student( mDialogView.edit_id.text.toString(), mDialogView.edit_name.text.toString(),
                mDialogView.edit_age.text.toString().toInt()))
            recycler_view.adapter?.notifyDataSetChanged()
            Toast.makeText(applicationContext, "The student is added successfully", Toast.LENGTH_SHORT).show()
            mAlertDialog.dismiss()
        }
        mDialogView.btnCancel.setOnClickListener(){
            mAlertDialog.dismiss()
        }
    }
    fun testStudentData(){
        studentList.add(Student("601234567-8", "Student 1", 20))
        studentList.add(Student("601234567-8", "Student 2", 21))
    }
}
