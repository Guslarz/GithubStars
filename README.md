# GithubStars
## Opis
Aplikacja serwerowa w języku Java oparta o framework Spring Boot pozwalająca na:
- listowanie repozytoriów (nazwa i liczba gwiazdek)
- zwracanie sumy gwiazdek we wszystkich repozytoriach

dla dowolnego użytkownika serwisu GitHub.

## Instalacja i uruchomienie
Aby uruchomić aplikację należy ją uprzednio pobrać z tego repozytorium, 
skompilować przy użyciu oprogramowania Maven i uruchomić wynikowy plik JAR, np.:
```shell script
> git clone https://github.com/Guslarz/GithubStars.git
> cd GithubStars
> mvn install
> java -jar target/github-stars-0.0.1-SNAPSHOT.jar
```
Serwer uruchomi się na porcie 8080.

## API
Lista repozytoriów - `GET /user/{username}/list`

Suma gwiazdek - `GET /user/{username}/total`

Oba endpointy posiadają parametr `username`, oznaczający nazwę użytkownika 
serwisu GitHub, którego listę repozytoriów/sumę gwiazdek chcemy pobrać.
Można to zrobić np. poprzez użycie narzędzia cURL:
```shell script
> curl localhost:8080/user/Guslarz/list
```
Odpowiedź jest w formacie JSON.

## Propozycje rozwoju
- Autentykacja zapytań do GitHub API w celu zwiększenia limitu zapytań na godzinę
- Paginacja listy repozytoriów w celu wydajniejszej obsługi użytkowników z dużą liczbą
repozytoriów (wymagania zrozumiałem jako wyświetlanie całej listy, więc paginacji brak)
- Więcej danych, np.:
    - opis i url repozytorium w liście
    - liczba forków - dla poszczególnych repozytoriów i suma
    - zliczanie liczby projektów w poszczególnych językach
    - dodatkowe informacje w odpowiedzi - nazwa użytkownika z zapytania, kod odpowiedzi itd.
- Te same dane ale dla repozytoriów wyszukanych przez endpoint `GET /search/repositories` GitHub API
- Lepsza obsługa błędów - informacja co poszło nie tak
- Interfejs graficzny, np. aplikacja internetowa lub mobilna 
- Dodanie loggera
- Dodanie testów
