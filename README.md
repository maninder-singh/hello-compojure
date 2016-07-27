# hello-compojure

A rest api with ui developed using compojure and angularjs.This provides a boilerplate code for developing application using compojure and angularjs.

## Tools Required
* [Leiningen](http://leiningen.org/) 
* [Node Js](https://nodejs.org/en/)

## Getting Started

### Run application

* Open project.cli file and comment `:jvm-opts` option.

```
$ cd hello-compojure/resources/public/hello
$ npm install
$ cd ../../../
$ lein ring server

```

### Debug application
Using [Intellij Idea](https://www.jetbrains.com/idea/) ide with Cursive plugin on it.

* Open project.cli file and uncomment `:jvm-opts` if commented.
```
:jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"]

```
* Open `Run -> Edit Configuration` on Intellij Idea.
* Click on green `+` button and select Remote from it.
* Provide name to it and save the configuration.
* Run the application using leiningen.
```
$ cd hello-compojure
$ lein ring server-headless

-- Now the server will start listening for remote debugging on port 5005.
```
* Click on debug button on Intellij Idea.
* Open browser and go to url `http://localhost:3000`.

