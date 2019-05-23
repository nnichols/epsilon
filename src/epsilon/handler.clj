(ns epsilon.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn bodiless-response
  "Creates a boddiless ring response with status `code`"
  [code]
  {:status code
   :headers {"Content-Type" "application/json; charset=UTF-8"}})

(defroutes app-routes
  (GET "/" []
    "Hello World")

  (GET "/heartbeat" []
    (bodiless-response 200))

  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes
                 site-defaults))
