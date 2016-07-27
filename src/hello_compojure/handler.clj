(ns hello-compojure.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [noir.response :as noir-response]
            [ring.middleware.json :refer [wrap-json-params]]
            )
  )

(defroutes app-routes
  (GET "/" [] (noir-response/json {:message "Hello World"}))
  (GET "/:name" [name]
    (noir-response/json {:message (str "Hello " name)})
    )
   (POST "/post" request
     (noir-response/status 201 (noir-response/json
                                 {:message (:params request)}
                                 ))
     )
  (route/not-found "Not Found"))

(def app
  ;(wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false))
  (
    -> app-routes
       wrap-json-params
    )
  )
