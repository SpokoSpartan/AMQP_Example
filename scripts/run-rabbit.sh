#!/bin/bash
docker run --rm -d --hostname my-rabbit --name rabbit-ws -p 5672:5672 -p 80:15672 rabbitmq:3-management
