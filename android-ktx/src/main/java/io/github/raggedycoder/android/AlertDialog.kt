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