package tech.aparimit.touchgrass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.aparimit.touchgrass.components.*
import tech.aparimit.touchgrass.screens.welcome.WelcomeScreen1
import tech.aparimit.touchgrass.screens.welcome.WelcomeScreen2
import tech.aparimit.touchgrass.screens.welcome.WelcomeScreen3

class WelcomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = WelcomeScreen1
            ) {
                composable<WelcomeScreen1> { WelcomeScreen1(navController) }
                composable<WelcomeScreen2> { WelcomeScreen2(navController) }
                composable<WelcomeScreen3> { WelcomeScreen3(navController) }
            }
        }
    }
}