Feature: Vérification

  @tag1
  Scenario: Consultation des listes de référentiel
    Given connexion
    When Authentification
    Then Je peux consulter l'ensemble des données enregistrées par référentiel
