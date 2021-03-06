/*
 * Copyright 2019 RaggedyCoder.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:Suppress("NOTHING_TO_INLINE")

package io.github.raggedycoder.android

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

inline fun View.showSnackbar(
    message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) {
    val snackbar = Snackbar.make(this, message, duration)
    if (actionText != null && action == null) {
        snackbar.setAction(actionText, null)
    } else if (actionText == null && action != null) {
        snackbar.setAction(null) {
            action()
        }
    } else if (actionText != null && action != null) {
        snackbar.setAction(actionText) {
            action()
        }
    }
    snackbar.show()
}

inline fun View.showSnackbar(
    @StringRes messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) = showSnackbar(resources.getString(messageResId), duration, actionText, action)

inline fun Activity.showSnackbar(
    message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) = findViewById<View>(android.R.id.content)?.showSnackbar(message, duration, actionText, action)

inline fun Activity.showSnackbar(
    @StringRes messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) = showSnackbar(getString(messageResId), duration, actionText, action)

inline fun Fragment.showSnackbar(
    message: CharSequence, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) {
    if (isAdded) {
        view?.showSnackbar(message, duration, actionText, action)
    }
}

inline fun Fragment.showSnackbar(
    @StringRes messageResId: Int, duration: Int = Snackbar.LENGTH_SHORT,
    actionText: CharSequence? = null,
    noinline action: (() -> Unit)? = null
) {
    if (isAdded) {
        view?.showSnackbar(messageResId, duration, actionText, action)
    }
}