#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER expandor;
    CREATE DATABASE expensionrecorder;
    GRANT ALL PRIVILEGES ON DATABASE expandor TO expensionrecorder;
EOSQL