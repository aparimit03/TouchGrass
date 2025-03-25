package tech.aparimit.touchgrass.screens.welcome

import android.content.Intent
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import tech.aparimit.touchgrass.AuthenticationActivity
import tech.aparimit.touchgrass.R
import tech.aparimit.touchgrass.ui.theme.brown
import tech.aparimit.touchgrass.ui.theme.darkGreen
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily
import tech.aparimit.touchgrass.ui.theme.lightGreen
import tech.aparimit.touchgrass.ui.theme.paleWhite
import tech.aparimit.touchgrass.ui.theme.paleGreen
import tech.aparimit.touchgrass.ui.theme.seaGreen
import tech.aparimit.touchgrass.ui.theme.sunshineYellow

@Composable
fun WelcomeScreen3(navController: NavController){
    val context = LocalContext.current
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
                .background(seaGreen)
                .padding(12.dp)
        ) {
            Text(
                text = stringResource(R.string.str_welcome_screen_3_title),
                fontSize = 48.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                color = paleWhite,
            )
            Image(
                modifier = Modifier
                    .padding(0.dp, 8.dp, 0.dp, 0.dp)
                    .fillMaxWidth(),
                painter = painterResource(R.drawable.welcome_screen_3),
                contentDescription = stringResource(R.string.str_welcome_screen_3_image_cd),
            )
        }
        Button(
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.BottomEnd),
            onClick = {
                Intent(context, AuthenticationActivity::class.java).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }.also {
                    context.startActivity(it)
                }
            },
            colors = ButtonColors(
                containerColor = brown,
                contentColor = paleWhite,
                disabledContainerColor = brown,
                disabledContentColor = brown
            )
        ) {
            Text(
                modifier = Modifier.padding(16.dp, 8.dp),
                text = stringResource(R.string.str_welcome_screen_3_btn_text),
                fontSize = 14.sp,
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}