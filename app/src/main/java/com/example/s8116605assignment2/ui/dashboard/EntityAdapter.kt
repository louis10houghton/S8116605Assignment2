package com.example.s8116605assignment2.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.s8116605assignment2.R
import com.example.s8116605assignment2.network.model.Entity

class EntityAdapter(
    private var entities: List<Entity>,
    private val onClick: (Entity) -> Unit
) : RecyclerView.Adapter<EntityViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        holder.bind(entities[position], onClick)
    }

    override fun getItemCount() = entities.size

    fun submitList(newEntities: List<Entity>) {
        entities = newEntities
        notifyDataSetChanged()
    }
}