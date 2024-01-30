package ru.megaland.headhunter.presentation.ui.vacancy

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
import ru.megaland.headhunter.databinding.FragmentVacanciesBinding
import javax.inject.Inject


class VacanciesFragment : Fragment() {

    private lateinit var binding: FragmentVacanciesBinding

    @Inject
    lateinit var vacanciesViewModelFactory: VacanciesViewModelFactory
    private val viewModel: VacanciesViewModel by viewModels(factoryProducer = { vacanciesViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentVacanciesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("--->", "VacanciesFragment [onViewCreated] - Start")

        viewModel.liveAllVacanciesList.observe(viewLifecycleOwner) {
            Log.d("--->", "VacanciesFragment [onViewCreated]: viewModel.allVacanciesList.observe()")
            val adapter = VacanciesCustomListViewAdapter(requireContext(), it)
            binding.vacanciesListView.adapter = adapter
        }

        viewModel.liveToast.observe(viewLifecycleOwner) {
            if (it != "") {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                viewModel.liveToast = MutableLiveData("")
            }
        }

        viewModel.getAllVacancies()
    }

}
