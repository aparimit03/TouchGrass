package tech.aparimit.touchgrass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Text("Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!" +
                    "\n" +
                    "Hello, World!"
            )
        }
    }
}