package com.example.riskmetre

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.riskmetre.ui.theme.RiskMetreTheme

data class Senaryo(val baslik: String, val riskSkoru: Int, val oneri: String)
val senaryolar = listOf(
    Senaryo("Siber Saldırı", 90,"Ağı İzole Et"),
    Senaryo("Yangın Tehlikesi", 72,"Tahliye Protokolünü Başlat"),
    Senaryo("Veri Hırsızlığı ve Casusluk Tespiti", 80,"Güvenlik Protokolünü Başlat"),
    Senaryo("Güç Kesintisi", 60, "Jeneratörü Kontrol et"),
    Senaryo("İnternet Arızası", 30, "Servis Sağlayıcısına Bildir"),
    Senaryo("Klima Arızası", 10, "Teknik Servise Bildir")
)
fun riskLevel(skor:Int): String{
    return when{
        skor>= 70 -> "YÜKSEK"
        skor>= 40 -> "ORTA"
        else -> "DÜŞÜK"
    }
}
fun riskRengi(skor: Int): Color{
    return when{
        skor >= 70 -> Color.Red
        skor >= 40 -> Color(0xFFFFA500)
        else -> Color.Green
    }
}
@Composable
fun RiskEkranı(){
    var seciliSenaryo by remember{mutableStateOf<Senaryo?>(null)}

    Column(modifier= Modifier.fillMaxSize().padding(16.dp)){
        senaryolar.forEach { senaryo ->
            Card(
                modifier= Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .clickable{seciliSenaryo=senaryo}
            ) {
                Text(
                    text = senaryo.baslik,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        seciliSenaryo?.let { senaryo ->
            Text("Seçilen: ${senaryo.baslik}")
            Text("Risk Skoru: ${senaryo.riskSkoru}")

            Text(
                text = "Risk Seviyesi: ${riskLevel(senaryo.riskSkoru)}",
                color = riskRengi(senaryo.riskSkoru)
            )
            Text("Öneri: ${senaryo.oneri}")
        }
    }

}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RiskMetreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {padding ->
                    Box(modifier = Modifier.padding(padding)){
                        RiskEkranı()
                    }
                }

            }
        }
    }
}
