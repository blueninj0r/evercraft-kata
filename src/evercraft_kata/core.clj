(ns evercraft-kata.core)

(defn add-name
  [char name]
  (assoc char :name name))

(defn add-alignment
  [char alignment]
  {:pre [( contains? #{:good :evil :neutral} alignment) ]}
  (assoc char :alignment alignment))

(defn add-ac
  [char & ac]
  (assoc char :ac (if (nil? ac) 10 (first ac))))

(defn add-hp
  [char & hp]
  (assoc char :hp (if (nil? hp) 5 (first hp))))

(defn is-hit?
  [char val]
  (<= (:ac char) val))

(defn receive-attack
  [char die]
  (if (is-hit? char die)
    (cond
     (= die 20) (update-in char [:hp] #(- % 2))
     :else (update-in char [:hp] dec))
    char))
