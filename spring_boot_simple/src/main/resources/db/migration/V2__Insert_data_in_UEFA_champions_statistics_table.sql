-- DROP TABLE IF EXISTS eip_springboot.UEFA_champions_statistics;
--
-- CREATE TABLE UEFA_champions_statistics  (
-- 	user_id bigserial PRIMARY KEY,
-- 	team_name text UNIQUE NOT NULL,
-- 	champion_times smallserial NOT NULL,
-- 	runner_up_times smallserial NOT NULL,
-- 	champion_years text[],
-- 	runner_up_years text[],
-- 	ranks smallserial NOT NULL
-- );


Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,champion_years,runner_up_years,ranks) values ('Real Madrid', '13','3','{"1956", "1957", "1958", "1959", "1960", "1966", "1998", "2000", "2002", "2014", "2016", "2017", "2018"}','{"1962", "1964", "1981"}','1');
Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,champion_years,runner_up_years,ranks) values ('AC Milan', '7','4','{"1963", "1969", "1989", "1990", "1994", "2003", "2007"}','{"1958", "1993", "1995", "2005"}','2');
Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,champion_years,runner_up_years,ranks) values ('Livepool', '6','3','{"1977", "1978", "1981", "1984", "2005", "2019"}','{"1985","2007","2018"}','3');
Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,champion_years,runner_up_years,ranks) values ('Bayern Munich', '6','5','{"1974", "1975", "1976", "2001", "2013", "2020"}','{"1982", "1987", "1999", "2010", "2012"}','4');
Insert into UEFA_champions_statistics(team_name,champion_times,runner_up_times,champion_years,runner_up_years,ranks) values ('Barcelona', '5','3','{"1992", "2006", "2009", "2011", "2015"}','{"1961", "1986", "1994"}','5');
