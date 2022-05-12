# Sii - zadanie rekrutacyjne - stażysta Java.

sposób uruchomienia:
- Java minimum wersja 11,
- uruchomić specjalnie przygotowany plik jar poprzez komendę w terminalu: "java -jar ./jarFile/Sii_recruitment_task.jar",
aplikacja została uruchomiona na maszynie lokalnej.

instrukcja testowania:
- jest kilka sposobów na przetestowanie aplikacji:
  - narzędzie swagger poprzez link: "http://localhost:8080/swagger-ui.html
  
  - manualne wysyłanie requestów (np postman) na link "http://localhost:8080"


- W celu otrzymania listy wydarzeń należy wysłać zapytanie GET na link "http://localhost:8080/events",
- Aby zarejestrować użytkownika do wydarzenia należy w ścieżce podać id wydarzenia, przykładowy link: "http://localhost:8080/events/register/0ef6f984-98da-412d-9e09-9e95418f154a".
Poprzez metodę post na ten link wysłać należy niewielki obiekt, w którym zawarty będzie username oraz email.
- Wyświetlie listy prelekcji, na którą zapisał się uczestnik jest możliwe poprzez metodę POST wysłać w obiekcie nazwę użytkownika na link: "http://localhost:8080/events/myEvents".
- Użytkownik jest w stanie zrezygnować z udziału w prelekcji poprzez wysłanie metody DELETE wraz z obiektem zawierającym login użytkownika, natomiast w linku należy uwzględnić id eventu, na którym był zapisany np:"http://localhost:8080/events/0ef6f984-98da-412d-9e09-9e95418f154a"
- W celu zmiany adresu email użtkownik powinien poprzez metodę PUT wysłać obiekt zawierający login, aktualny email oraz nowy email na adress: "http://localhost:8080/user/changeEmail"
- Organizator jest w stanie wygenerować 2 Listy zawieracjące zestawienie procentowe zainteresowania tematami lub poszczególnym wykładem należy wysłać zapytanie GET na link
  - poszczególnych wykładów: "http://localhost:8080/events/lectureInterest"
  - tematów: "http://localhost:8080/events/subjectInterest"
