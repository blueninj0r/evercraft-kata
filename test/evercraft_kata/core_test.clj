(ns evercraft-kata.core-test
  (:use midje.sweet)
  (:use [evercraft-kata.core]))

(fact "a record can be updated with a name"
      (add-name {} "Chris") => {:name "Chris"})

(facts "a record can be updated with an alignment"
       (fact "characters can be good, evil or neutral"
             (add-alignment {} :good) => {:alignment :good}
             (add-alignment {} :evil) => {:alignment :evil}
             (add-alignment {} :neutral) => {:alignment :neutral})
       (fact "characters cannot have any other alignment"
             (add-alignment {} :foo) => (throws AssertionError)))
