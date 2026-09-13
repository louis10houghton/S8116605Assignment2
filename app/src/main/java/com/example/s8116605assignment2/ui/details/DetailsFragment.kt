package com.example.s8116605assignment2.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.s8116605assignment2.databinding.FragmentDetailsBinding
import com.example.s8116605assignment2.network.model.Entity

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("DEPRECATION")
        val entity = arguments?.getSerializable("entity") as? Entity

        entity?.let {
            binding.detailsTechnique.text = it.technique
            binding.detailsSubject.text = "Subject: ${it.subject}"
            binding.detailsEquipment.text = "Equipment: ${it.equipment}"
            binding.detailsPhotographer.text = "Pioneering Photographer: ${it.pioneeringPhotographer}"
            binding.detailsYear.text = "Year Introduced: ${it.yearIntroduced}"
            binding.detailsDescription.text = it.description
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}