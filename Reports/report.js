$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("assignment2.feature");
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
  "name": "user navigates to \"ReviewSubmitPage\" page",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "user select \"Health Insurance\" in Policy dropdown",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "user writes random review of \"200\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "verify review feed got updated",
  "keyword": "Then "
});
formatter.step({
  "line": 15,
  "name": "user navigate to profile page",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "verify visibility of review.",
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
