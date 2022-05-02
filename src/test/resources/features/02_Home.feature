#Author Shatlin
@StoryId=Home
@FeatureFileName=Home.feature

Feature: HomePage
  Scenario: HomePage
    Given i am authorized user
    When i access home page
    Then system should display Home Page



