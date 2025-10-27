package julia.com.github.android_crypto_monitor

import CryptoScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import julia.com.github.android_crypto_monitor.ui.theme.CryptoMonitorarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoMonitorarTheme {
                CryptoScreen()
            }
        }
    }
}
