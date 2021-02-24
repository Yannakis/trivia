package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.android.navigation.databinding.FragmentTitleBinding


/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
             inflater, R.layout.fragment_title, container, false)
             binding.playButton.setOnClickListener (
                     Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
                     )
                 /** findNavController(view): takes the view, finds the enclosing NavHostFragment
                  *  and returns the navigation controller for that NavHostFragment (= parent of TitleFragment)
                  *   So now we have a navigation controller and are able to navigate to the gameFragment
                  *  Navigate to gameFragment:  .navigate(R.id.action_titleFragment_to_gameFragment)
                  *
                  *  But we can now replace the statement:
                  *  Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
                  *  by view.findNavController
                  *  since Kotlin extension functions allow a class to extend
                  *  the functionality of an existing class without sub-classing it.
                  *  KTX has an extension function for the Android view class.
                  *
                  *  And then instead of
                  *  binding.playButton.setOnClickListener { view: View ->
                  *     view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
                  *  use
                  *  binding.playButton.setOnClickListener (
                  *         Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
                  *  )
                  */
        return binding.root
    }

}