package tech.aparimit.touchgrass.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily
import tech.aparimit.touchgrass.ui.theme.offWhite
import tech.aparimit.touchgrass.ui.theme.paleGreen
import tech.aparimit.touchgrass.ui.theme.paleWhite
import tech.aparimit.touchgrass.ui.theme.sand
import tech.aparimit.touchgrass.ui.theme.seaGreen

@Preview
@Composable
fun LoginSignupComponent() {
//    OffWhite(BG) pe PaleWhite
    var isLogin by remember {
        mutableStateOf(true)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(offWhite)
            .padding(32.dp, 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(32.dp))
                .background(paleWhite)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Button(
                onClick = {
                    isLogin = true
                },
                colors = ButtonColors(
                    containerColor = if (isLogin) paleGreen else paleWhite,
                    contentColor = Color.Black,
                    disabledContainerColor = paleWhite,
                    disabledContentColor = paleWhite,
                ),
                contentPadding = PaddingValues(32.dp,5.dp)
            ) {
                Text(
                    text = "Log In",
                    color = seaGreen,
                    fontSize = 14.sp,
                    fontFamily = dmSansFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Spacer(
                modifier = Modifier
                    .width(4.dp)
            )
            Button(
                onClick = {
                    isLogin = false
                },
                colors = ButtonColors(
                    containerColor = if (isLogin) paleWhite else paleGreen,
                    contentColor = Color.Black,
                    disabledContainerColor = paleWhite,
                    disabledContentColor = paleWhite,
                ),
                contentPadding = PaddingValues(32.dp,5.dp)
            ) {
                Text(
                    text = "Sign Up",
                    color = seaGreen,
                    fontSize = 14.sp,
                    fontFamily = dmSansFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
        Spacer(
            modifier = Modifier
                .height(24.dp)
        )
        if (isLogin) {
            LoginComponent()
        } else {
            SignupComponent()
        }
    }
}