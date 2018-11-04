(ns woshobiheitgsoffn2.subs-test
  (:require [cljs.test :refer-macros [is testing run-tests]]
            [devcards.core :refer-macros [deftest defcard]]))

(enable-console-print!)

(defcard some-tests
  (deftest test-number
    (is (= 1 1)))

  (deftest test-fail
    (is (= 1 1))))

