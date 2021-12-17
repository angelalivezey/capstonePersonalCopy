-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER angela_capstone_owner
WITH PASSWORD 'angelacapstone';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO angela_capstone_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO angela_capstone_owner;

CREATE USER angela_capstone_appuser
WITH PASSWORD 'angelacapstone';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO angela_capstone_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO angela_capstone_appuser;
