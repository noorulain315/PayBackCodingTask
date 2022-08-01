package com.example.paybackcodingtask.ui.fragments

import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.utils.*
import com.example.domain.models.ImageModel
import com.example.paybackcodingtask.R
import com.example.paybackcodingtask.databinding.FragmentImagesBinding
import com.example.paybackcodingtask.ui.adapters.ImagesAdapter
import com.example.paybackcodingtask.ui.viewmodels.ImagesViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ImagesFragment : Fragment() {

    private lateinit var binding: FragmentImagesBinding
    private val imagesViewModel: ImagesViewModel by viewModels()
    private val imagesAdapter = ImagesAdapter { showFullImageAlert(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_images, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
        setListeners()
        loadImages(getSearchQuery())
    }

    override fun onResume() {
        super.onResume()
        KeyboardUtils.hideVirtualKeyboard(requireActivity())
    }

    private fun setViews() {
        binding.searchTextView.apply {
            setText(getString(R.string.default_query))
            text?.length?.let { setSelection(it) }
        }
        binding.recyclerView.layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.adapter = imagesAdapter
    }

    private fun setListeners() {
        binding.confirmSearch.setOnClickListener {
            if (isInputValid()) {
                KeyboardUtils.hideVirtualKeyboard(requireActivity())
                loadImages(getSearchQuery())
            }
        }

        binding.retryView.setOnClickListener { imagesAdapter.refresh() }

        imagesAdapter.addLoadStateListener { state ->
            when (state.refresh) {
                is LoadState.Loading -> {
                    binding.noResultView.hide()
                    binding.progressBar.show()
                    binding.retryView.hide()
                    binding.recyclerView.hide()
                }
                is LoadState.NotLoading -> {
                    binding.progressBar.hide()
                    binding.retryView.hide()
                    binding.noResultView.visibleWhenTrue(imagesAdapter.itemCount == 0)
                    binding.recyclerView.visibleWhenTrue(imagesAdapter.itemCount > 0)
                }
                is LoadState.Error -> {
                    binding.noResultView.hide()
                    binding.recyclerView.hide()
                    binding.progressBar.hide()
                    binding.retryView.show()
                }
            }
        }
    }

    private fun loadImages(searchString: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            imagesViewModel.getImages(searchString).observe(viewLifecycleOwner, Observer {
                imagesAdapter.submitData(viewLifecycleOwner.lifecycle, it)
            })
        }
    }

    private fun getSearchQuery() =
        binding.searchTextView.text.toString()

    private fun isInputValid() = binding.searchTextView.text?.isNotBlank() == true

    private fun navigateToDetailsScreen(imageModel: ImageModel) {
        val action = ImagesFragmentDirections.actionImagesFragmentToImageDetailsFragment(imageModel)
        findNavController().navigate(action)

    }

    private fun showFullImageAlert(imageModel: ImageModel) {
        val clickListenerCancel = DialogInterface.OnClickListener { dialog, _ ->
            navigateToDetailsScreen(imageModel)
            dialog.dismiss()
        }
        DialogUtil.getAlertDialog(
            requireContext(),
            R.array.show_full_image_alert,
            clickListenerCancel
        )
            .setCancelable(false)
            .show()
    }
}