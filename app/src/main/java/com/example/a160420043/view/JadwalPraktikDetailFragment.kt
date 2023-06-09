package com.example.a160420043.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160420043.R
import com.example.a160420043.util.loadImage
import com.example.a160420043.viewmodel.JadwalListViewModel
import com.google.android.material.textfield.TextInputEditText

/**
 * A simple [Fragment] subclass.
 * Use the [JadwalPraktikDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JadwalPraktikDetailFragment : Fragment() {
    // VERSION 1
//    private lateinit var viewModel:JadwalDetailListViewModel

    // VERSION 2
    private lateinit var viewModel:JadwalListViewModel
    // BATAS

//    private val jadwalListAdapter = JadwalPraktikDetailAdapter(arrayListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jadwal_praktik_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val jadwalId = JadwalPraktikDetailFragmentArgs.fromBundle(requireArguments()).index

//        val recView = view.findViewById<RecyclerView>(R.id.recViewJadwalDetail)

        // VERSION 1
//        viewModel = ViewModelProvider(this).get(JadwalDetailListViewModel::class.java)
//        viewModel.refresh(jadwalId)

        // VERSION 2
        viewModel = ViewModelProvider(this).get(JadwalListViewModel::class.java)
        viewModel.searchId(jadwalId)

        viewModel.jadwalDetailLD.observe(viewLifecycleOwner, Observer { jadwalDetail ->
            val txtId = view.findViewById<TextInputEditText>(R.id.txtIdJadwalDetail)
            val txtNama = view.findViewById<TextInputEditText>(R.id.txtNamaDokterJadwalDetail)
            val txtHari = view.findViewById<TextInputEditText>(R.id.txtHariJadwalDetail)
            val txtPhotoUrl = view.findViewById<TextInputEditText>(R.id.txtPhotoUrlJadwalDetail)

            txtId.setText(jadwalDetail[0].id.toString())
            txtNama.setText(jadwalDetail[0].namaDokter.toString())
            txtHari.setText(jadwalDetail[0].hari.toString())
            txtPhotoUrl.setText(jadwalDetail[0].photoUrl.toString())

            val imageView = view.findViewById<ImageView>(R.id.imgViewJadwalDetail)
            imageView.loadImage(jadwalDetail[0].photoUrl)
        })

//        recView.layoutManager = LinearLayoutManager(context)
//        recView.adapter = jadwalListAdapter
//
//        observeViewModel()
    }

//    fun observeViewModel() {
//        viewModel.jadwalDetailLD.observe(viewLifecycleOwner, Observer {
//            jadwalListAdapter.updateJadwalList(it)
//        })
//    }
}