package com.example.s8116605assignment2.ui.dashboard

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.s8116605assignment2.R
import com.example.s8116605assignment2.network.model.Entity

class EntityViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val technique: TextView = view.findViewById(R.id.itemTechnique)
    private val subject: TextView = view.findViewById(R.id.itemSubject)
    private val equipment: TextView = view.findViewById(R.id.itemEquipment)
    private val photographer: TextView = view.findViewById(R.id.itemPhotographer)
    private val year: TextView = view.findViewById(R.id.itemYear)

    fun bind(item: Entity, onClick: (Entity) -> Unit) {
        technique.text = item.technique
        subject.text = "Subject: ${item.subject}"
        equipment.text = "Equipment: ${item.equipment}"
        photographer.text = "Photographer: ${item.pioneeringPhotographer}"
        year.text = "Year: ${item.yearIntroduced}"
        itemView.setOnClickListener { onClick(item) }
    }
}