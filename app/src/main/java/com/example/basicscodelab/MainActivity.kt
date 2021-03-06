package com.example.basicscodelab

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodelabTheme
import com.example.basicscodelab.ui.theme.card
import com.example.basicscodelab.ui.theme.cellHeader
import com.example.basicscodelab.ui.theme.cellTitle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardScreen(onContinueClicked = { shouldShowOnboarding = false })
    } else {
        Greetings()
    }
}

@Composable
private fun Greetings(names: List<String> = List(1000) { "$it" }) {
    //used for background color of the screen (Root Container)
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
            items(items = names, itemContent = { name ->
                Greeting(name = name)
            })
        }
    }
}

@Composable
fun OnboardScreen(onContinueClicked: () -> Unit) {

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Welcome to the Basics Codelab!")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ) {
                Text("Continue")
            }
        }
    }
}

@Composable
private fun Greeting(name: String) {
    var expanded by rememberSaveable { mutableStateOf(false) }
    Card(
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        shape = MaterialTheme.shapes.card,
        elevation = 10.dp
        ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(
                    text = stringResource(R.string.hello),
                    style = MaterialTheme.typography.cellHeader
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.cellTitle
                )
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy, " +
                                "padding theme elit, sed do bouncy. ").repeat(4),
                    )
                }
            }
            IconButton(onClick = { expanded = !expanded }) {
                Icon(
                    imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription = if (expanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    }

                )
            }
        }
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greetings()
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    widthDp = 320,
    heightDp = 640
)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardScreen(onContinueClicked = { })
    }
}