package com.shobu.eldcompose.ui.screens.shared

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shobu.eldcompose.R

@Preview
@Composable
fun BorderedTextFieldPrev() {
    Box(
        modifier = Modifier
            .padding(10.dp)
    ) {
//        BorderedTextField()
    }
}

@Composable
fun BorderedTextField(textFieldValue: MutableState<String>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.Black
                ),
                shape = RoundedCornerShape(8.dp)
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .fillMaxSize(),
            value = textFieldValue.value,
            onValueChange = {
                textFieldValue.value = it
            },
            singleLine = true,
            maxLines = 1,
            textStyle = TextStyle(
                fontSize = 13.sp,
                fontFamily = FontFamily(
                    Font(R.font.roboto)
                )
            ),
            placeholder = {
                Text(
                    "e.g. 564323454",
                    style = TextStyle(
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(
                            Font(R.font.roboto)
                        )
                    ),
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
            ),
        )
    }
}