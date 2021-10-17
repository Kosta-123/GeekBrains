Feature: create my project
  Background:
    Given I am authorized

    Scenario:
      Given i hover on Projects button
      And i click at My projects button
      And i click at Create project button
      When i am at Create project page
      And i fill Project name field
      And i click at Choose organization button
      And i click All organizations button
      And i select Priority
      And i select Finance source
      And i select Business unit
      And i select Curator
      And i select RP
      And i select Administrator
      And i select Manager
      And i click at Save and quit button
      Then i see error message




