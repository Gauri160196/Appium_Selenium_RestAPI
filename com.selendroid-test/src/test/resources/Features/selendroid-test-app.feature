Feature: Launch and Verify Selendroid -test application

  @Scenario1
  Scenario: Verify title and elements on screen
    Given Application is launched
    Then verify title in application
    And verify elements on homepage

  @Scenario2
  Scenario: Check if homepage is displayed
  	Given I am on the homepage
  	When user clicks on EN button
  	And selects [No, no]
    Then user should be on homepage


  @Scenario3
  Scenario: Check Chrome Logo
  	Given I am on selendroid homepage
  	When verify the title
  	And verify text header
  	Then enters name as "GauriNarula"

  @Scenario4
  Scenario: Check Progress Bar
  	Given I am on test homepage
  	When I click on progress bar
  	And wait for loader to disappear
  	Then verify the registration page

  @Scenario5
  Scenario: Check Display Toast
  	Given I am again on homepage
  	And click on display toast button
  	Then verify toast text


  @Scenario
  Scenario: Check unhandles exception
  	Given I am still on homepage
  	And click on exception button
  	Then verify homescreen title



