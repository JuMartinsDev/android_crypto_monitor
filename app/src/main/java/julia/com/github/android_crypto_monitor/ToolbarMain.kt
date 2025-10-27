package julia.com.github.android_crypto_monitor

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import julia.com.github.android_crypto_monitor.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolbarMain() {
    TopAppBar(
        title = {
            Text(
                text = stringResource(R.string.app_title),
                color = colorResource(R.color.white)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(R.color.primary))
    )
}
