package com.example.s8116605assignment2.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.s8116605assignment2.R
import com.example.s8116605assignment2.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TEMPORARY: tap to test navigation to Details (later: RecyclerView item click)
        binding.dashboardTitle.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_details)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}