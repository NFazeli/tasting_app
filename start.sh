#!/bin/bash
set -e

COMPOSE_DOCKER_CLI_BUILD=1 docker-compose --project-name tasting_app up "$@"
