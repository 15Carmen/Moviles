package com.example.whatssappfirebase.ui.core

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes

fun String.isPasswordValid() =
    isNotBlank() && length > 6 && length <= 20

fun String.isEmailValid() =
    isNotBlank() && contains("@")

fun Context.showToast(@StringRes stringRes: Int) {
    showToast(getString(stringRes))
}

fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}