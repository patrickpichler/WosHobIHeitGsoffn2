(ns runners.doo
  (:require [doo.runner :refer-macros [doo-all-tests]]
                                      [runners.tests]))

(doo-all-tests #"(woshobiheitgsoffn2)\..*-test")
