package com.example.explicitintentpassingkotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityUI()
        }
    }

    @Composable
    fun MainActivityUI() {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Activity 1",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.padding(30.dp))
            var text by remember {
                mutableStateOf("")
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Name") }
            )

            Spacer(modifier = Modifier.padding(80.dp))

            Button(
                onClick = {
                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("data", text)
                    startActivity(intent)
                })
            {
                Text(text = "Second Activity")

            }

        }
    }


    @Preview(showBackground = true)
    @Composable
    fun preview() {
        MainActivityUI()
    }
}
