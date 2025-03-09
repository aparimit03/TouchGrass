package tech.aparimit.touchgrass.components.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tech.aparimit.touchgrass.R
import tech.aparimit.touchgrass.components.WelcomeScreen1
import tech.aparimit.touchgrass.components.WelcomeScreen2
import tech.aparimit.touchgrass.ui.theme.brown
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily
import tech.aparimit.touchgrass.ui.theme.lightGreen
import tech.aparimit.touchgrass.ui.theme.offText
import tech.aparimit.touchgrass.ui.theme.paleGreen
import tech.aparimit.touchgrass.ui.theme.sunshineYellow

@Composable
fun WelcomeScreen3(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(paleGreen)
            .padding(12.dp, 38.dp, 12.dp, 12.dp)
            .clip(RoundedCornerShape(32.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(lightGreen)
                .padding(12.dp)
        ) {
            Text(
                text = "Upload a daily photo to keep your streak alive!",
                fontSize = 48.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = offText,
            )
            Image(
                modifier = Modifier
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.welcome_screen_3),
                contentDescription = ""
            )
        }
        Button(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.BottomEnd),
            onClick = {
                navController.navigate(WelcomeScreen1)
            },
            colors = ButtonColors(
                containerColor = brown,
                contentColor = Color.White,
                disabledContainerColor = sunshineYellow,
                disabledContentColor = sunshineYellow
            )
        ) {
            Text(
                modifier = Modifier.padding(16.dp, 8.dp),
                text = "Continue (3/3)",
                fontSize = 14.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}