(ns katapotter.test.core
  (:use [clojure.core])
  (:use [clojure.test]))

(deftest empty-purchase
  (is (= 0 (price []))))
