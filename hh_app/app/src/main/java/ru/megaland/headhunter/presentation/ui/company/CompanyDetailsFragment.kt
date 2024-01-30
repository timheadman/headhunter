package ru.megaland.headhunter.presentation.ui.company

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.megaland.headhunter.app.App
import ru.megaland.headhunter.databinding.FragmentCompanyDetailsBinding
import javax.inject.Inject


class CompanyDetailsFragment : Fragment() {

    private lateinit var binding: FragmentCompanyDetailsBinding
    @Inject
    lateinit var companyDetailsViewModelFactory: CompanyDetailsViewModelFactory
    private val viewModel: CompanyDetailsViewModel by viewModels(factoryProducer = { companyDetailsViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentCompanyDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("companyId")

        Log.d("--->", "CompaniesFragment [onViewCreated] - Start")

        viewModel.liveCompanyById.observe(viewLifecycleOwner) {
            binding.companyCompanyTextView.text = it.name
            binding.companyIndustryTextView.text = it.industry
            binding.companyContactsTextView.text = it.contacts
            Log.d("--->", "CompaniesFragment [onViewCreated]: viewModel.allCompaniesList.observe()")
        }

        viewModel.liveToast.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getCompanyById(id?:"0")

    }

}