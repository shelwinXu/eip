DROP TABLE IF EXISTS eip_springboot.UEFA_champions_statistics;

CREATE TABLE UEFA_champions_statistics  (
	user_id bigserial PRIMARY KEY,
	team_name text UNIQUE NOT NULL,
	champion_times smallserial NOT NULL,
	runner_up_times smallserial NOT NULL,
	champion_years text[],
	runner_up_years text[],
	ranks smallserial NOT NULL
);

-- Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,	champion_years text[],) values ('livepool', ENCODE('18942020', 'base64'));
-- Insert into UEFA_champions_statistics(username,password) values ('Rome',ENCODE('19272020', 'base64'));