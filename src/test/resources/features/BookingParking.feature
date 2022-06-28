Feature: Booking

  Scenario: Book workplace and parking
    Given opens main page
    When introduce username and pass
    And inserts OTP

    And navigate to office : Ztower_kITchen_office
    And select current date plus 1 day
    And try to cancel workplace booking
    And select first free place
    And submit workplace booking

    And navigate to parking : Ztower_Finance_parking
    And select current date plus 1 day
    And select first free place
    And submit parking booking for car number : AAA111

    Then debug step
