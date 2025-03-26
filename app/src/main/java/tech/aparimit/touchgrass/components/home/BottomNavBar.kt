package tech.aparimit.touchgrass.components.home

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import tech.aparimit.touchgrass.HomeScreen
import tech.aparimit.touchgrass.ProfileScreen
import tech.aparimit.touchgrass.R
import tech.aparimit.touchgrass.SettingsScreen
import tech.aparimit.touchgrass.ui.theme.darkGray
import tech.aparimit.touchgrass.ui.theme.offWhite
import tech.aparimit.touchgrass.ui.theme.paleGreen

@Composable
fun BottomNavBar(navController: NavHostController) {

	var selectedItemIndex by remember { mutableIntStateOf(0) }
	val navBarItems = listOf("Home", "Profile", "Settings")
	val navRoute = listOf(HomeScreen, ProfileScreen, SettingsScreen)
	val navBarIcons = listOf(R.drawable.ic_home, R.drawable.ic_profile, R.drawable.ic_settings)

	NavigationBar(
		containerColor = offWhite,
	) {
		navBarItems.forEachIndexed { index, item ->
			NavigationBarItem(
				icon = {
					Icon(
						painter = painterResource(navBarIcons[index]),
						contentDescription = item
					)
				},
//				selected = selectedItemIndex == index,
				selected = false,
				onClick = {
					if (selectedItemIndex != index) {
						selectedItemIndex = index
						navController.navigate(navRoute[index]){
							popUpTo(navController.graph.startDestinationId) { saveState = true }
							launchSingleTop = true  // Avoids reloading the same screen if it's already in the stack
							restoreState = true     // Restores previous states when navigating back
						}
					}
				},
				colors = NavigationBarItemDefaults.colors(
					selectedIconColor = Color.Black,
					unselectedIconColor = Color.Black,
					indicatorColor = paleGreen
				)
			)
		}
	}
}