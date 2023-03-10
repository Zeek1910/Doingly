package com.zeek1910.doingly.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zeek1910.doingly.presentation.theme.DoinglyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoinglyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    viewModel: TestViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    Text(text = "Hello $name!")
    LaunchedEffect(key1 = Unit, block = {
        viewModel.testSignIn()
    })
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DoinglyTheme {
        Greeting("Zeek")
    }
}