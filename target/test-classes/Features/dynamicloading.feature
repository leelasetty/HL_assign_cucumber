Feature: checking for dynamically loaded web element

Scenario: trigger the start button and wait for web element to load

Given launch the web page of dynamic loading
When when i click the start button and wait
Then after loadingbar disappears the text hello world appears
