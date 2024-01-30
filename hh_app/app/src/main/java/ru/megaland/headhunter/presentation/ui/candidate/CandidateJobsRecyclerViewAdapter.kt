package ru.megaland.headhunter.presentation.ui.candidate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.megaland.headhunter.R
import ru.megaland.headhunter.domain.model.candidate.JobExperience

class CandidateJobsRecyclerViewAdapter(
    private val list: List<JobExperience>
) : RecyclerView.Adapter<CandidateJobsRecyclerViewAdapter.JobsViewHolder>() {

    class JobsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val companyNameTextView: TextView = itemView.findViewById(R.id.companyNameTextView)
        val dateStartTextView: TextView = itemView.findViewById(R.id.dateStartTextView)
        val dateEndTextView: TextView = itemView.findViewById(R.id.dateEndTextView)
        val descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_candidate_jobs, parent, false)
        return JobsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: JobsViewHolder, position: Int) {
        val item = list[position]
        holder.companyNameTextView.text = item.companyName
        holder.dateStartTextView.text = item.dateStart
        holder.dateEndTextView.text = item.dateEnd
        holder.descriptionTextView.text = item.description
    }

}