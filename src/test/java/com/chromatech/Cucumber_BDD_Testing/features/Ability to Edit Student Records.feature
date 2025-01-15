Feature: Editing Student Records

  @Regression @Kei @AG3CP-14
  Scenario Outline: Successfully Make And Save Changes To A Student Record
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    And user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    And user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And verifies a student with "<Admission No>" is not an existing student
    And creates a test category "Selenium"
    When a CTSMS admin or faculty member is on the student admission page "https://mexil.it/chroma/student/create"
    And fills out all required fields with admission number "<Admission No>", class "<Class>", section "<Section>", first name "<First Name>", gender "<Gender>", date of birth "<Date of Birth>", guardian name "<Guardian Name>", guardian phone number "<Guardian Phone>"
    And clicks save
    When a CTSMS user opens a student record with admission number "<Admission No>"
    And makes and saves changes to the student information with "email@newemail.com", and "333-333-333"
    Then the user should see message "Record Update Successfully"
    Then user navigate to test students account "<Class>", section "<Section>", and admission number "<Admission No>"
    And delete test account with "<Admission No>"
    And delete the test category

    Examples:
      | Admission No | Class | Section               | First Name          | Gender | Date of Birth | Guardian Name | Guardian Phone |
      | 112358132134 | SDET  | Cucumber Fundamentals | Group Three Student | Female | 03/03/1993    | Bob           | 3333333333     |