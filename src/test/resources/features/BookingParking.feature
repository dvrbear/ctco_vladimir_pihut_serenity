@Seat
Feature: Booking workplace

  Scenario: Book and Cancel workplace
    Given opens main page
    When introduce username and pass
    And inserts OTP
    And navigate to office : Ztower_kITchen_office
    And select current date plus 1 day
    And select first free place
    And submit booking
    And navigate to parking : Ztower_Finance_parking
    And select current date plus 1 day
    And select first free place
    And submit booking

    Then debug step
