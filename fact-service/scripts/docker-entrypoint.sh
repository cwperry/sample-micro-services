#!/bin/sh

# Abort on any error (including if wait-for-it fails).
set -e

# Wait for the backend to be up, if we know where it is.
if [ -n "$DISCOVERY_HOST" ]; then
  /usr/src/app/wait-for-it.sh "$DISCOVERY_HOST:${$DISCOVERY_HOST:-8761}"
fi

# Run the main container command.
exec "$@"