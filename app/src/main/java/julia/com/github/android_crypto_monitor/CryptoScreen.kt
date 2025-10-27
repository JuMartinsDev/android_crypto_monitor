import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import julia.com.github.android_crypto_monitor.QuoteInformation
import julia.com.github.android_crypto_monitor.R
import julia.com.github.android_crypto_monitor.ToolbarMain
import julia.com.github.android_crypto_monitor.service.MercadoBitcoinServiceFactory
import kotlinx.coroutines.launch
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun CryptoScreen() {
    // pegar resources fora do remember (chamadas composable fora do cálculo do remember)
    val initialValue = stringResource(R.string.label_value)
    val initialDate = stringResource(R.string.label_date)

    var value by remember { mutableStateOf(initialValue) }
    var date by remember { mutableStateOf(initialDate) }
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize()) {
        ToolbarMain()
        Spacer(modifier = Modifier.height(16.dp))
        QuoteInformation(value, date) {
            scope.launch {
                try {
                    val service = MercadoBitcoinServiceFactory().create()
                    val response = service.getTicker()
                    if (response.isSuccessful) {
                        response.body()?.ticker?.last?.toDoubleOrNull()?.let {
                            val numberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "BR"))
                            value = numberFormat.format(it)
                        }
                        response.body()?.ticker?.date?.let {
                            val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
                            sdf.timeZone = java.util.TimeZone.getTimeZone("America/Sao_Paulo")
                            date = sdf.format(Date(it * 1000L))
                        }

                    } else {
                        Toast.makeText(context, "Erro: ${response.code()}", Toast.LENGTH_LONG).show()
                    }
                } catch (e: Exception) {
                    Toast.makeText(context, "Falha: ${e.message}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
