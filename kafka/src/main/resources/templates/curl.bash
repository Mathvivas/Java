curl -X POST http://localhost:8080/api/posts \
  -H 'Content-Type: application/json' \
  -d '{
    "author": "matheus",
    "content": "hello modulith",
    "platforms": ["TWITTER", "LINKEDIN", "BLUESKY"]
  }'