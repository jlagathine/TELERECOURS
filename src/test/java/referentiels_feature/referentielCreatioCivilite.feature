Feature: Création référentiel

  @tag
  Scenario: Utilisateur connecté au site
    Given Je me connecte
    When Je m'authentifie
    Then Je peux consulter la liste des référentiels par ordre alphabétique

  @tag1
  Scenario: Création référentiel CIVILITE
    Given Je clique sur le référentiel CIVILITE
    When Je clique sur le bouton CREER
    And J'ajoute un type de civilité
    And J'ajoute le SUIVI
    And J'ajoute une juridiction
    And j'enregistre mon référentiel
