(ns electron.menu)

(def electron (js/require "electron"))

(let [template [{:label (.. electron -app -name) :submenu [ {:label "foo"} {:label "bar"}]}]
      Menu     (.-Menu electron)]
  (->> template
       clj->js
       (.buildFromTemplate Menu)
       (.setApplicationMenu Menu)))
