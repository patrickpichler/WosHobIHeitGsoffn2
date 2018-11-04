(ns woshobiheitgsoffn2.views
  (:require
   [re-frame.core :as re-frame]
   [woshobiheitgsoffn2.subs :as subs]
   ))

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     ]))
