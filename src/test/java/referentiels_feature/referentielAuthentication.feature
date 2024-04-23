
Feature: Connexion

  @tag
  Scenario: Utilisateur connecté au site
    Given Je me connecte
    When Je m'authentifie
    Then Je peux consulter la liste des référentiels par ordre alphabétique
