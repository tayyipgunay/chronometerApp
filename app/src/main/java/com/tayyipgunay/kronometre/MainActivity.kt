package com.tayyipgunay.kronometre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.concurrent.thread


private lateinit var Baslat:Button
private lateinit var Durdur:Button
private lateinit var Duraklat:Button
private lateinit var TimeTextView: TextView
var number=0
var durum=false
private lateinit var runnable:Runnable
private lateinit var handlerThread: HandlerThread//sanalThread
private lateinit var mainHandler: Handler//Android'de Handler sınıfı,
// bir thread'in bir diğer thread ile iletişim kurmasını ve bir thread'den gelen mesajları
// veya çalıştırılabilir (runnable) görevleri işleyebilmesini sağlar. Handler sınıfı, özellikle UI thread'i ile arka plan thread'leri arasında
// veri alışverişi ve görevlerin zamanlanması için kullanılır. İşte Handler sınıfının başlıca işlevleri:
private lateinit var handlerthread:Handler

private var isRunning = false





//var handler:Handler=Handler(Looper.getMainLooper())


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Baslat = findViewById(R.id.button)
        Durdur = findViewById(R.id.button2)
        TimeTextView = findViewById(R.id.TimeTextView)
        Duraklat=findViewById(R.id.button3)
        runnable=Runnable{

        }
        mainHandler=Handler(Looper.getMainLooper())//ana iş parçacığını kontrol ediyor.
    }
      fun Baslat(view: View) {

          runnable = object : Runnable {
              override fun run() {
                  number = number + 1
                  TimeTextView.text = "time: $number"
                  mainHandler.postDelayed(runnable, 1000)//gecikme
                 /* Runnable, arka planda yapılacak işlerin tanımlanmasında kullanılır. Bu iş parçacığı oluşturma mekanizmasının daha basit bir yoludur. Örneğin,
                  kullanıcı arayüzünü (UI) tıkamadan arka planda bir görev çalıştırmak istediğinizde Runnable kullanabilirsiniz.*/
              }

          }
         /* runnable=Runnable{
              number = number + 1
              TimeTextView.text = "time: $number"
              mainHandler.postDelayed(runnable, 1000)// Runnable'ı 1 saniye gecikme ile yeniden çalıştır
          }*/

          mainHandler.post(runnable)// runnable başlat.
          Baslat.isEnabled=false
          Duraklat.isEnabled=true
          Durdur.isEnabled=true
        /*  Runnable'ı başlatmak için onu mainHandler (veya bir iş parçacığı) ile ilişkilendirmen gerekiyor.
       mainHandler.post(runnable) satırı, bu ilişkiyi kurar ve görevini sıraya alarak çalıştırır.
       Bu satır olmadan, tanımlanan Runnable çalışmaz ve sayaç artmaz.*/

          /*Handler: Bu görevin (Runnable'ın)
          belirli bir iş parçacığında çalıştırılmasını ve zamanlanmasını sağlar. Ayrıca, gecikmeli çalıştırmayı (her 1 saniyede bir) mümkün kılar.*/







      }

      fun Durdur(view: View) {
          Duraklat.isEnabled=false
          Baslat.isEnabled=true
          number=0
          TimeTextView.text="time:$number"
          mainHandler.removeCallbacks(runnable)

      }
    fun Duraklat(view: View){
        Durdur.isEnabled=false
        mainHandler.removeCallbacks(runnable)
        Baslat.isEnabled=true


    }
  }



