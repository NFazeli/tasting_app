import requests
import json
from behave import given, then, when

@given('the following ratings were put')
def put_ratings(context):
    for row in context.table:
        data = {
            "tastingId": row['tastingId'],
            "userId": row['userId'],
            "rating": row['rating']
                }
        r = requests.put("http://localhost:8080/rating", data=json.dumps(data), headers={'Content-type': 'application/json'})
        assert r.status_code == 201


@when('I request the average rating for tasting {tasting_id}')
def request_average_rating(context, tasting_id):
    r = requests.get(f"http://localhost:8080/average-rating?tastingId={tasting_id}")
    assert r.status_code == 200
    context.result = r.json()

@then('I get {result}')
def assert_result(context, result):
    assert str(context.result) == str(result), f'Expected {result}, got {context.result}'
