Feature: Average Rating

    Scenario: Average of two ratings
        Given the following ratings were put
            | tastingId | userId | rating |
            | aa        | xx     | 2.0    |
            | aa        | yy     | 4.0    |
            | bb        | xx     | 5.0    |
        When I request the average rating for tasting aa
        Then I get 3.0

    Scenario: Overwrite ratings
        Given the following ratings were put
            | tastingId | userId | rating |
            | aa        | xx     | 2.0    |
            | aa        | yy     | 4.0    |
        And the following ratings were put
            | tastingId | userId | rating |
            | aa        | xx     | 5.0    |
            | aa        | yy     | 5.0    |
        When I request the average rating for tasting aa
        Then I get 5.0
