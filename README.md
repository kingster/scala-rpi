# scala-rpi
Scala with Raspberry PI2

#Building

```bash
$ sbt
> compile
> run
```

#Run

- To Run Locally `sbt run`
- To build Jar and then run
    ```bash
    $ sbt assembly
    $ java -jar target/scala-2.10/scala-rpi.jar
    ```

- To Run on Raspberry PI `./scripts/run-rpi.sh -h "pi@hostname"`

