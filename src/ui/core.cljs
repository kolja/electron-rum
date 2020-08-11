(ns ui.core
  (:require [rum.core :as rum]
            [clojure.string :as string :refer [split-lines]]))

(enable-console-print!)

(defonce state (atom 0))

(rum/defc click-me < rum/reactive []
  (let [counter (rum/react state)]
      [:button
       {:on-click #(swap! state inc)}
       (str "clicked " counter " times")]
  )
)

(rum/mount (click-me) (js/document.getElementById "app-container"))
