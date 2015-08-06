(defproject luar "0.1.0-SNAPSHOT"
<<<<<<< HEAD
  :description "Luar Shop"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main luar.server
  :plugins [[lein-cljsbuild "1.0.6"]]
  :cljsbuild {:builds [{:source-paths ["src-cljs"]
                        :compiler {:output-to "war/javascripts/main.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}]}
  :hooks [leiningen.cljsbuild]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [http-kit "2.1.19"]
                 [compojure "1.4.0"]
                 [ring/ring-devel "1.4.0"]
                 [ring/ring-core "1.4.0"] 
                 [ring/ring-defaults "0.1.5"]
                 [org.clojure/clojurescript "1.7.48"]])
=======
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.4.0"]
                 [http-kit "2.1.19"]])
>>>>>>> 5a9394e7ef7ac91129c9838a1497c3a238027c7d
