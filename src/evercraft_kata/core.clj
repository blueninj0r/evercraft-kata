(ns evercraft-kata.core)

(defn add-name
  [char name]
  (assoc char :name name))

(defn add-alignment
  [char alignment]
  {:pre [( contains? #{:good :evil :neutral} alignment) ]}
  (assoc char :alignment alignment))
