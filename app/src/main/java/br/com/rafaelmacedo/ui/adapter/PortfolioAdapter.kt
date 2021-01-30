package br.com.rafaelmacedo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rafaelmacedo.R

class PortfolioAdapter(private val investmentsDescription: List<String>) :
    RecyclerView.Adapter<PortfolioAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_investment_adapter_item, parent, false)
    )

    override fun getItemCount(): Int = investmentsDescription.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(investmentsDescription[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(description: String) {
            (itemView as? TextView)?.text = description
        }
    }
}