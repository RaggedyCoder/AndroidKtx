package io.github.raggedycoder.android

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder

inline fun Activity.alertDialog(block: MaterialAlertDialogBuilder.() -> Unit) =
    MaterialAlertDialogBuilder(this).apply(block).create()

inline fun Fragment.alertDialog(block: MaterialAlertDialogBuilder.() -> Unit): AlertDialog {
    if (isAdded) {
        return activity?.alertDialog(block)!!
    } else {
        throw RuntimeException("$this isn't added to its activity")
    }
}