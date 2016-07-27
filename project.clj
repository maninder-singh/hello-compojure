(defproject hello-compojure "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]
                 [lib-noir "0.9.9"]
                 [ring/ring-json "0.4.0"]
                 [metosin/compojure-api "1.1.5"]
                 ]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler
         ;hello-compojure.handler/app
         hello-compojure.swagger/app
         }
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}}
  :jvm-opts ["-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=5005"]
  )
