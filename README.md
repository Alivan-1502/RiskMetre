# RiskMetre

Kotlin ve Jetpack Compose kullanılarak geliştirilen bu uygulama, kurumsal güvenlik altyapıları için tasarlanmış bir protokol yönetim ve acil durum yönlendirme sistemidir.

## Proje Mantığı ve Kullanım Alanları

RiskMetre; okul, şirket, fabrika ve kamu kurumları gibi yüksek güvenlik gerektiren alanlarda, mevcut güvenlik sistemleriyle entegre çalışmak üzere kurgulanmıştır. Uygulamanın temel amacı, sistemden gelen herhangi bir alarm veya teknik sorun durumunda (Siber saldırı, yangın, sızıntı vb.), personelin izlemesi gereken resmi protokolleri ve acil müdahale adımlarını anlık olarak sunmaktır.

Güvenlik sistemlerinden gelen verileri analiz ederek, operatörlere karmaşık kriz anlarında rehberlik eder ve hata payını minimize ederek en doğru yönlendirme önerilerini sağlar.

## Gelişim Süreci ve Versiyon Karşılaştırması

Uygulama, geliştirme sürecinde statik bir veri listesinden dinamik bir karar destek mekanizmasına evrilmiştir.

| Versiyon | Durum | Teknik Gelişim |
| :--- | :--- | :--- |
| **v1.0 (İlk Prototip)** | Tamamlandı | Temel `forEach` döngüsü ile statik liste görünümü ve risk mantığının kurulması. |
| **v1.1 (Entegre UI)** | Tamamlandı | `Card` hiyerarşisi, görsel derinlik ve risk skoruna göre dinamik protokol renklendirmesi. |

## Teknik Özellikler

Uygulamanın geliştirilmesinde modern Android teknolojileri ve yöntemleri kullanılmıştır:

* **State Management:** Kullanıcı seçimlerini ve sistemden gelen anlık durumları yönetmek için `remember` ve `mutableStateOf` yapıları kullanılmıştır.
* **Dinamik UI:** `when` blokları ve risk skorları kullanılarak, her senaryo için özelleştirilmiş görsel geribildirim ve renk kodlaması sağlanmıştır.
* **Material 3:** Modern ve kurumsal bir görünüm için Material Design 3 bileşenleri tercih edilmiştir.
