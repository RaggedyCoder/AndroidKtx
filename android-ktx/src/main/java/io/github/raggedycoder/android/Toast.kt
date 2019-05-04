@file:Suppress("NOTHING_TO_INLINE")

package io.github.raggedycoder.android

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

inline fun Context.showToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(this, message, duration).apply {
        this.show()
    }

inline fun Context.showToast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) =
    showToast(this.getText(messageId), duration)

inline fun Fragment.showToast(@StringRes messageId: Int, duration: Int = Toast.LENGTH_SHORT) =
    context?.showToast(messageId, duration)

inline fun Fragment.showToast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) =
    context?.showToast(message, duration)