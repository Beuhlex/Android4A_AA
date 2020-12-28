package com.example.android4a_aurelienandrieux.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a_aurelienandrieux.R

class ListAdapter // Provide a suitable constructor (depends on the kind of dataset)
(private val values: List<String>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {
        // each data item is just a string in this case
        var txtHeader: TextView
        var txtFooter: TextView

        init {
            txtHeader = layout.findViewById<View>(R.id.firstLine) as TextView
            txtFooter = layout.findViewById<View>(R.id.secondLine) as TextView
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(
                parent.context)
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val name = values[position]
        holder.txtHeader.text = name
        holder.txtFooter.text = "Footer: $name"
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }

}