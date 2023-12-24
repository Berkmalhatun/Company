
# Challenge Soru 6

Proje Java 17 ile yazılmıştır. Spring Boot, Lombok, Openapi, Mapstruct teknolojileri kullanılıp MVC mimarisinde yazılmıştır. Veritabanı olarak PostgreSQL kullanılmıştır.


## Proje Yapısı

- `Entity`: Veritabanı tablolarımızı temsil eden `Company` ve `Employee` sınıflarını içerir. `Employee` sınıfı içindeki `companyid` alanı, bir çalışanın ait olduğu firmayı belirtir ve bu şekilde iki model arasında ilişki kurulur.
- `View`: Kullanıcı arayüzünü oluşturan kısımdır. Bu proje için API üzerinden CRUD işlemleri yapıldığından, Swagger-ui tercih edilmiştir.
- `Controller`: Kullanıcı isteklerini karşılayan ve uygun `Model` verilerini `View` ile ilişkilendiren sınıfları içerir. Bu proje için `CompanyController` ve `EmployeeController` sınıfları, HTTP isteklerini karşılayıp işler ve JSON cevaplarını döndürür.
- `Repository`: Veritabanı işlemlerini soyutlayan JPA repository'lerini içerir. `CompanyRepository` ve `EmployeeRepository` Spring Data JPA'nın sunduğu `JpaRepository` arayüzünü genişleterek CRUD operasyonlarına erişim sağlar.
-  `Service`: İş mantığını bu katmanda kuruldu.. `CompanyService` ve `EmployeeService`, controller ile repository arasında bir köprü görevi görür ve iş mantığını yönetir.
## Temel Özellikler

- Firma ve çalışanlar için CRUD işlemleri.
- RESTful API aracılığıyla veri işlemleri.
- Firma ve çalışan arasındaki ilişkisel bütünlüğün korunması.
## PostgreSQL Veritabanı Yapılandırması

Bu proje, verileri saklamak için PostgreSQL kullanmaktadır. Uygulamayı çalıştırmadan önce, yerel makinenizde PostgreSQL veritabanınızı aşağıdaki adımları izleyerek ayarlayın:

1. **PostgreSQL Kurulumu**: PostgreSQL'i resmi web sitesinden indirin ve kurun: [PostgreSQL Download](https://www.postgresql.org/download/).

2. **Veritabanı Oluşturma**: PostgreSQL veritabanınızda `Company` adında bir veritabanı oluşturun. Bunu yapmak için PostgreSQL komut satırını kullanabilir veya grafik arayüz aracı olan pgAdmin'i kullanabilirsiniz.
# Servis Katmanı Kullanımı
## CompanyService
`CompanyService` sınıfı, firma ile ilgili işlemleri yönetir. Aşağıda bu servisin sağladığı temel metodlar ve kullanım örnekleri yer almaktadır.
### Firma Oluşturma: `create(CreateCompanyRequestDto dto)`
Yeni bir firma oluşturmak için create metodu kullanılır. Eğer aynı isimde bir firma zaten varsa, bir IllegalStateException fırlatılır.
### Firma Silme : `deleteCompany(Long id)`
Bir firma silmek için deleteCompany metodu kullanılır. Eğer firma bulunamazsa veya zaten silinmişse EntityNotFoundException fırlatılır.
### Firma Güncelleme : `updateCompany(UpdateCompanyRequestDto dto)`
Bir firmayı güncellemek için updateCompany metodu kullanılır. Eğer firma bulunamazsa veya  silinmişse EntityNotFoundException fırlatılır.
### Firma Listesi : `getAll`
Veritabanında kayıtlı olan tüm firmalar listelenir.
## EmployeeService
`EmployeeService` sınıfı, çalışanlar ile ilgili işlemleri yönetir. Bu servisin sağladığı temel metodlar ve kullanım örnekleri aşağıda yer almaktadır.
### Çalışan Kaydetme: `registerEmployee(RegisterEmployeeRequestDto dto)`
Yeni bir çalışan kaydetmek için registerEmployee metodu kullanılır. Eğer çalışanın ait olacağı firma bulunamazsa EntityNotFoundException fırlatılır.
### Çalışan Silme: `deleteEmployee(Long id)`
Bir çalışanı silmek için deleteEmployee metodu kullanılır. Eğer çalışan bulunamazsa veya zaten silinmişse EntityNotFoundException fırlatılır.
### Çalışan Güncelleme: `updateEmployee(UpdateEmployeeRequestDto dto)`
Bir çalışanı güncellemek için updateEmployee metodu kullanılır. Eğer çalışan veya çalışanın ait olacağı firma bulunamazsa veya silinmişse EntityNotFoundException fırlatılır.
### Çalışan Listesi : `getAll`
Veritabanında kayıtlı olan tüm çalışanlar listelenir.
## Proje Nasıl Klonlanır?

1. Bilgisayarınızda Git'in yüklü olması gerekmektedir.

2. Komut istemcisini açın.

3. Projeyi klonlamak istediğiniz dizine gidin, aşağıdaki komutu istemcinize yazın.


```bash 
git clone https://github.com/Berkmalhatun/Company
```
4. Kullanmış olduğunuz IDE'yi açın  
5. Klonlamış olduğunuz dosyayı IDE üzerinden açın.
6. Dosya açıldığında bağımlılıklar yüklenene kadar bekleyin.
7. CompanyApplication'a sağ tıklayıp Run diyerek çalıştırabilirsiniz.## API Dokümantasyonu ve Test Etme

Bu projede, API endpoint'lerinin dokümantasyonu ve test edilmesi için [Swagger UI](http://localhost:8085/swagger-ui/index.html) kullanılmaktadır. Swagger UI, RESTful API'lerinizi kolayca keşfetmenize, kullanmanıza ve test etmenize olanak tanıyan interaktif bir arayüzdür.

### Swagger UI ile API'leri Test Etme

1. Uygulamayı yerel sunucunuzda başlatın.

2. Tarayıcınızda `http://localhost:8085/swagger-ui/index.html` adresine gidin. Bu, otomatik olarak Swagger UI'nın yüklendiği sayfaya sizi yönlendirecektir.

3. Swagger UI sayfasında, mevcut tüm API endpoint'leri ve bu endpoint'lere ait detaylı bilgiler listelenecektir.

4. Her bir endpoint'in yanında yer alan `Try it out` butonuna tıklayarak istekleri doğrudan Swagger UI üzerinden gönderebilirsiniz.

5. İstek parametrelerini girin ve `Execute` butonuna tıklayarak API isteğini gönderin.

6. Swagger UI, isteğinize bağlı olarak sunucunuzdan gelen yanıtı gösterecektir. Bu, API'nizin geri dönüş değerlerini ve HTTP durum kodlarını içerir.

---
## Son
Bu projeyi incelediğiniz ve zaman ayırdığınız için teşekkür ederim.
