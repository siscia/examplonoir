(ns examplenoir.server
  (:require [noir.server :as server]))

(server/load-views "src/examplenoir/views/")

(defn -main [& m]
  (let [mode (keyword (or (first m) :dev))
        port (Integer. (get (System/getenv) "OPENSHIFT_INTERNAL_PORT" "8080"))
	host (get (System/getenv) "OPENSHIFT_INTERNAL_IP")]
    (server/start port {:mode mode
                        :ns 'examplenoir
                        :jetty-options {:host host}})))

