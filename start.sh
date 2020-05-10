#!/bin/bash
set -e

docker-compose --project-name tasting_app up "$@"
