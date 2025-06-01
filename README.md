🛰️ Flow Anomaly Detection Simulation

This project simulates a real-time anomaly detection system in network packet streams, commonly used in cybersecurity environments. The goal is to model the behavior of concurrent systems that process high volumes of network packets while respecting limitations in storage and processing capacity.
📌 Context

Modern real-time monitoring systems — such as those used for detecting cyberattacks — must continuously analyze large amounts of network traffic. Efficient packet analysis is critical to detect anomalies without data loss or resource overuse. This requires careful implementation of control and synchronization mechanisms to manage packet buffering and processing.
🎯 Objective

Implement a concurrent system in Java that simulates the generation, buffering, and analysis of network packets to detect anomalies.
🛠️ Requirements

Packet Simulation

    Use the Random class to generate synthetic packets.

    Each packet contains a value (e.g., int or double) indicating whether it's normal or anomalous.

    Simulate realistic traffic: 90% normal packets, 10% anomalous.

Shared Buffer

    Operate with a fixed-size buffer (limited capacity).

    If the buffer is full, the generator must wait.

    If the buffer is empty, the analyzer must wait.

Concurrency Control

    Use wait() and notify() / notifyAll() for thread synchronization.

    Busy-waiting (spin loops) is strictly forbidden.

Packet Analysis

    Analyze packets using a simple threshold rule (e.g., if value > threshold → anomaly).

    Clearly log detected anomalies (to console or file).

🔍 Evaluation & Experimentation

    Run simulations with different thread configurations (e.g., varying numbers of generator and analyzer threads).

    Measure and log:

        Thread wait times.

        Number of processed and dropped packets (if any).

        Anomaly detection rates.

    Create graphs or tables to visualize results.