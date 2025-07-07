# 📚 Challenge: The Great Book Repository 🧠🔍

Welcome to the _most delightfully **over-engineered**_ console app you'll ever see! 😎

Welcome, brave developer, time traveler, or weary recruiter 👩‍💻👨‍💼 — you've stumbled upon a _heavily over-engineered_ Java CLI application that does one thing and does it **relentlessly well**:

> This is a **Java 21 + Spring Boot** CLI application that **fetches, persists, and queries a collection of classic books... all while flexing every backend muscle imaginable.** 💪

This isn’t just a simple "read some JSON and print it" type of exercise. No. This is _**Spring Boot meets REST API meets PostgreSQL meets Docker meets CI/CD**_... all wrapped up in a beautiful, verbose, console-based user interface. It's **enterprise backend meets artisanal command line**.

---

## 🧠 TL;DR (For Recruiters With Only 30 Seconds)

| What It Does           | How                                                                                                        |
| ---------------------- | ---------------------------------------------------------------------------------------------------------- |
| ☁️ Calls a REST API    | Gutendex API (https://gutendex.com)                                                                        |
| 🔄 Maps JSON to Java   | Using DTOs and custom mappers                                                                              |
| 🗃️ Persists data       | Spring Data JPA + PostgreSQL                                                                               |
| 💻 CLI UX              | Powered by `CommandLineRunner`                                                                             |
| 📦 Dockerized          | Fully containerized app + DB                                                                               |
| ⚙️ GitHub Actions      | Build, test & deploy CI/CD pipeline                                                                        |
| ✅ Error handling      | Clean, centralized, & logged                                                                               |
| 🔥 Recruiter hot words | ✅ SOLID, ✅ decoupled layers, ✅ DTOs, ✅ dependency injection, ✅ reusable services, ✅ clean arch vibes |

---
## 🎯 The Challenge (As Given)

You’ve got a mission, Agent Java. Complete the following using Spring Boot & friends:

### ✅ Implement an HTTP Request
- Interact with the Gutendex REST API to retrieve book data.
- Bonus points if you don’t panic with `HttpClient`. 😬

### ✅ Map / Convert JSON to Java
- Turn JSON into useful `DTO` objects using Jackson.
- You’ll be friends with `@JsonProperty` and `@JsonIgnoreProperties`.

### ✅ Persist with PostgresSQL using Spring Data JPA
- Store books, authors, and languages.
- Avoid duplicates like the plague.

### ✅ Interact With the User (CLI-style, baby!)
- Implement `CommandLineRunner` and override `run()`.
- Provide real-time feedback and errors (nicely).

---

## 💻 Functionalities (a.k.a. How the Magic Happens)

🟡 **Important:** The _first option_ fetches data **live from the API**, all others work with **locally saved data**.

1. 🔍 **Search book by title**

   - Pulls results from Gutendex.
   - Saves new books to the DB (skipping duplicates).
   - Displays: `Title`, `Authors`, `Languages`, and `Download Count`.

2. 📚 **List all saved books**

   - Displays all persisted books with full details.

   Because knowledge is power. And because you already saved them — so now let’s humble-brag about them in the console.


3. 👨‍💼 **List all registered authors**

You’ll display:

 - `Name`
 - `Birth date`
 - `Death date` (_RIP_)
 - Their books (because authoring is their thing)

4. 👻 **List authors alive in a given year**

   - Ask the user for a year.  
   - Then query the DB for all authors who were _still breathing_ during that year.

   It’s morbid. It’s educational. It’s... beautifully SQL.

5. 🌍 **List books by language**

   - Select a language code (`en`, `es`, `fr`, `pt`, etc.)
   - Get all books saved in that language.

6. 🛑 **Exit the app**

   - There’s an option to exit.  
   _It does what it says_.  
   
   Sometimes, less is more.
   
   Because life goes on.

---

## 🧪 What's Under the Hood (Technical Goodies)

Let’s talk about what makes this app **tick** — because under its retro console interface lies a **clean, modern architecture** that screams _“I’m hireable!”_ 🔊

### 💉 Decoupling via Dependency Injection

Every service, mapper, and runner is injected using Spring Boot’s IoC container. No static mess. Just clean constructor injection.

- `BooksService`, `AuthorsService`, and `HttpService` keep things **clean, testable, and SRP-compliant**.
- Even the menu and input handling are handled via separate classes.

### 🧠 Smart Mapping

- Custom `BookMapper` transforms API DTOs into rich JPA entities.
- Also handles `Language` creation via a helper service — avoiding ugly duplicate logic.

### 🔄 Entity Relationships

- Rich data model:
   - `Book <-> Author`: Many-to-Many
   - `Book <-> Language`: Many-to-Many
- Clean JPA with explicit join tables.
- Eager fetching where needed for fast CLI output.

### 🛠️ Manual Dependency Injection Support

- Uses `@Service`, `@Component`, `@Autowired`, and `@Value` for seamless Spring Boot wiring.

### 💾 PostgreSQL Support

- Ready to persist real book data.
- Can be easily extended with Flyway (already scaffolded before removal).

### 🗂️ Layered Architecture

- **DTO Layer**: Isolates API contracts.
- **Mapper Layer**: Converts DTOs to JPA entities (with bonus logic like bidirectional `Author <-> Book` associations).
- **Service Layer**: Handles business logic & persistence.
- **Repository Layer**: Spring Data JPA with custom queries (`findByLanguageCode`, etc.).
- **Presentation Layer**: Beautifully retro CLI with runtime menus, input validation, and error formatting.

### 🧰 Error Handling Like a Pro

Custom exceptions (e.g., `MenuOptionOutOfBoundsException`) and fallback handling ensure the user experience stays smooth — even when users type weird stuff. 😬

### 🧼 Console Output Done Right

- Fully centralized in a custom `ConsolePrinter` utility.
- Separation of logic and presentation? ✅

### 🧪 Testing & CI

- Includes **unit tests** using JUnit.
- Custom exception (`MenuOptionOutOfBoundsException`) is tested.
- 💥 **GitHub Actions** workflow runs tests automatically on every push.

### 🐳 Dockerized to the Teeth

Spin it all up in containers:

- ✅ Spring Boot App
- ✅ PostgreSQL DB
- ✅ Preloaded data (if you want it)
  > All in a single `docker compose up` away from greatness.

### ⚙️ CI/CD via GitHub Actions

- Automated build with every push
- Run tests
  > Because your code doesn’t truly exist until a robot yells "✅ Build Passed".

---

## 🚀 Running the Project

### 💻 Requirements

- Java 17+
- Maven
- Docker + Docker Compose
- A strong desire to press `1` and search for books about dragons 🐉

---

### 🧪 Start with Tests

Because we write code we can trust:

```bash
./mvnw test
```

---

### 🐳 Run with Docker

```bash
docker compose up --build
```

This launches:

- Spring Boot app (CLI-enabled)
- PostgreSQL database
- Pre-populated books, if enabled via profile

---

### 🔍 CLI Interaction

Once running, you’ll be greeted with a vintage menu that looks like this:

```
##############################################
1: Search book by title.
2: List registered books.
3: List registered authors.
4: List alive authors in a given year.
5: List books by language.
6: EXIT.
##############################################
```

It’s just like the 90s, but with Docker and REST. 😎

---

## 🏆 Technical Highlights & Recruiter Gold 💼✨

### ✅ Uses real HTTP API

Connects to **Gutendex**, a REST API for Project Gutenberg. Parses real data with pagination, mapping, filtering, and conversion to entities.

### ✅ Clean Architecture

- **No controller spaghetti**
- Fully testable layers
- Low coupling, high cohesion

> Yes, we read Uncle Bob. 👴

### ✅ GitHub Actions CI/CD

Automated build, test, and deploy pipeline to ensure **no broken builds** sneak in. A recruiter’s dream, a dev’s security blanket. 🛡️

### ✅ Docker-First Thinking

Runs in a container. Develops in a container. Even dreams in YAML.

> _“I don’t always use `docker compose`, but when I do... I bind ports like a boss.”_

### ✅ Java 21 + Spring Boot 3

Because modern Java is expressive, powerful, and has **records**, baby. ✨

### ✅ Fluent UX (for a console app)

Includes:

- Menu loop with options
- Input validation
- Re-attempts on error
- Friendly messages & formatting

---

## 🎁 Bonus Features

Because we care. 🥹

- ✅ Language filter menu (with country code reference table)
- ✅ Pre-populate DB on boot via CLI profile
- ✅ Colorless but **tactfully formatted** console UI
- ✅ Robust error messages
- ✅ JPA relationships that respect referential integrity 🙏

---

## 📌 Technologies Used

| Stack           | Version |
| --------------- | ------- |
| Java            | 21      |
| Spring Boot     | 3.x     |
| Maven           | 💎      |
| PostgresSQL     | 🐘      |
| Docker          | 🐳      |
| Jackson         | ✅      |
| JPA / Hibernate | 🧠      |
| GitHub Actions  | 🛠️      |

---

## 🤝 Final Words for Recruiters

This project was crafted with the express purpose of **flexing backend skills in a contained, testable, and production-friendly way**.

It's a living example of how even a silly little CLI app can demonstrate:

- ✅ API integration 🔌
- ✅ Persistence mastery 🗃️
- ✅ Clean separation of concerns
- ✅ Decoupled design patterns 🧱
- ✅ Clean error handling 🚨
- ✅ Modern Java best practices
- ✅ Spring Boot configuration fluency
- ✅ Test writing 🧪
- ✅ GitOps and DevOps CI/CD practices ⚙️
- ✅ **And above all — a touch of humor.** 😎

---

## 💡 Bonus: Why This Project Rocks (from a recruiter's POV)

| Quality               | Evidence                                              |
| --------------------- | ----------------------------------------------------- |
| **Testability**       | Modular services + Unit test + GitHub Actions         |
| **Clean Design**      | SRP, DI, DTOs, Mappers, and Utils                     |
| **Real-world Tech**   | REST API integration + JPA + PostgreSQL               |
| **Modern Java**       | Java 21 features, Maven, Profiles, Exception handling |
| **Developer Empathy** | CLI experience with friendly UX and error messages    |

````


## 👋 Ready to Search Some Books?

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=cli
````

Or be cool and let Docker do it.
