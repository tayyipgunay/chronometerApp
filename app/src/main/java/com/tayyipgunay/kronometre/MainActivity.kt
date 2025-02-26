package com.tayyipgunay.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.tayyipgunay.kronometre.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var mainHandler: Handler
    private lateinit var runnable: Runnable
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ana thread üzerinde işlemleri zamanlamak için Handler kullanılıyor
        mainHandler = Handler(Looper.getMainLooper())

        // UI bileşenlerinin başlangıç durumu
        binding.baslatbuttonid.isEnabled = true  // Başlat butonu aktif
        binding.durdurbuttonid.isEnabled = false // Durdur butonu pasif
        binding.duraklatbuttonid.isEnabled = false // Duraklat butonu pasif

        // Butonlara click listener eklenerek işlevler atanıyor
        binding.baslatbuttonid.setOnClickListener {
            baslat(it)
        }
        binding.durdurbuttonid.setOnClickListener {
            durdur(it)
        }
        binding.duraklatbuttonid.setOnClickListener {
            duraklat(it)
        }
    }

    fun baslat(view: View) {
        // Runnable oluşturularak her 1 saniyede bir sayaç güncelleniyor
        runnable = object : Runnable {
            override fun run() {
                number++ // Sayaç artırılıyor
                binding.TimeTextView.text = "time: $number" // UI güncelleniyor
                mainHandler.postDelayed(this, 1000) // Runnable her 1 saniyede bir tekrar çalıştırılıyor
            }
        }

        // Runnable başlatılıyor
        mainHandler.post(runnable)

        // UI bileşenleri güncelleniyor
        binding.baslatbuttonid.isEnabled = false // Başlat butonu devre dışı
        binding.durdurbuttonid.isEnabled = true  // Durdur butonu aktif
        binding.duraklatbuttonid.isEnabled = true // Duraklat butonu aktif
    }

    fun durdur(view: View) {
        mainHandler.removeCallbacks(runnable) // Çalışan Runnable kaldırılıyor
        number = 0 // Sayaç sıfırlanıyor
        binding.TimeTextView.text = "time: $number" // UI güncelleniyor

        // UI bileşenleri güncelleniyor
        binding.baslatbuttonid.isEnabled = true  // Başlat butonu aktif
        binding.durdurbuttonid.isEnabled = false // Durdur butonu pasif
        binding.duraklatbuttonid.isEnabled = false // Duraklat butonu pasif
    }

    fun duraklat(view: View) {
        mainHandler.removeCallbacks(runnable) // Çalışan Runnable kaldırılıyor (duraklatılıyor)

        // UI bileşenleri güncelleniyor
        binding.baslatbuttonid.isEnabled = true  // Başlat butonu tekrar aktif
        binding.duraklatbuttonid.isEnabled = false // Duraklat butonu pasif
    }
}
