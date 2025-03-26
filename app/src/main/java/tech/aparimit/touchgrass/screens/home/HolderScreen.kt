package tech.aparimit.touchgrass.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tech.aparimit.touchgrass.HomeScreen
import tech.aparimit.touchgrass.ProfileScreen
import tech.aparimit.touchgrass.SettingsScreen
import tech.aparimit.touchgrass.components.home.BottomNavBar
import tech.aparimit.touchgrass.ui.theme.paleGreen

@Preview
@Composable
fun HolderScreen() {
    val navController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(paleGreen)
            .padding(12.dp, 38.dp, 12.dp, 12.dp)
            .clip(RoundedCornerShape(32.dp))
    ){
        NavHost(
            navController = navController,
            startDestination = HomeScreen,
        ){
            composable<HomeScreen>{ HomeScreen() }
            composable<SettingsScreen>{ SettingsScreen() }
            composable<ProfileScreen>{ ProfileScreen() }
        }
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(20.dp,0.dp,20.dp,12.dp)
                .clip(RoundedCornerShape(32.dp))
        ) {
            BottomNavBar(navController)
        }
    }
}