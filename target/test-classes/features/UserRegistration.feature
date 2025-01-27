Feature: User Registration

Scenario: Successful Registration of User with valid data

Given I am on West Florida AHEC Website homepage
When I click on "<MyAccount>" menuoption
And I am redirected to "<MyAccountPage>" page 
And I fill in "username" field with "Advait4Acharya" inputvalue
And I fill in "email" field with "acharyaadvait1100@gmail.com" inputvalue
And I fill in "password" field with "AdvaitAAcharya@123" inputvalue
And I click on Register
Then I should be redirected to the "<my-account>" myaccountpage
And I should see the heading "DASHBOARD"
