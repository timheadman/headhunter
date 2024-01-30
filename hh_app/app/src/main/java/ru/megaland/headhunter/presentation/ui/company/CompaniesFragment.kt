package ru.megaland.headhunter.presentation.ui.company

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import ru.megaland.headhunter.app.App
import ru.megaland.headhunter.databinding.FragmentCompaniesBinding
import javax.inject.Inject


class CompaniesFragment : Fragment() {

    private lateinit var binding: FragmentCompaniesBinding

    @Inject
    lateinit var companiesViewModelFactory: CompaniesViewModelFactory
    private val viewModel: CompaniesViewModel by viewModels(factoryProducer = { companiesViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentCompaniesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("--->", "CompaniesFragment [onViewCreated] - Start")

        viewModel.liveAllCompaniesList.observe(viewLifecycleOwner) {
            Log.d("--->", "CompaniesFragment [onViewCreated]: viewModel.allCompaniesList.observe()")
            val adapter = CompaniesCustomListViewAdapter(requireContext(), it)
            binding.companiesListView.adapter = adapter
        }

        viewModel.liveToast.observe(viewLifecycleOwner) {
            if (it != "") {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                viewModel.liveToast = MutableLiveData("")
            }
        }

        viewModel.getAllCompanies()
    }

}
