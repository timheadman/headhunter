package ru.megaland.headhunter.presentation.ui.candidate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.megaland.headhunter.R
import ru.megaland.headhunter.domain.model.candidate.Education

class CandidateEducationRecyclerViewAdapter(
    private val list: List<Education>
) : RecyclerView.Adapter<CandidateEducationRecyclerViewAdapter.EducationViewHolder>() {

    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
        val yearStartTextView: TextView = itemView.findViewById(R.id.yearStartTextView)
        val yearEndTextView: TextView = itemView.findViewById(R.id.yearEndTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_candidate_education, parent, false)
        return EducationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val item = list[position]
        holder.typeTextView.text = item.type
        holder.yearStartTextView.text = item.yearStart.toString()
        holder.yearEndTextView.text = item.yearEnd.toString()
        holder.descriptionTextView.text = item.description
    }

}