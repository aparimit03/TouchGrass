package tech.aparimit.touchgrass.components.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tech.aparimit.touchgrass.R
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily
import tech.aparimit.touchgrass.ui.theme.paleWhite
import tech.aparimit.touchgrass.ui.theme.seaGreen

@Preview
@Composable
fun OtherOptionsAuthentication() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(seaGreen)
            .padding(32.dp, 40.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Continue With:",
            fontFamily = dmSansFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 24.sp,
            color = paleWhite
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Button(
                onClick = {
                },
                colors = ButtonColors(
                    containerColor = paleWhite,
                    contentColor = Color.Black,
                    disabledContainerColor = paleWhite,
                    disabledContentColor = paleWhite
                ),
                contentPadding = PaddingValues(32.dp,16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_google_auth),
                    contentDescription = "Google Authentication"
                )
            }
            Button(
                onClick = {
                },
                colors = ButtonColors(
                    containerColor = paleWhite,
                    contentColor = Color.Black,
                    disabledContainerColor = paleWhite,
                    disabledContentColor = paleWhite
                ),
                contentPadding = PaddingValues(32.dp,16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_facebook_auth),
                    contentDescription = "Facebook Authentication"
                )
            }
            Button(
                onClick = {
                },
                colors = ButtonColors(
                    containerColor = paleWhite,
                    contentColor = Color.Black,
                    disabledContainerColor = paleWhite,
                    disabledContentColor = paleWhite
                ),
                contentPadding = PaddingValues(32.dp,16.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_x_auth),
                    contentDescription = "X Authentication"
                )
            }
        }
    }
}