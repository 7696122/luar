(ns luar.core
<<<<<<< HEAD
  (:use org.httpkit.server))

(defn app [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "hello HTTP!"})

(defonce server (atom nil))

(defn stop-server []
  (when-not (nil? @server)
    ;; graceful shutdown: wait 100ms for existing requests to be finished
    ;; :timeout is optional, when no timeout, stop immediately
    (@server :timeout 100)
    (reset! server nil)))

(let [jetty (run-jetty app options)]
  (.stop jetty))

(let [server (run-server app options)]
  ;; run-server returns a function that stops the server
  (server))

(defn -main [& args]
  ;; The #' is useful when you want to hot-reload code
  ;; You may want to take a look: https://github.com/clojure/tools.namespace
  ;; and http://http-kit.org/migration.html#reload
  (reset! server (run-server #'app {:port 8080})))
=======
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]))

(defroutes myapp
  (GET "/" [] "Hello W"))

(defn -main []
  (run-server myapp {:port 5000}))
>>>>>>> 5a9394e7ef7ac91129c9838a1497c3a238027c7d
