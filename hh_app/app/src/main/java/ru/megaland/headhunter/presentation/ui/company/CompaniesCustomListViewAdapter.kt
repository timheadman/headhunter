package ru.megaland.headhunter.presentation.ui.company

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
import ru.megaland.headhunter.domain.model.company.CompanyShort

class CompaniesCustomListViewAdapter(
    private val context: Context,
    private val list: List<CompanyShort>
) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): CompanyShort {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val instanceConvertView = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_companies, parent, false)

        val currentItem = getItem(position)

        val id = instanceConvertView?.findViewById<TextView>(R.id.companyListItemIdTextView)
        val company =
            instanceConvertView?.findViewById<TextView>(R.id.companyListItemCompanyTextView)
        val industry =
            instanceConvertView?.findViewById<TextView>(R.id.companyListItemIndustryTextView)

        id?.text = currentItem.id
        company?.text = currentItem.name
        industry?.text = currentItem.industry

        val bundle = Bundle()

        instanceConvertView.setOnClickListener {
            Log.d(
                "--->",
                "CompaniesFragment [setOnItemClickListener]: company = ${currentItem.name}, id = ${currentItem.id}"
            )
            bundle.putString("companyId", currentItem.id)
            instanceConvertView.findNavController()
                .navigate(R.id.action_companiesFragment_to_companyDetailsFragment, bundle)
        }

        return instanceConvertView
    }
}