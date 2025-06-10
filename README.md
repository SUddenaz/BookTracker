# 📚 BookTracker – Kitap Takip Uygulaması

Java Spring Boot ile geliştirilmiş bir RESTful API uygulamasıdır. Kullanıcıların kitap ekleyebildiği, listeleyebildiği, arama yapabildiği ve kitapları okundu olarak işaretleyebildiği basit bir kitap takip sistemidir.

## 🧠 Kullanılan Java Konuları

Bu proje aşağıdaki konuları örneklemektedir:

| Konu No | Konu Başlığı                                  | Kullanım Açıklaması |
|---------|-----------------------------------------------|---------------------|
| 1       | Temel Java                                     | OOP, sınıflar, metotlar, koleksiyonlar |
| 3       | Java 8 Stream API                              | Kitap arama fonksiyonu `stream().filter()` ile |
| 5       | Kalıtım ve Veri Yapıları (OOP)                 | Katmanlı yapı: Model, Repository, Service, Controller |
| 6       | Sıralama Algoritması                           | Bubble sort ile başlığa göre sıralama |
| 7       | Generic Programlama                            | `ResponseWrapper<T>` sınıfı |
| 8       | Multithreading                                 | Kitap ekleme işlemi ayrı bir thread ile yapılır |
| 9       | Veritabanı Bağlantısı (H2)                     | `application.properties` ile entegre edilmiş H2 database |
| 10      | J2EE – Spring Boot                             | REST API yapısı |
| 11      | Web Programlama (API)                          | `@RestController`, `@RequestBody`, `@GetMapping`, vb. |
| 12      | Popüler Framework: Spring Boot + Maven         | Proje Maven ile yapılandırılmıştır |

---

## 🔧 Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Maven
- H2 In-Memory Database
- Postman (test için)
- Git & GitHub

---

## 📦 API Endpoint’leri

| Metot | URL                      | Açıklama                         |
|-------|--------------------------|----------------------------------|
| POST  | `/books`                 | Yeni kitap ekler                 |
| GET   | `/books`                 | Tüm kitapları listeler (başlığa göre sıralı) |
| GET   | `/books/search?keyword=` | Başlığa/yazara göre arama yapar |
| PUT   | `/books/{id}/read`       | Kitabı okundu olarak işaretler  |
| DELETE| `/books/{id}`            | Kitabı siler                     |

### ✅ Örnek JSON (POST /books)
```json
{
  "title": "Deneme Kitap",
  "author": "sude Yazar"
}
