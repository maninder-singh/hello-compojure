(ns hello-compojure.swagger
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [noir.response :as noir-response]
            [ring.middleware.json :refer [wrap-json-params]]
            [ring.util.response :as ring-response]
            )
  )

(defroutes app-routes
           (GET "/" []
             (ring-response/resource-response "index.html" {:root "public/hello"})
             ;(noir-response/json {:message "Hello World"})
                )
           (GET "/:name" [name]
             (noir-response/json {:message (str "Hello " name)})
             )
           (POST "/post" request
             (noir-response/status 201 (noir-response/json
                                         {:message (:params request)}
                                         ))
             )
           (route/resources "/")
           (route/not-found "Not Found")
           )

(def app
  (-> app-routes
      wrap-json-params
      )
  )

