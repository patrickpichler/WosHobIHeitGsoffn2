(ns woshobiheitgsoffn2.events
  (:require
   [re-frame.core :as re-frame]
   [woshobiheitgsoffn2.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))
