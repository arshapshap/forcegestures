package com.arshapshap.forcegestures.sample.utils

import android.graphics.Color
import android.widget.Toast
import androidx.annotation.AttrRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.color.MaterialColors


internal fun Fragment.showToast(@StringRes resId: Int) {
    Toast.makeText(requireContext(), resId, Toast.LENGTH_SHORT).show()
}

internal fun Fragment.showToast(string: String) {
    Toast.makeText(requireContext(), string, Toast.LENGTH_SHORT).show()
}

internal fun Fragment.getColorFromTheme(@AttrRes colorAttr: Int): Int {
    return MaterialColors.getColor(requireContext(), colorAttr, Color.BLACK)
}

internal fun Fragment.getPrimaryColor(): Int {
    return getColorFromTheme(androidx.appcompat.R.attr.colorPrimary)
}

internal fun Fragment.getColorControlHighlight(): Int {
    return getColorFromTheme(androidx.appcompat.R.attr.colorControlHighlight)
}