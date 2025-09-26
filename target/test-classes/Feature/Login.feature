@smoke @regression @functional 
Feature: User Registration on BlazeMeter
  As a new user
  I want to register on BlazeMeter
  So that I can access my account and use the platform

  Background:
    Given I am on the BlazeMeter registration page
    When I enter first name "Mesbah"
    And I enter last name "Chowdhury"
  @Positive  @RG001
  Scenario: Successful User Registration with valid data
    And I enter email "mesbah_chy@hotmail.com"
    And I enter company "SmartTech"
    And I click the Register button
    Then I should see a confirmation message
    And I should be redirected to my dashboard

  @Negative  @RG002
  Scenario: Registration with existing registered email address
    And I enter email "mesbah_chy@hotmail.com"
    And I enter company "SmartTech"
    And I click the Register button
    Then I should see an error message "An account with this email address already exists."
    And I should remain on the registration page

  @Negative  @RG003
  Scenario: Validation of mandatory email field
    And I leave the email field blank
    And I enter company "SmartTech"
    And I click the Register button
    Then I should see an error message "Email is required"
    And I should remain on the registration page
