# One more log4j2 (Log4Shell) vulnerable server

The exploit: https://github.com/Kirill89/log4shell-vulnerable-server-exploit

## Build

```shell
docker build -t log4shell-vulnerable-server .
```

## Run

```shell
docker run -it --rm -p 8000:8000 --name log4shell-vulnerable-server log4shell-vulnerable-server
```

## Log4Shell mitigation cheat sheet

https://snyk.io/blog/log4shell-remediation-cheat-sheet/
