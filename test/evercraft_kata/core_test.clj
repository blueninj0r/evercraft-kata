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

(facts "a character can get an AC"
       (fact "by default, a character will get an AC of 10"
             (add-ac {}) => {:ac 10})
       (fact "a character can be given a specific AC"
             (add-ac {} 12) => {:ac 12}))

(facts "a character can get an HP"
       (fact "by default, a character has an HP of 5"
             (add-hp {}) => {:hp 5})
       (fact "a character can be given a specific HP"
             (add-hp {} 12) => {:hp 12}))

(facts "a character can be attacked"
       (fact "when the attack value is less than AC the attack misses"
             (is-hit? {:ac 10} 5) => false)
       (fact "when the attack value is equal to or greater than the AC the attack hits"
             (is-hit? {:ac 10} 10) => true
             (is-hit? {:ac 10} 11) => true))

(facts "a character can be attacked"
       (fact "when the die roll is less than the AC the character takes no damage"
             (receive-attack {:ac 10 :hp 5} 9) => {:ac 10 :hp 5})
       (fact "when the die roll is equal to or greater than the AC the character takes 1 HP of damage"
             (receive-attack {:ac 10 :hp 5} 10) => {:ac 10 :hp 4}
             (receive-attack {:ac 10 :hp 5} 12) => {:ac 10 :hp 4})
       (fact "when the die roll is a hit and a natural 20, the character takes 2 HP of damage"
             (receive-attack {:ac 10 :hp 5} 20) => {:ac 10 :hp 3}))
