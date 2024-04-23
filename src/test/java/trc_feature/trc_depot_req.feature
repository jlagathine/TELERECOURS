
@tag
Feature: TRC depot de requete

  @tag1
  Scenario: autentificathion
    Given je suis connecté à l'application
    When je mauthentifie avec le <mail> et le <mdp>
    Then je suis connecté à mon compte


    Examples: 
      | mail  | bba@yopmail.com | 
      | mdp   | Lhommeest2019*  |
