# Java Server-Client Application

This repository contains a basic server-client application implemented in Java using socket programming. The server listens for incoming connections, and the client communicates with the server over a network.

## Getting Started

1. **Prerequisites:**
    - Java Development Kit (JDK) installed on your system.
    - A code editor or IDE (such as IntelliJ IDEA, Eclipse, or Visual Studio Code).

2. **Running the Application:**
    - Compile the Java files:
        ```bash
        javac StartTheClient.java
        javac ServerListener.java
        ```
    - Start the server:
        ```bash
        java ServerListener
        ```
    - Start the client:
        ```bash
        java StartTheClient
        ```
    - Follow the prompts to enter your name and exchange messages with the server.

## Code Structure

- `StartTheClient.java`: The client-side code that connects to the server.
- `ServerListener.java`: The server-side code that listens for incoming connections.

## Contributing

Feel free to contribute improvements or bug fixes to this project. Fork the repository, make your changes, and submit a pull request.

## License

This project is licensed under the MIT License - see the LICENSE file for details.

---

**Author:** Fuad Yagci (2024)