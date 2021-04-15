$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("assignment1.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Author: Varun Gupta"
    },
    {
      "line": 2,
      "value": "# Date: 13th April 2021"
    },
    {
      "line": 3,
      "value": "# Description: Assignment"
    }
  ],
  "line": 5,
  "name": "Validate facebook login functionality",
  "description": "",
  "id": "validate-facebook-login-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 4,
      "name": "@Assignment"
    }
  ]
});
formatter.scenario({
  "line": 8,
  "name": "Validate facebook login with given credentials",
  "description": "",
  "id": "validate-facebook-login-functionality;validate-facebook-login-with-given-credentials",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Assignment1"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "user navigate to facebook application",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "user login facebook with username \"varun1204@gmail.com\" and password \"Mutri@2010\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "user post message \"Hello World\"",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User close the application",
  "keyword": "And "
});
formatter.match({
  "location": "FacebookSteps.user_navigate_to_facebook_application()"
});
formatter.result({
  "duration": 17582638200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "varun1204@gmail.com",
      "offset": 35
    },
    {
      "val": "Mutri@2010",
      "offset": 70
    }
  ],
  "location": "FacebookSteps.user_login_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 11383179400,
  "error_message": "org.junit.ComparisonFailure: expected:\u003c[www.facebook.com/[]]\u003e but was:\u003c[www.facebook.com/[checkpoint/?next]]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat stepDefinition.FacebookSteps.user_login_with_username_and_password(FacebookSteps.java:27)\r\n\tat ✽.When user login facebook with username \"varun1204@gmail.com\" and password \"Mutri@2010\"(assignment1.feature:10)\r\n",
  "status": "failed"
});
formatter.match({
  "arguments": [
    {
      "val": "Hello World",
      "offset": 19
    }
  ],
  "location": "FacebookSteps.user_post_message(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "WalletHubSteps.userCloseTheApplication()"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("assignment2.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# Author: Varun Gupta"
    },
    {
      "line": 2,
      "value": "# Date: 13th April 2021"
    },
    {
      "line": 3,
      "value": "# Description: Assignment"
    }
  ],
  "line": 5,
  "name": "Validate review functionality",
  "description": "",
  "id": "validate-review-functionality",
  "keyword": "Feature",
  "tags": [
    {
      "line": 4,
      "name": "@Assignment"
    }
  ]
});
formatter.scenario({
  "line": 7,
  "name": "Validate review functionality on WalletHub",
  "description": "",
  "id": "validate-review-functionality;validate-review-functionality-on-wallethub",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@Assignment2"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "user navigate to \"test_insurance_company\" profile",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "user login WalletHub with username \"varun1204@gmail.com\" and password \"Onish@2017\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "user rate \u00274\u0027 to the company",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "user select \"Health Insurance\" in Policy dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user writes random review of length \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "verify review feed got updated",
  "keyword": "Then "
});
formatter.step({
  "line": 14,
  "name": "user navigate to profile page",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "verify visibility of review.",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User close the application",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "test_insurance_company",
      "offset": 18
    }
  ],
  "location": "WalletHubSteps.user_navigate_to_profile(String)"
});
formatter.result({
  "duration": 22692174100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "varun1204@gmail.com",
      "offset": 36
    },
    {
      "val": "Onish@2017",
      "offset": 71
    }
  ],
  "location": "WalletHubSteps.user_login_WalletHub_with_username_and_password(String,String)"
});
formatter.result({
  "duration": 5374740200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4",
      "offset": 11
    }
  ],
  "location": "WalletHubSteps.user_rate_to_the_company(int)"
});
formatter.result({
  "duration": 40290420600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Health Insurance",
      "offset": 13
    }
  ],
  "location": "WalletHubSteps.user_select_Policy_dropdown(String)"
});
formatter.result({
  "duration": 357449400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 37
    }
  ],
  "location": "WalletHubSteps.user_writes_random_review_of_length(int)"
});
formatter.result({
  "duration": 1285304200,
  "status": "passed"
});
formatter.match({
  "location": "WalletHubSteps.verify_review_feed_got_updated()"
});
