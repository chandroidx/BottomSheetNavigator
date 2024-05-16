/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chandroidx.bottomsheetnavigator

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp

/**
 * Helper function to create a [ModalBottomSheetLayout] from a [BottomSheetNavigator].
 *
 * @see [ModalBottomSheetLayout]
 */
@Deprecated(
    "Migrate to Androidx compose.material.navigation ModalBottomSheetLayout with the same " +
            "parameters. To migrate, change import from " +
            "com.chandroidx.bottomsheetnavigator.ModalBottomSheetLayout to " +
            "androidx.compose.material.navigation.ModalBottomSheetLayout."
)
@ExperimentalMaterialNavigationApi
@OptIn(ExperimentalMaterialApi::class)
@Suppress("DEPRECATION")
@Composable
public fun ModalBottomSheetLayout(
    bottomSheetNavigator: BottomSheetNavigator,
    modifier: Modifier = Modifier,
    sheetShape: Shape = MaterialTheme.shapes.large,
    sheetElevation: Dp = ModalBottomSheetDefaults.Elevation,
    sheetBackgroundColor: Color = MaterialTheme.colors.surface,
    sheetContentColor: Color = contentColorFor(sheetBackgroundColor),
    scrimColor: Color = ModalBottomSheetDefaults.scrimColor,
    content: @Composable () -> Unit
) {
    androidx.compose.material.ModalBottomSheetLayout(
        sheetState = bottomSheetNavigator.sheetState,
        sheetContent = bottomSheetNavigator.sheetContent,
        modifier = modifier,
        sheetShape = sheetShape,
        sheetElevation = sheetElevation,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetContentColor = sheetContentColor,
        scrimColor = scrimColor,
        content = content
    )
}