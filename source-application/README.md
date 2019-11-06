## Source Application

This application is meant to emulate legacy services which does not publish events directly into Kafka for various reasons. 

However, it exposes an API which allows consumers to poll for information based on a timestamp in the query parameter.