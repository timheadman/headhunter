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
import ru.megaland.headhunter.R
import ru.megaland.headhunter.app.App
import ru.megaland.headhunter.databinding.FragmentCandidateEditBinding
import javax.inject.Inject

class CandidateEditFragment : Fragment() {

    private lateinit var binding: FragmentCandidateEditBinding
    @Inject
    lateinit var candidateEditViewModelFactory: CandidateEditViewModelFactory
    private val viewModel: CandidateEditViewModel by viewModels(factoryProducer = { candidateEditViewModelFactory })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity?.application as App).appComponent.inject(this)
        binding = FragmentCandidateEditBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("--->", "CandidateEditFragment [onViewCreated]: Start")

        viewModel.liveCandidateById.observe(viewLifecycleOwner) {
            Log.d("--->", "CandidateEditFragment [onViewCreated]: viewModel.liveCandidateById.observe()")
            binding.candidateEditFullName.setText(it.candidateInfo.name)
            binding.candidateEditProfession.setText(it.candidateInfo.profession)
            binding.candidateEditBirthday.setText(it.candidateInfo.birthDate)
            binding.candidateEditGender.setText(it.candidateInfo.sex)
            binding.candidateEditEmail.setText(it.candidateInfo.contacts.email)
            binding.candidateEditPhone.setText(it.candidateInfo.contacts.phone)
            binding.candidateEditDescription.setText(it.description)
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
                menuInflater.inflate(R.menu.toolbar_nav_menu_candidate_edit, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.buttonSave -> {
                        Log.d("--->", "CandidateEditFragment: Button Save click!")
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.getCandidateById("1")

    }

}