package ru.megaland.headhunter.presentation.ui.candidate

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.megaland.headhunter.R
import ru.megaland.headhunter.app.App
import ru.megaland.headhunter.databinding.FragmentCandidateBinding
import javax.inject.Inject

class CandidateFragment : Fragment() {

    private lateinit var binding: FragmentCandidateBinding
    @Inject
    lateinit var candidateViewModelFactory: CandidateViewModelFactory
    private val viewModel: CandidateViewModel by viewModels(factoryProducer = { candidateViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentCandidateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("--->", "CandidateFragment [onViewCreated]: Start")

        viewModel.liveCandidateById.observe(viewLifecycleOwner) {
            Log.d("--->", "CandidateFragment [onViewCreated]: viewModel.liveCandidateById.observe()")
            binding.candidateViewFullName.text = it.candidateInfo.name
            binding.candidateViewProfession.text = it.candidateInfo.profession
            binding.candidateViewSex.text = it.candidateInfo.sex
            binding.candidateViewBirthday.text = it.candidateInfo.birthDate
            binding.candidateViewEmail.text = it.candidateInfo.contacts.email
            binding.candidateViewPhone.text = it.candidateInfo.contacts.phone
            binding.candidateViewFreeForm.text = it.description
            binding.candidateViewTags.text = it.tags.joinToString(" ") { "#${it.tags}" }
            val educationAdapter = CandidateEducationRecyclerViewAdapter(it.education)
            binding.candidateRecyclerViewEducation.layoutManager = LinearLayoutManager(context)
            binding.candidateRecyclerViewEducation.adapter = educationAdapter
            val jobsAdapter = CandidateJobsRecyclerViewAdapter(it.jobExperience)
            binding.candidateRecyclerViewJobs.layoutManager = LinearLayoutManager(context)
            binding.candidateRecyclerViewJobs.adapter = jobsAdapter
        }

        viewModel.liveToast.observe(viewLifecycleOwner) {
            if (it != "") {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                viewModel.liveToast = MutableLiveData("")
            }
        }

        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_nav_menu_candidate, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.editCandidate -> {
                        findNavController().navigate(R.id.action_candidateFragment_to_candidateEditFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.getCandidateById("1")

    }

}