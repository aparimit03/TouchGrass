package tech.aparimit.touchgrass

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonObjectBuilder
import kotlinx.serialization.json.buildJsonObject
import org.json.JSONObject
import tech.aparimit.touchgrass.Dotenv.SUPABASE_API_KEY
import tech.aparimit.touchgrass.Dotenv.SUPABASE_PROJECT_URL
import tech.aparimit.touchgrass.screens.auth.AuthenticationScreen
import tech.aparimit.touchgrass.ui.theme.sand

class AuthenticationActivity : ComponentActivity() {
    private lateinit var supabase : SupabaseClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuthenticationScreen()
        }
    }
}

val supabase = createSupabaseClient(
    supabaseUrl = SUPABASE_PROJECT_URL,
    supabaseKey = SUPABASE_API_KEY,
) {
    install(Auth)
}

suspend fun loginWithEmailAndPassword(email: String, password: String) {
    try {
        supabase.auth.signInWith(Email) {
            this.email = email
            this.password = password
        }
    }
    catch (e: HttpRequestException) {
        Log.d("Aparimit HttpRequestException", "Error: ${e.message}")
    }
    catch (e: HttpRequestTimeoutException) {
        Log.d("Aparimit HttpRequestTimeoutException", "Error: ${e.message}")
    }
    catch (e: RestException) {
        Log.d("Aparimit RestException", "Error: ${e.message}")
    }
}

suspend fun signupWithEmailAndPassword(email: String, password: String) {
    try {
        supabase.auth.signUpWith(Email) {
            this.email = email
            this.password = password
        }
    }
    catch (e: HttpRequestException) {
        Log.d("Aparimit HttpRequestException", "Error: ${e.message}")
    }
    catch (e: HttpRequestTimeoutException) {
        Log.d("Aparimit HttpRequestTimeoutException", "Error: ${e.message}")
    }
    catch (e: RestException) {
        Log.d("Aparimit RestException", "Error: ${e.message}")
    }
}