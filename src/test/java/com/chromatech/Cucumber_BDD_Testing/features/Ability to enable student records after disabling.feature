Feature: Enable and disable student

  @Regression @Nahun @AG3CP-16
  Scenario Outline: Ability to enable and disable student
    Given a user is on the Chroma Tech Academy practice site "https://mexil.it/chroma/site/login"
    When user enters username "general@teacher.com" in username text box
    And enters password "123456" in password text box
    And clicks on Sign In button
    Then user is directed to the CTSMS dashboard page "https://mexil.it/chroma/admin/admin/dashboard"
    And verifies a student with "<Admission No>" is not an existing student
    Then creates a test category "<Category>"
    And a CTSMS admin or faculty member is on the student admission page "https://mexil.it/chroma/student/create"
    And the user fills out all fields "<Admission No>", "<Roll Number>", "<Class>", "<Section>", "<First Name>", "<Last Name>", "<Gender>", "<Date of Birth>", "<Category>", "<Email>", "<Admission Date>", "<Blood Group>", "<As on Date>", "<Mobile Number>", "<Height>", "<Weight>", "<Father Name>", "<Father Phone>", "<Father Occupation>", "<Mother Name>", "<Mother Phone>", "<Mother Occupation>", "<Guardian Email>", "<Guardian Address>"
    And clicks save
    When a CTSMS user opens a student record with admission number "<Admission No>"
    And clicks on Disable Student button
    When a user enables the student record
    Then the student record is successfully enabled
    Then user navigate to test students account "<Class>", section "<Section>", and admission number "<Admission No>"
    And delete test account with "<Admission No>"
    And delete the test category
    Examples:
      | Admission No | Roll Number | Class | Section               | First Name | Last Name | Gender | Date of Birth | Category | Email                  | Admission Date | Blood Group | As on Date | Mobile Number | Height | Weight | Father Name | Father Phone | Father Occupation | Mother Name | Mother Phone | Mother Occupation | Guardian Email          | Guardian Address | Bank Account Number | Bank Name | IFSC Code | National Identification Number | Local Identification Number | Previous School Details                     | Note                                                                      | Title 1 | Title 2 | Title 3 | Title 4     |
      | 1001954230   | 201333333   | SDET  | Cucumber Fundamentals | John       | Doe       | Male   | 10/27/2020    | Selenium | john.doe01@example.com | 09/11/1998     | O+          | 01/02/1990 | 1001001100    | 170 cm | 60 kg  | Michael Doe | 1002002100   | Engineer          | Jane Doe    | 1003003100   | Teacher           | bruce.wayne@example.com | 100 Wayne Manor  | 314438451           | Amberley  | 56229     | 859694896                      | 1266164692                  | Dictionary St 2883, Owerri, Georgia, 891349 | Youth hearing memories packed engineering grow thai, candidate easy lisa. | Brother | Sister  | Dog     | Grandmother |