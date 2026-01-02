package com.example.questfirebase_239

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.questfirebase_239.ui.theme.QuestFirebase_239Theme
import com.example.questfirebase_239.view.controlNavigasi.DataSiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuestFirebase_239Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DataSiswaApp(
                            navController = rememberNavController(),
                            modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
