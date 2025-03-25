package tech.aparimit.touchgrass.components.auth

import android.content.Intent
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import tech.aparimit.touchgrass.MainActivity
import tech.aparimit.touchgrass.R
import tech.aparimit.touchgrass.loginWithEmailAndPassword
import tech.aparimit.touchgrass.ui.theme.dmSansFontFamily
import tech.aparimit.touchgrass.ui.theme.paleGreen
import tech.aparimit.touchgrass.ui.theme.paleWhite
import tech.aparimit.touchgrass.ui.theme.seaGreen

@Preview(showBackground = true)
@Composable
fun LoginComponent() {
    val context = LocalContext.current
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    var doRemember by remember {
        mutableStateOf(true)
    }
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Welcome back!",
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        color = seaGreen
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(12.dp)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        text = "Login",
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp,
        color = seaGreen
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
    )
    TextField(
        value = email,
        onValueChange = {
            email = it
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = dmSansFontFamily,
            background = paleWhite
        ),
        singleLine = true,
        label = {
            Text(
                text = "Your Email",
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Black
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_email),
                contentDescription = "Email Icon"
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(paleWhite),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledTextColor = Color.Black,
            errorTextColor = Color.Black,
            focusedContainerColor = paleWhite,
            unfocusedContainerColor = paleWhite,
            disabledContainerColor = paleWhite,
            errorContainerColor = paleWhite,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
    )
    TextField(
        value = password,
        onValueChange = {
            password = it
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = dmSansFontFamily,
            background = paleWhite
        ),
        singleLine = true,
        label = {
            Text(
                text = "Your Password",
                fontFamily = dmSansFontFamily,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Black
            )
        },
        trailingIcon = {
            if (isPasswordVisible) {
                Icon(
                    painter = painterResource(R.drawable.ic_password_visible),
                    contentDescription = "Password Visibility Off Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        },
                )
            } else {
                Icon(
                    painter = painterResource(R.drawable.ic_password_invisible),
                    contentDescription = "Password Visibility On Icon",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isPasswordVisible = !isPasswordVisible
                        },
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(paleWhite),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            disabledTextColor = Color.Black,
            errorTextColor = Color.Black,
            focusedContainerColor = paleWhite,
            unfocusedContainerColor = paleWhite,
            disabledContainerColor = paleWhite,
            errorContainerColor = paleWhite,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation =
            if (isPasswordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation()
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
    )
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                Toast.makeText(context, "Goldfish LOL", Toast.LENGTH_SHORT).show()
            },
        text = "Forgot Password?",
        fontFamily = dmSansFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        color = Color.Black,
    )
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
    )
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp)),
        onClick = {
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(context,"Email or Password Empty",Toast.LENGTH_SHORT).show()
            }
            else {
                (context as? ComponentActivity)?.lifecycleScope?.launch {
                    loginWithEmailAndPassword(email, password)
                }?.invokeOnCompletion {
                    context.startActivity(Intent(context, MainActivity::class.java))
                }
            }
        },
        colors = ButtonColors(
            containerColor = paleGreen,
            contentColor = Color.Black,
            disabledContainerColor = paleGreen,
            disabledContentColor = paleGreen
        ),
        contentPadding = PaddingValues(24.dp, 18.dp)
    ) {
        Text(
            text = "Lets Roll!",
            fontFamily = dmSansFontFamily,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = Color.Black,
        )
    }
}