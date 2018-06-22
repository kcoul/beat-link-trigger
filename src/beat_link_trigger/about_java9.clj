(ns beat-link-trigger.about-java9
  "This namespace can only be loaded under Java 9 or later, because it
  depends on classes only available there. It tells the Java
  environment to use our own About box rather than the spectacularly
  lame default one."
  (:require [beat-link-trigger.about]))

(defn install-handler []
  (eval '(.setAboutHandler (java.awt.Desktop/getDesktop)
                           (proxy [java.awt.desktop.AboutHandler] []
                             (handleAbout [_]
                               (beat-link-trigger.about/show))))))
