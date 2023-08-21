package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemStudentBinding
import com.example.myapplication.helper.toImage
import com.example.myapplication.model.Student

class StudentAdapter(var list : List<Student>) : RecyclerView.Adapter<StudentAdapter.StudentHolder>() {
    inner  class  StudentHolder (var binding: ItemStudentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentHolder {
       return StudentHolder(ItemStudentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: StudentHolder, position: Int) {
      var student = list.get(position)
        student.apply {
            holder.binding.apply {
                txtFullName.text = "${student.FirstName} ${student.LastName}"
                imageView.setImageBitmap(student.Photo.toImage())
            }
        }
    }
}