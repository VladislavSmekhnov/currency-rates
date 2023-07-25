#!/bin/bash

docker rmi -f currency_rates && docker build . -t currency_rates -f ./Dockerfile && docker run -it currency_rates