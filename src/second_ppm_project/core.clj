(ns second-ppm-project.core)



(def head (str "P3\n" 600 " " 400 " 255 " "\n"))

(def foo
  (for [j (range 600)
        i (range 400)
        :let
        [r (mod i 255)
         g (mod j 255)
         b (mod (* i j)255)]
        ]
    (clojure.string/join "flush-on-newline"  [r " " g " " b "\n"])))

(def result
  (apply str head foo))

(spit "test2.ppm" result :append true)

