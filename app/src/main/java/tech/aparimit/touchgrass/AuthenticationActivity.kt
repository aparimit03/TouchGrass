package tech.aparimit.touchgrass

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.exceptions.HttpRequestException
import io.github.jan.supabase.exceptions.RestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import tech.aparimit.touchgrass.Keys.SUPABASE_API_KEY
import tech.aparimit.touchgrass.Keys.SUPABASE_PROJECT_URL
import tech.aparimit.touchgrass.screens.auth.AuthenticationScreen

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