@Seat
Feature: Booking

  Scenario: Adjust Work Schedule
    Given opens main page
    When introduce username and pass
    And inserts OTP

    And navigates to MySettings
    And opens Work Schedule
    And selects working days
    And selects working hours from 8:30 to 17:00
    And clicks Save
#    And clicks Reset



    Then debug step