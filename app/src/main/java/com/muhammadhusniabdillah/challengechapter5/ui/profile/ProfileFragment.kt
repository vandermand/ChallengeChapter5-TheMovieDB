package com.muhammadhusniabdillah.challengechapter5.ui.profile

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.muhammadhusniabdillah.challengechapter5.R
import com.muhammadhusniabdillah.challengechapter5.data.preferences.Helper
import com.muhammadhusniabdillah.challengechapter5.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPref: Helper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val profileBinding = FragmentProfileBinding.inflate(inflater, container, false)
        binding = profileBinding
        return profileBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPref = Helper(requireContext())

        binding.apply {
            btnLogout.setOnClickListener { loggingOut() }
        }
    }

    private fun loggingOut() {
        AlertDialog.Builder(requireContext())
            .setTitle("Logout?")
            .setMessage("Are you sure?")
            .setPositiveButton("Yes") { _, _ ->
                sharedPref.clear()
                findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
            }
            .setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }

}