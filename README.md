# Testara Example UI Automation

Sample project demonstrating UI test automation using the [Testara](https://github.com/ygrip) framework with **Cucumber BDD**, **Playwright Browser**, and optional **mitmproxy** support.

## Tech Stack

- **Java 21** + **Maven**
- **Testara Core with Playwright** (`testara-ui-playwright`, `testara-ui-cucumber`, `testara-junit5`)
- **Cucumber** for BDD feature files
- **Playwright** for browser automation
- **Lombok** for boilerplate reduction

## Project Structure

```
src/
├── main/java/.../automation/
│   ├── action/          # Custom page actions
│   ├── data/            # Data holders
│   ├── model/           # Domain models
│   └── page/            # Page objects
└── test/
    ├── java/.../automation/
    │   ├── Junit4RunnerTests.java
    │   └── Junit5RunnerTests.java
    └── resources/
        ├── features/    # Cucumber .feature files
        ├── templates/   # Proxy rule templates
        └── *.properties # Configuration files
```

## Prerequisites

- Java 21+
- Maven 3.8+

## Running Tests

```bash
# JUnit 4 (default)
mvn verify

# JUnit 5
mvn -Pjunit5 verify
```

Test reports are generated under `target/site/` and `target/cucumber-reports/`.

## Configuration

Key configuration files in `src/test/resources/`:

| File | Purpose |
|------|---------|
| `configuration.properties` | Browser, Playwright, proxy, and emulation settings |
| `cucumber.properties` | Cucumber tags, glue, parallelism |
| `application.properties` | External service integration (Consul/Vault) |

## License

This project is provided as a sample/example for the Testara framework.
