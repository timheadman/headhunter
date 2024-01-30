package ru.megaland.headhunter.presentation.ui.vacancy

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.navigation.findNavController
import ru.megaland.headhunter.R
import ru.megaland.headhunter.domain.model.company.VacancyShort

class VacanciesCustomListViewAdapter(
    private val context: Context,
    private val list: List<VacancyShort>
) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): VacancyShort {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val instanceConvertView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_vacancies, parent, false)

        val currentItem = getItem(position)

        val id = instanceConvertView?.findViewById<TextView>(R.id.vacancyListItemIdTextView)
        val company = instanceConvertView?.findViewById<TextView>(R.id.vacancyListItemCompanyTextView)
        val profession = instanceConvertView?.findViewById<TextView>(R.id.vacancyListItemProfessionTextView)
        val level = instanceConvertView?.findViewById<TextView>(R.id.vacancyListItemLevelTextView)
        val salary = instanceConvertView?.findViewById<TextView>(R.id.vacancyListItemSalaryTextView)

        id?.text = currentItem.id
        company?.text = currentItem.company
        profession?.text = currentItem.profession
        level?.text = currentItem.level
        salary?.text = currentItem.salary.toString()

        val bundle = Bundle()

        instanceConvertView.setOnClickListener {
            Log.d(
                "--->",
                "VacanciesFragment [setOnItemClickListener]: " +
                        "company = ${currentItem.company}, " +
                        "profession = ${currentItem.profession}, " +
                        "id = ${currentItem.id}"
            )
            bundle.putString("vacancyId", currentItem.id)
            instanceConvertView.findNavController()
                .navigate(R.id.action_vacanciesFragment_to_vacancyDetailsFragment, bundle)
        }

        return instanceConvertView
    }
}