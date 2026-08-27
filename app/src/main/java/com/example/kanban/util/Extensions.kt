package com.example.kanban.util

import android.os.Message
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.kanban.R
import com.example.kanban.databinding.BottonSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Fragment.initToolbar(toolbar: Toolbar) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressedDispatcher?.onBackPressed()
    }
}
fun Fragment.showBottomSheet(
    titleDialog: Int? = null,
    titleButton: Int? = null,
    message: Int,
    onClick: () -> Unit ={}
){
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val binding: BottonSheetBinding =
            BottonSheetBinding.inflate(layoutInflater, null, false)

        binding.textviewTitle.text= getText( titleDialog?: R.string.text_title_warning)
        binding.textviewMessage.text = getText(message)
        binding.button0k.text = getText( titleButton?: R.string.text_button_warning)
        binding.button0k.setOnClickListener {
            onClick() //
            bottomSheetDialog.dismiss()
        }
}