(ns katapotter.test.core
  (:use [katapotter.core])
  (:use [clojure.test]))

(deftest empty-purchase
  (is (= 0 (price []))))

(deftest one-book-purchase
  (is (= 8 (price [1])))
  (is (= 8 (price [5]))))

(deftest without-discount
  (is (= 16 (price [1 1])))
  (is (= (* 8 3) (price [2 2 2]))))

(deftest simple-disconunt
  (is (= (* 8 2 0.95) (price [1 2])))
  (is (= (* 8 3 0.9) (price [1 3 5])))
  (is (= (* 8 4 0.8) (price [1 2 3 5])))
  (is (= (* 8 5 0.75) (price [1 2 3 4 5]))))

(deftest several-discounts
  (is (= (+ 8 (* 8 2 0.95))
         (price [1 1 2])))
  (is (= (* 2 (* 8 2 0.95))
         (price [1 1 2 2])))
  (is (= (+ (* 8 4 0.8)
            (* 8 2 0.95))
         (price [1 1 2 2 3 4])))
  (is (= (+ 8 (* 8 5 0.75))
         (price [1 2 2 3 4 5]))))

(deftest edge-cases
  (is (= (* 2 (* 8 4 0.8))
         (price [1 1 2 2 3 3 4 5])))
  (is (= (+ (* 3 (* 8 5 0.75))
            (* 2 (* 8 4 0.8)))
         (price [1 1 1 1 1
                 2 2 2 2 2
                 3 3 3 3
                 4 4 4 4 4
                 5 5 5 5]))))
