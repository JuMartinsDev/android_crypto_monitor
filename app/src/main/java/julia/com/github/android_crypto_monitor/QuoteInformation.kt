package julia.com.github.android_crypto_monitor

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import julia.com.github.android_crypto_monitor.R

@Composable
fun QuoteInformation(value: String, date: String, onRefresh: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.label_rate),
            fontSize = 20.sp
        )
        Text(
            text = value,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = date)
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onRefresh,
            colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.success))
        ) {
            Text(
                text = stringResource(R.string.label_refresh),
                color = colorResource(R.color.white)
            )
        }
    }
}
