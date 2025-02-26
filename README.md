# Kronometre Uygulaması

Bu proje, Android için geliştirilmiş basit bir kronometre uygulamasıdır. Kullanıcılar kronometreyi başlatabilir, durdurabilir ve duraklatabilir.

## Özellikler
- **Başlat:** Kronometreyi çalıştırır ve her saniye ekranda güncellenen bir sayaç başlatır.
- **Duraklat:** Sayaç ilerlemeye devam etmeden duraklatılır.
- **Durdur:** Sayaç sıfırlanır ve durdurulur.

## Kullanılan Teknolojiler
- **Kotlin:** Ana programlama dili olarak kullanılmıştır.
- **Android Handler:** UI thread ile arka plan işlemlerinin kontrol edilmesini sağlar.
- **Runnable:** Belirli bir süre aralıklarında çalışan sayaç mekanizmasını kontrol etmek için kullanılmıştır.

## Proje Yapısı

### Ana Bileşenler
- **MainActivity.kt:** Uygulamanın ana işleyişini kontrol eden sınıf.
- **activity_main.xml:** Kullanıcı arayüzü düzeni.
- **Handler ve Runnable:** Zamanlayıcı mekanizmasını yönetmek için kullanılmıştır.

### UI Bileşenleri
- **TextView (TimeTextView):** Geçen zamanı gösterir.
- **Button (Baslat, Durdur, Duraklat):** Kullanıcının sayaç işlemlerini kontrol etmesini sağlar.

## Kullanım
1. **Uygulamayı başlatın.**
2. **Başlat butonuna basın.** Sayaç çalışmaya başlayacaktır.
3. **Duraklat butonuna basarak sayacı geçici olarak durdurabilirsiniz.**
4. **Durdur butonuna basarak sayacı sıfırlayabilirsiniz.**

## Kurulum
1. **Projeyi klonlayın:**
   ```sh
   git clone https://github.com/kullaniciadi/KronometreApp.git
   ```
2. **Android Studio ile açın.**
3. **Cihaz veya emülatör seçerek çalıştırın.**

## Geliştirme Notları
- **Handler kullanımı:** `Handler(Looper.getMainLooper())` ile UI thread üzerinde çalıştırılmak üzere zamanlayıcı tanımlandı.
- **Runnable ile gecikme:** `mainHandler.postDelayed(runnable, 1000)` ile sayaç her saniyede bir güncellendi.
- **UI Etkileşimleri:** `Baslat.isEnabled = false`, `Duraklat.isEnabled = true` gibi ifadeler ile buton etkileşimleri yönetildi.

## Katkıda Bulunma
Projeye katkıda bulunmak için lütfen bir pull request oluşturun veya issue açın.

## Lisans
Bu proje MIT Lisansı ile lisanslanmıştır. Daha fazla bilgi için LICENSE dosyasına bakınız.

![image](https://github.com/user-attachments/assets/2b6da987-b65f-4cba-a9b9-06ecc7c6cfbc)
