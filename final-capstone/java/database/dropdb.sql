-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'angela_capstone';

DROP DATABASE angela_capstone;

DROP USER angela_capstone_owner;
DROP USER angela_capstone_appuser;
