# JSON Processing API Benchmark

## Requirements

The following tools are required to build this software.
* JDK 9 or higher
* [Apache Maven] 3.6.0 or higher

## How to Build

```
$ mvn clean package
```

Or if you try [Apache Johnzon] as the service provider:
```
$ mvn clean package -P with-johnzon
```

## How to Run

```
$ java -jar target/benchmarks.jar
```

[Apache Maven]: https://maven.apache.org/
[Apache Johnzon]: https://johnzon.apache.org/
