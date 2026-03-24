@Sanity @GithubPage
Feature: Test on github page

  Scenario: Search and view github user
    Given Yunaz using chrome in desktop
    When he open "github" page
    Then he is in "github" page
    When he click the "search bar"
    And he enter value "user:ygrip" on "input search field"
    And he wait until "profile card" is visible
    Then he see that
      | actual               | validation    | expectation           |
      | textof(profile card) | CONTAINS_TEXT | Yunaz Gilang Ramadhan |

  @Proxy @Ignored
  Scenario: Intercept and change github user profile picture
    Given Yunaz using chrome in desktop with mitmproxy proxy
    When he disable proxy cache
    And he open "github" page
    Then he is in "github" page
    And he click the "search bar"
    And he enter value "user:ygrip" on "input search field"
    And he wait until "profile card" is visible
    Then he see that
      | actual               | validation    | expectation           |
      | textof(profile card) | CONTAINS_TEXT | Yunaz Gilang Ramadhan |
    When he create proxy rule from "github/change profile picture"
    And he refresh page
    And he wait until "profile card" is visible
    Then he see that
      | actual               | validation    | expectation           |
      | textof(profile card) | CONTAINS_TEXT | Yunaz Gilang Ramadhan |