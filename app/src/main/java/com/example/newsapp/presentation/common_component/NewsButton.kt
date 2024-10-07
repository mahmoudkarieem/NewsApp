package com.example.newsapp.presentation.common_component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.loc.newsapp.ui.theme.WhiteGray

@Composable
fun NewsButton(
    modifier: Modifier = Modifier,
    textButton: String,
    onClickButton: () -> Unit
) {
    Button(
        onClick = onClickButton,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ), shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = textButton,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )

    }

}

@Composable
fun TextNewsButton(
    modifier: Modifier = Modifier,
    textButton: String,
    onClickButtonText: () -> Unit
) {
    Button(onClick = onClickButtonText,
//        colors = ButtonDefaults.buttonColors(
//            containerColor = WhiteGray,
//            contentColor = Color.White
//        ), shape = RoundedCornerShape(size = 6.dp)
        ) {
        Text(
            text = textButton,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = WhiteGray

        )
    }

}