package tech.aparimit.touchgrass.screens.auth

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tech.aparimit.touchgrass.components.auth.LoginSignupComponent
import tech.aparimit.touchgrass.components.auth.OtherOptionsAuthentication
import tech.aparimit.touchgrass.ui.theme.paleGreen

@Preview
@Composable
fun AuthenticationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(paleGreen)
            .padding(12.dp, 38.dp, 12.dp, 12.dp)
    ) {
        LoginSignupComponent()
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
        )
        OtherOptionsAuthentication()
    }
}