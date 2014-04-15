(ns lsystem.core)

(defn lsystem ([Z P]
    (if (empty? Z) Z
      (let [p (P (first Z))]
        (concat (or p [(first Z)])
                (lsystem (rest Z) P))))))

(defn nth-L [Z P i]
  (if (zero? i) (seq Z)
    (recur (lsystem Z P) P (dec i))))

(defn turtle [Z S F]
  (if (empty? Z) nil
    (let [f ((first Z) F)]
      (recur (rest Z) (f S) F))))
