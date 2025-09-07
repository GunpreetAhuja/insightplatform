
# Insight360 — Enterprise Resource & Analytics Platform (Starter Monorepo)

This repository is a starter template for Insight360, an enterprise-style microservices platform using Java Spring Boot and ActiveMQ.
It contains simplified, runnable example services to demonstrate architecture and dev practices for interviews and portfolios.

## Services
- user-service (port 8082) — simple in-memory user CRUD
- project-service (port 8083) — simple in-memory project CRUD
- finance-service (port 8084) — demonstrates JMS Queue invoice processing + REST APIs
- notification-service (port 8085) — subscribes to JMS Topic notifications

## Quick Start (local) using Docker Compose
```bash
docker compose up --build
# ActiveMQ console: http://localhost:8161 (admin/admin)
# user-service: http://localhost:8082/api/users
# project-service: http://localhost:8083/api/projects
# finance-service endpoints: /api/finance (create invoice, notify)
# notification-service listens to topic and logs messages
```

## Example Requests
Queue an invoice:
```bash
curl -X POST "http://localhost:8084/api/finance/invoice?clientId=42&amount=199.99"
```

Publish a notification:
```bash
curl -X POST "http://localhost:8084/api/finance/notify?msg=Payroll%20processed"
```

## Notes
- This is a simplified starter for interview/demo purposes. In production you'd split repos, use proper databases per service, secrets management, and Kubernetes manifests.
- Each service is a standalone Gradle project; build with `./gradlew bootJar` inside each service folder or use the docker-compose build.
