(ns luar.core
  (:require [compojure.core :refer :all]
            [org.httpkit.server :refer [run-server]]))

(defroutes myapp
  (GET "/" [] "Hello W"))

(defn -main []
  (run-server myapp {:port 5000}))
