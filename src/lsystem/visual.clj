(ns lsystem.visual
  (:use lsystem.core)
  (:use lsystem.simple)
  (:use quil.core))

(def Z [:F])
(def P { :F [:F :< :L :F :> :< :R :F :> :F]})
(def S {:pos [400 600] :dir (* 3 (/ Math/PI 2))})

(defn setup []
  (smooth)
  (frame-rate 15)
  (background 0))

(defn draw []
  (stroke 255)
  (stroke-weight 1)
  (background 0)

  (turtle Z S F))

(defn mouse []
  (redraw))

(defsketch lsketch
  :title "L-System"
  :setup setup
  :draw draw
  :size [800 600]
  :mouse-pressed mouse)
