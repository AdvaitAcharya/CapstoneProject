Feature: Login to Registered Account

Scenario: Successfully logging in to a Registered Account 

Given I am on West Florida AHEC Website homepage
When I click on "<MyAccount>" account
And I am navigated to the "<MyAccountPage>" page
And I fill in "login_username" field with "advait_acharya"
And I fill in "login_password" field with "AdvaitAcharya@123"
And I click on Log In
Then I should be navigated to the "<my-account>" page
And I should see "Hello advait_acharya" on the page