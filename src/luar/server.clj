(ns luar.server
  (:use [org.httpkit.server :only [run-server]])
  (:require [ring.middleware.reload :as reload]
            [ring.middleware.refresh :as refresh]
            [ring.util.response :as response]

            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]))

(defroutes all-routes
  (GET "/" [] (response/file-response "index.html" {:root "resources/public"}))
  (route/resources "/")
  (route/not-found "<h1>Page not found!</h1>"))

(defn in-dev? [& args] true)

(def app 
  ;; (wrap-file all-routes "resources/public")
  ;; (refresh/wrap-refresh all-routes)
  (if (in-dev?)
    (refresh/wrap-refresh
     (reload/wrap-reload #'all-routes))
    all-routes))

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    (@server :timeout 100)
    (reset! server nil)))

(defn start-server [& port]
  (reset! server (run-server #'app {:port 8080})))

(defn -main [& args]
  (start-server))
