package com.example.newsapp.presentation.screens.onboarding.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.R
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.newsapp.presentation.screens.onboarding.model.Page
import com.example.newsapp.presentation.screens.onboarding.model.pages
import com.example.newsapp.presentation.theme.NewsAppTheme

@Composable
fun OnBoarding(
    modifier: Modifier = Modifier,
    pageModel: Page
) {
    Column(modifier = modifier) {
        Image(

            modifier=Modifier.fillMaxWidth().fillMaxHeight(fraction = 0.6f)
               ,
            painter = painterResource(id = pageModel.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(MediumPadding1))
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2), text = pageModel.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = pageModel.description,
            style = MaterialTheme.typography.displaySmall,
            color = colorResource(id = R.color.text_medium)
        )

    }

}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun PreviewOnBoarding() {
//    NewsAppTheme {
//        OnBoarding(pageModel = pages[1])
//    }
//
//}