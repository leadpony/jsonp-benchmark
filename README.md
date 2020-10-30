# JSON Processing API Benchmark

## Requirements

The following tools are required to build and run the artifacts.
* JDK 11 or higher
* [Apache Maven] 3.6.0 or higher

## How to Build

```bash
mvn clean package
```

When using [Joy] as the service provider:
```bash
mvn clean package -P with-joy
```

## How to Run

```bash
java -jar target/benchmarks.jar
```

[Apache Maven]: https://maven.apache.org/
[Joy]: https://github.com/leadpony/joy
