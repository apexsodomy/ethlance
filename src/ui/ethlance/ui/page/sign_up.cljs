(ns ethlance.ui.page.sign-up
  (:require
   [taoensso.timbre :as log]
   [district.ui.component.page :refer [page]]

   [ethlance.shared.enumeration.currency-type :as enum.currency]

   ;; Ethlance Components
   [ethlance.ui.component.currency-input :refer [c-currency-input]]
   [ethlance.ui.component.email-input :refer [c-email-input]]
   [ethlance.ui.component.inline-svg :refer [c-inline-svg]]
   [ethlance.ui.component.main-layout :refer [c-main-layout]]
   [ethlance.ui.component.radio-select :refer [c-radio-select c-radio-search-filter-element]]
   [ethlance.ui.component.rating :refer [c-rating]]
   [ethlance.ui.component.search-input :refer [c-chip-search-input]]
   [ethlance.ui.component.tabular-layout :refer [c-tabular-layout]]
   [ethlance.ui.component.tag :refer [c-tag c-tag-label]]
   [ethlance.ui.component.text-input :refer [c-text-input]]
   [ethlance.ui.component.button :refer [c-button c-button-icon-label]]
   [ethlance.ui.component.textarea-input :refer [c-textarea-input]]))


(defn c-candidate-sign-up []
  [:div.candidate-sign-up
   [:div.form-container
    [:div.label "Sign Up"]
    [:div.first-forms
     [:div.form-image
      [c-inline-svg]]
     [:div.form-name
      [c-text-input {:placeholder "Name"}]]
     [:div.form-email
      [c-email-input {:placeholder "Email"}]]
     [:div.form-professional-title
      [c-text-input {:placeholder "Professional Title"}]]
     [:div.form-hourly-rate
      [c-currency-input {:placeholder "Hourly Rate in US Dollars" :color :secondary}]]
     [:div.form-country
      [:div.select-input {}]] ;; TODO: implement select input
     [:div.form-connect-github
      [c-button
       {:size :large}
       [c-button-icon-label {:icon-name :github :label-text "Connect Github"}]]]
     [:div.form-connect-linkedin
      [c-button
       {:size :large}
       [c-button-icon-label {:icon-name :linkedin :label-text "Connect LinkedIn"}]]]]
    [:div.second-forms
     [:div.label [:h2 "Languages You Speak"]]
     [c-chip-search-input {:search-icon? false :placeholder "Search Languages"}]
     
     [:div.label [:h2 "Categories You Are Interested In"]]
     [c-chip-search-input {:search-icon? false :placeholder "Search Categories"}]

     [:div.label [:h2 "Your Skills "] [:i "(Choose at least one skill)"]]
     [c-chip-search-input {:search-icon? false :placeholder "Search Skills"}]

     [:div.label [:h2 "Your Biography"]]
     [c-textarea-input {:placeholder "Enter Biography"}]]]
   
   [:div.form-submit "Create"]])


(defn c-employer-sign-up []
  [:div.employer-sign-up
   "employer"])


(defn c-arbiter-sign-up []
  [:div.arbiter-sign-up
   "arbiter"])


(defmethod page :route.me/sign-up []
  (let []
    (fn []
      [c-main-layout {:container-opts {:class :sign-up-main-container}}
       [c-tabular-layout
        {:key "sign-up-tabular-layout"
         :default-tab 0}
        
        {:label "Candidate"}
        [c-candidate-sign-up]
        
        {:label "Employer"}
        [c-employer-sign-up]
        
        {:label "Arbiter"}
        [c-arbiter-sign-up]]])))


