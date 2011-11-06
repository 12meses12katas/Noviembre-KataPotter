(ns katapotter.core)

(def unit-price 8)

(def discount {1 0.00
               2 0.05
               3 0.10
               4 0.20
               5 0.25
               })

(defn price-package [different-books]
  (let [factor (- 1 (discount different-books))]
    (* different-books unit-price factor)))

(defn add-book [packages book]
  (if (empty? packages)
    [#{book}] ; new package
    (let [package (first packages)
          others  (rest packages)]
      (if (contains? package book)
        (cons package (add-book others book)) ; add to others
        (cons (conj package book) others))))) ; add to first package

(defn packages [books]
  (reduce add-book [] books))

(defn price [books]
  (reduce +
          (map (comp price-package count)
               (packages books))))
