package com.apcoding.coillibraryinjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.BlurTransformation
import coil.transform.CircleCropTransformation
import coil.transform.GrayscaleTransformation
import coil.transform.RoundedCornersTransformation
import com.apcoding.coillibraryinjetpack.ui.theme.CoilLibraryInJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoilLibraryInJetpackTheme {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CoilImage()
                }
            }
        }
    }
}

@Composable
fun CoilImage() {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(150.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = rememberImagePainter(
            data = "https://avatars.githubusercontent.com/u/14994036?v=4",
            builder = {
                placeholder(R.drawable.ic_launcher_background)
                error(R.drawable.ic_launcher_background)
                crossfade(1000)
                transformations(
                    GrayscaleTransformation(),
                    CircleCropTransformation(),
                    BlurTransformation(LocalContext.current),
                    RoundedCornersTransformation(50f)
                )
                   // this. // for more transformations
            }
        )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "Logo")
        if(painterState is coil.compose.ImagePainter.State.Loading) {
       // if(painterState is ImagePainter.State.Loading) {
        //    CircularProgressIndicator()
        }
    }
}

