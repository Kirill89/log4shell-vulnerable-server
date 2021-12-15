# One more log4j2 vulnerable server

## Build

```shell
docker build -t "log4shell-vulnerable-server" .
```

## Run

```shell
docker run -it --rm -p 8000:8000 --name log4shell-vulnerable-server log4shell-vulnerable-server
```
