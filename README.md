# Demo App

Java app that uses [Jedis](https://github.com/redis/jedis) library to interact with Redis.

## Installation
You need Redis running locally to be able to use the app.

```shell
docker run --name some-redis -p 6379:6379 -d redis
```
This shouldn't be needed with docker-compose, but that option doesn't fully work at the moment.

## Usage

The app accepts XML files with the following structure:
```xml
<config>
  <subdomains>
        <subdomain>some_domain</subdomain>
  </subdomains>
  <cookies>
        <cookie name="some_name" host="some_host">some_value</cookie>
  </cookies>
</config>
```

Simply run the export.sh script to read the XML config file and export the information to Redis:

```shell
./export.sh [-v] path/to/file
```
where -v parameter tells the app to print all keys stored in Redis.

## Basic example

You can run:
```shell
./export.sh -v src/main/resources/config.xml
```
This will use the sample config.xml file provided with the app.