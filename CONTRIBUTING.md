# Contributing to Car Dealership Management System

Thank you for considering contributing to this project! 🎉

## Code Style Guidelines

### Java Conventions
- Follow standard Java naming conventions
- Use meaningful variable and method names
- Keep methods short and focused (Single Responsibility Principle)
- Add JavaDoc comments for all public methods
- Use proper exception handling (avoid empty catch blocks)

### Best Practices
- Use try-with-resources for database connections
- Avoid hardcoding values - use constants
- Don't commit sensitive data (passwords, API keys)
- Write clean, readable code
- Remove commented-out code before committing

### Database
- Use PreparedStatements to prevent SQL injection
- Always close database connections
- Use transactions for multiple related operations
- Implement soft deletes where appropriate

## Commit Message Format

```
<type>: <subject>

<body>

<footer>
```

**Types:**
- `feat`: New feature
- `fix`: Bug fix
- `refactor`: Code refactoring
- `docs`: Documentation changes
- `style`: Code style changes (formatting)
- `test`: Adding tests
- `chore`: Build process or auxiliary tool changes

**Example:**
```
feat: Add search by color functionality to Cars

- Added searchByColor method in CarsDAO
- Created new servlet for handling color search
- Updated CarPage.jsp with color filter

Closes #23
```

## Pull Request Process

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Make your changes
4. Test your changes thoroughly
5. Commit your changes (`git commit -m 'feat: Add some AmazingFeature'`)
6. Push to the branch (`git push origin feature/AmazingFeature`)
7. Open a Pull Request

## Testing

Before submitting a PR:
- [ ] Test all CRUD operations
- [ ] Verify database connections work
- [ ] Check for SQL injection vulnerabilities
- [ ] Test with different browsers
- [ ] Ensure no console errors

## Questions?

Feel free to open an issue for any questions or concerns!

