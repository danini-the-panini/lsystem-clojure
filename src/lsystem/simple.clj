(ns lsystem.simple
  (:use quil.core))

(def a (/ Math/PI 8))

(def d 5)

(def F
  {:F (fn [S]
        (let [{:keys [pos dir]} S]
          (let [npos (map + pos (map #(* d %) [(Math/cos dir) (Math/sin dir)]))]
            (line pos npos)
            (assoc S :pos npos))))

   :L (fn [S]
        (let [{:keys [dir]} S]
          (assoc S :dir
            (- dir a))))

   :R (fn [S]
        (let [{:keys [dir]} S]
          (assoc S :dir
            (+ dir a))))

   :< (fn [S]
        (let [{:keys [hist]} S]
          (assoc S :hist
            (conj (seq hist) S))))

   :> (fn [S]
        (let [{:keys [hist]} S]
          (first hist)))})
