Feature: Use the website to find restaurants
  So that I can order food
  As a hungry customer
  I want to be able to find restaurants in my area

  Scenario: Search for restaurants in an area
    Given I want food in "AR51" JUST EAT Holding Ltd. Fleet Place House, 2 Fleet Place, London EC4M 7RF
    When I search for restaurants
    Then I should see some restaurants in "AR51"
