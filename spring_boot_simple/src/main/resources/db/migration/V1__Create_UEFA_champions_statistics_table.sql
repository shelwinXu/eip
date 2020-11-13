DROP TABLE IF EXISTS eip_springboot.UEFA_champions_statistics;

CREATE TABLE UEFA_champions_statistics  (
	user_id bigserial PRIMARY KEY,
	team_name text UNIQUE NOT NULL,
	champion_times smallserial NOT NULL,
	runner_up_times smallserial NOT NULL,
	champion_years varchar[],
	runner_up_years varchar[],
	ranks smallserial NOT NULL
);