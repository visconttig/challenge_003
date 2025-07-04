# 📚 Spring Boot Console Book Explorer 🚀

Welcome to the *most delightfully over-engineered* console app you'll ever see! 😎  
This is a **Java 21 + Spring Boot** CLI application that allows users to **search, store, and explore public domain books** from [Gutendex](https://gutendex.com), manage a clean PostgreSQL database, and marvel at their own data-fetching powers 💡.

---

## 🎯 The Challenge (a.k.a. Instructions for the Brave)

You’ve got a mission, Agent Java. Complete the following using Spring Boot & friends:

### ✅ Implement an HTTP Request
- Interact with the Gutendex REST API to retrieve book data.  
- Bonus points if you don’t panic with `HttpClient`. 😬

### ✅ Map / Convert JSON to Java
- Turn JSON into useful `DTO` objects using Jackson.
- You’ll be friends with `@JsonProperty` and `@JsonIgnoreProperties`.

### ✅ Persist with PostgreSQL using Spring Data JPA
- Store books, authors, and languages.  
- Avoid duplicates like the plague.  
- Use relationships like `@ManyToMany`, because we love clean domain modeling.

### ✅ Interact With the User (CLI-style, baby!)
- Implement `CommandLineRunner` and override `run()`.  
- Build an interactive **menu loop** using our custom `Menu` class.  
- Provide real-time feedback and errors (nicely).

---

## 💻 Functionalities (a.k.a. How the Magic Happens)

🟡 **Important:** The *first option* fetches data **live from the API**, all others work with **locally saved data**.

1. 🔍 **Search book by title**  
   - Pulls results from Gutendex.
   - Saves new books to the DB (skipping duplicates).
   - Displays: `Title`, `Authors`, `Languages`, and `Download Count`.

2. 📚 **List all saved books**  
   - Displays all persisted books with full details.

3. 👨‍💼 **List all authors**  
   - Shows: `Name`, `Birth Year`, `Death Year`, and `Books written`.

4. 👻 **List authors alive in a given year**  
   - Enter a year, get back authors who were still breathing then.

5. 🌍 **List books by language**  
   - Select a language code (`en`, `es`, `fr`, `pt`, etc.)
   - Get all books saved in that language.

6. 🛑 **Exit the app**  
   - Because life goes on.

---

## ⚙️ Under the Hood (Technical Highlights)

Here’s where things get spicy 🌶️ for tech leads, recruiters, and curious engineers.

### 🔌 Decoupled Services
- `BooksService`, `AuthorsService`, and `HttpService` keep things **clean, testable, and SRP-compliant**.
- Even the menu and input handling are handled via separate classes.

### 🧠 Smart Mapping
- Custom `BookMapper` transforms API DTOs into rich JPA entities.
- Also handles `Language` creation via a helper service — avoiding ugly duplicate logic.

### 🧪 Testing & CI
- Includes **unit tests** using JUnit.
- Custom exception (`MenuOptionOutOfBoundsException`) is tested.
- 💥 **GitHub Actions** workflow runs tests automatically on every push.

![GitHub Actions](https://img.shields.io/github/actions/workflow/status/your-user/your-repo/test.yml?label=Build%20%26%20Test&style=flat-square&logo=github)

### 🔄 Entity Relationships
- Rich data model:
  - `Book <-> Author`: Many-to-Many
  - `Book <-> Language`: Many-to-Many
- Clean JPA with explicit join tables.
- Eager fetching where needed for fast CLI output.

### 💾 PostgreSQL Support
- Ready to persist real book data.
- Can be easily extended with Flyway (already scaffolded before removal).

### 🛠️ Manual Dependency Injection Support
- Uses `@Service`, `@Component`, `@Autowired`, and `@Value` for seamless Spring Boot wiring.

### 🧼 Console Output Done Right
- Fully centralized in a custom `ConsolePrinter` utility.
- Separation of logic and presentation? ✅

---

## 📌 Technologies Used

| Stack         | Version |
|---------------|---------|
| Java          | 21      |
| Spring Boot   | 3.x     |
| Maven         | 💎      |
| PostgreSQL    | 🐘      |
| Jackson       | ✅      |
| JPA / Hibernate | 🧠   |
| GitHub Actions| 🛠️     |

---

## 🚀 Getting Started

> 🧪 You’ll need Java 21 and PostgreSQL.

```bash
# Clone the repo
git clone https://github.com/your-user/your-repo.git

# Open in your IDE or run via CLI
./mvnw spring-boot:run -Dspring-boot.run.profiles=cli
````

---

## 🧪 Run Tests

```bash
./mvnw test
```

Or let GitHub Actions do it for you when you push 👇
📦 CI/CD pipeline already included!

---

## 🎁 Final Thoughts

This console app isn't just a humble Java exercise — it's a fully working, tested, interactive CLI with persistence, API integration, and clean architecture.

It shows:

✅ Clean separation of concerns
✅ Spring Boot configuration mastery
✅ Robust error handling
✅ Git + CI/CD integration
✅ Modern Java best practices

...and it makes your terminal just a little more joyful. ✨

---

## 👨‍💻 Author

Made with too much ☕ and a lot of `System.out.printf()`.

---

## 💡 Bonus: Why This Project Rocks (from a recruiter's POV)

| Quality               | Evidence                                              |
| --------------------- | ----------------------------------------------------- |
| **Testability**       | Modular services + Unit test + GitHub Actions         |
| **Clean Design**      | SRP, DI, DTOs, Mappers, and Utils                     |
| **Real-world Tech**   | REST API integration + JPA + PostgreSQL               |
| **Modern Java**       | Java 21 features, Maven, Profiles, Exception handling |
| **Developer Empathy** | CLI experience with friendly UX and error messages    |

```

