package tech.aparimit.touchgrass.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily

@Preview
@Composable
fun SettingsScreen() {
	Column(
		modifier = Modifier
			.fillMaxSize(),
		verticalArrangement = Arrangement.Center
	) {
		Text(
			text = "Settings Screen",
			modifier = Modifier
				.fillMaxWidth(),
			fontSize = 48.sp,
			color = Color.Black,
			fontFamily = dmSansFontFamily,
			textAlign = TextAlign.Center
		)
	}
}