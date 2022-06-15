package com.example.basicscodelab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.ExtendedTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExtendedTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp(names: List<String> = listOf("World", "Jetpack", "Compose")) {
    Surface(modifier = Modifier
        .background(MaterialTheme.colors.background)
        .padding(vertical = 4.dp)
        .fillMaxSize()) {
        Column {
            for (name in names ) {
                Greeting(name = name)
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {

    var expanded by remember { mutableStateOf(false) }
    val extraPadding = if (expanded) 48.dp else 0.dp

    Surface(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        color = MaterialTheme.colors.primary,
        border = BorderStroke(4.dp, Color.White),
        elevation = 10.dp
    ) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
            ) {
                Text(
                    text = "Show more, ",
                    style = ExtendedTheme.typography.bigButtonText
                )
                Text(text = name, style = MaterialTheme.typography.h6)
            }
            Column(modifier = Modifier.padding(bottom = extraPadding)) {
                OutlinedButton(
                    onClick = { expanded = !expanded }
                ) {
                    Text(
                        text =  if (expanded) "Show less" else "Show more",
                        style = ExtendedTheme.typography.bigButtonText,
                        color = ExtendedTheme.colors.onTertiary
                    )
                }
                Button(onClick = { expanded = !expanded}) {
                    Text(
                        text =  if (expanded) "Show less" else "Show more",
                        color = ExtendedTheme.colors.onTertiary
                    )
                }
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    widthDp = 320
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    widthDp = 320
)
@Composable
fun DefaultPreview() {
    ExtendedTheme {
        MyApp()
    }
}