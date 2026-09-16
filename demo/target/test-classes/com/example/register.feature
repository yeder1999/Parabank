Feature: Gestion d'une banque 

  Scenario: Register un utilisaateur 

    Given home page
    When I click on Register
    And I enter first name "Yedir"
    And I enter last name "Test"
    And I enter address "10 Rue de Paris"
    And I enter city "Paris"
    And I enter state "France"
    And I enter zip code "75001"
    And I enter phone "0612345678"
     And I enter SSN "123456789"
   
    And I enter username "Benamaryedir"
    And I enter password "Password123"
    And I confirm password "Password123"
    And I click on the Register button
   Then I should see the welcome message "Welcome Benamaryedir"

    When I click on Log Out

    And I enter login username "Benamaryedir"
    And I enter login password "Password123"
    And I click on Log In
    Then I should see "Accounts Overview"