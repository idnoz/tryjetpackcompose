package com.example.tryjetpackcomposed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tryjetpackcomposed.ui.theme.TryJetpackComposedTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(scaffoldState = scaffoldState) {
                var counter = produceState(initialValue = 0) {
                    delay(3000L)
                    value = 4
                }
                if (counter.value % 5 == 0 && counter.value > 0) {
                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }
                }
                Button(onClick = { }) {
                    Text(text = "Click Me ${counter.value}")
                }
            }

//            val scaffoldState = rememberScaffoldState()
//            val scope = rememberCoroutineScope()
//            Scaffold(scaffoldState = scaffoldState) {
//                var counter by remember {
//                    mutableStateOf(0)
//                }
//                if (counter % 5 == 0 && counter > 0) {
//                    LaunchedEffect(key1 = scaffoldState.snackbarHostState) {
//                        scaffoldState.snackbarHostState.showSnackbar("Hello")
//                    }
//                }
//                Button(onClick = { counter++ }) {
//                    Text(text = "Click Me ${counter}")
//                }
//            }
        }
    }
}
