Feature: crepe

  @Smoke
  Scenario: crepe
    Given the user is on "http://www.google.com"
    When the user enters some text
    Then the text is entered