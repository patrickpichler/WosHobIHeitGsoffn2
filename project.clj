(defproject woshobiheitgsoffn2 "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.1"]
                 [re-frame "0.10.6"]
                 [cljsjs/material-ui "3.2.0-0"]
                 [cljsjs/material-ui-icons "3.0.1-0"]
                 [lein-doo "0.1.10"]
                 [devcards "0.2.6"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-doo "0.1.10"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.10"]]

    :plugins      [[lein-figwheel "0.5.16"]]}
   :prod { }
   }

  :hooks [leiningen.cljsbuild]

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "woshobiheitgsoffn2.core/mount-root"}
     :compiler     {:main                 woshobiheitgsoffn2.core
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}
                    }}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            woshobiheitgsoffn2.core
                    :output-to       "resources/public/js/compiled/app.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}
    {:id "test"
     :source-paths ["src/cljs" "test/cljs"]
     :compiler {:main runners.doo
                :optimizations :none
                :output-dir "resources/public/js/compiled/test/out"
                :output-to "resources/public/js/compiled/tests/all-tests.js"}}

    {:id "devcards-test"
     :source-paths ["src/cljs" "test/cljs"]
     :figwheel {:devcards true}
     :compiler {:main runners.browser
                :optimizations :none
                :asset-path "cljs/tests/out"
                :output-dir "resources/public/js/compiled/tests/out"
                :output-to "resources/public/js/compiled/tests/all-tests.js"
                :source-map-timestamp true}}
    ]

   :test-commands {"test" ["lein" "doo" "phantom" "test" "once"]}}
  )
