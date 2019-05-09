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