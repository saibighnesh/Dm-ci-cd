package com.example.roomdatabasesample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.roomdatabasesample.data.UserDatabase
import com.example.roomdatabasesample.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            // The view ID 'btnUserList' from your original code does not exist in the
            // generated 'FragmentFirstBinding'. The available button is 'buttonFirst'.
            buttonFirst.setOnClickListener{
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
            // The view 'btnAddUser' is also not present in your layout 'fragment_first.xml'.
            // You might want to add it to your layout if you need it.
        }
    }

    fun getDBInstance(): UserDatabase {
        // This creates a builder, but doesn't build the database. You need to call .build().
        // It's also highly recommended to make your database a singleton and inject it
        // rather than creating it inside a Fragment, which is inefficient.
        return Room.databaseBuilder(requireContext(), UserDatabase::class.java, "user").build()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}