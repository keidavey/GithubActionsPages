Feature: Expenses Module

  @Regression @AG3CP-54 @ValerieYa
  Scenario: Expenses Module
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    When user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And the user clicks on the Expenses module
    Then the following submodules are displayed "Add Expense", "Search Expense", "Expense Head"