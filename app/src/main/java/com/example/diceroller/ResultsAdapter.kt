package com.example.diceroller

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ResultsAdapter(context: Context, private val results: List<String>) :
    ArrayAdapter<String>(context, 0, results) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        val resultTextView: TextView = view.findViewById(android.R.id.text1)
        resultTextView.text = results[position]
        return view
    }
}
