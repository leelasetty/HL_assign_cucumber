Feature: test alert prompt and confirm buttons

Scenario: check alert button

Given launch the web page of javascript_alerts
When I click ok on pop up alert box
Then I should come back to my main window

Scenario: check confirm button for ok

Given launch the web page of javascript_alerts
When I click ok on pop up confirm window
Then I should get result you clicked ok

Scenario: check confirm button for Cancel

Given launch the web page of javascript_alerts
When I click cancel on pop up confirm window
Then I should get result you clicked cancel

Scenario: check prompt window with input text and ok

Given launch the web page of javascript_alerts
When I type text on prompt window and click ok
Then I should see your text under You entered: column

Scenario: check prompt window with input text and cancel

Given launch the web page of javascript_alerts
When I type text on prompt window and click cancel
Then I should not see your text under You entered: columnn

