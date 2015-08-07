(ns luar.server
  (:use [org.httpkit.server :only [run-server]])
  (:require [ring.middleware.reload :as reload]
            [ring.util.response :as response]
            [ring.middleware.refresh :as refresh]

            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]))

(defroutes all-routes
  (GET "/" [] (response/file-response "index.html" {:root "resources/public"}))
  (route/not-found "<h1>Page not found.</h1>"))

(def server
  (refresh/wrap-refresh all-routes))

(defn in-dev? [& args] true)

(defn -main [& args]
  (let [handler 
        (if (in-dev? args)
          (reload/wrap-reload #'all-routes)
          all-routes)]
    
    (run-server handler {:port 8080})))









