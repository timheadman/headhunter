package ru.megaland.headhunter.presentation.ui.vacancy

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.megaland.headhunter.app.App
import ru.megaland.headhunter.databinding.FragmentVacancyDetailsBinding
import javax.inject.Inject


class VacancyDetailsFragment : Fragment() {

    private lateinit var binding: FragmentVacancyDetailsBinding
    @Inject
    lateinit var vacancyDetailsViewModelFactory: VacancyDetailsViewModelFactory
    private val viewModel: VacancyDetailsViewModel by viewModels(factoryProducer = { vacancyDetailsViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentVacancyDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = arguments?.getString("vacancyId")

        Log.d("--->", "VacanciesFragment [onViewCreated] - Start")

        viewModel.liveVacancyById.observe(viewLifecycleOwner) {
            binding.vacancyCompanyTextView.text = it.companyId
            binding.vacancyProfessionTextView.text = it.profession
            binding.vacancyLevelTextView.text = it.level
            binding.vacancySalaryTextView.text = it.salary.toString()
            binding.vacancyDescriptionTextView.text = it.description
            Log.d("--->", "VacanciesFragment [onViewCreated]: viewModel.allVacanciesList.observe()")
        }

        viewModel.liveToast.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }

        viewModel.getVacancyById(id?:"0")

    }

}