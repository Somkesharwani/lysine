# Lysine

Multi-module Gradle project with:

- `common-lib`
- `reimbursement-service`

## Requirements

- JDK 21 or newer
- Windows PowerShell or any shell that can run the Gradle wrapper

Note:
- The build is configured to stay clean even if Gradle is launched with JDK 24.
- Shared Gradle conventions live in `buildSrc`, so the root project should be treated as the real build entry point.

## Project Structure

```text
lysine/
|-- buildSrc/
|-- common-lib/
|-- reimbursement-service/
|-- gradlew
|-- gradlew.bat
```

## Build

Run the full build from the repository root:

```powershell
.\gradlew.bat build
```

This builds both modules:

- `:common-lib`
- `:reimbursement-service`

## Reimbursement Service

Run the Spring Boot service from the repository root:

```powershell
.\gradlew.bat :reimbursement-service:bootRun
```

You can also run the wrapper inside `reimbursement-service`. It forwards commands to the root multi-module build automatically.

## Local Database Setup

For local development, `reimbursement-service` now uses an in-memory H2 database by default.

Default local datasource:

- URL: `jdbc:h2:mem:lysine_db;MODE=PostgreSQL;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE`
- Username: `sa`
- Password: empty

This makes `bootRun` work without requiring a local PostgreSQL server.

## PostgreSQL Setup

If you want to run against PostgreSQL instead of H2, set these environment variables before starting the app:

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/lysine_db"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="password"
.\gradlew.bat :reimbursement-service:bootRun
```

## Port Configuration

The service uses this setting:

- `SERVER_PORT`, default `8080`

If port `8080` is already in use, run on another port:

```powershell
$env:SERVER_PORT=8081
.\gradlew.bat :reimbursement-service:bootRun
```

Or:

```powershell
.\gradlew.bat :reimbursement-service:bootRun --args="--server.port=8081"
```

## If Port 8080 Is Busy

Find the process:

```powershell
netstat -ano | findstr :8080
```

Stop it:

```powershell
taskkill /PID <PID> /F
```

Then start the app again.

## Useful Commands

Build everything:

```powershell
.\gradlew.bat build
```

Run only reimbursement service:

```powershell
.\gradlew.bat :reimbursement-service:bootRun
```

Run service on a different port:

```powershell
.\gradlew.bat :reimbursement-service:bootRun --args="--server.port=8081"
```

Run service with PostgreSQL:

```powershell
$env:DB_URL="jdbc:postgresql://localhost:5432/lysine_db"
$env:DB_USERNAME="postgres"
$env:DB_PASSWORD="password"
.\gradlew.bat :reimbursement-service:bootRun
```

## Notes

- `reimbursement-service` depends on `common-lib`.
- The nested `reimbursement-service` wrapper scripts are set up to delegate to the root build so shared plugins and modules resolve correctly.
- Current local configuration is intended to make development startup simple before real entities and repositories are added.
