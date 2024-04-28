DROP TABLE aircraft;

CREATE TABLE aircraft (
    id INT AUTO_INCREMENT PRIMARY KEY,
    call_sign VARCHAR(255),
    squawk VARCHAR(255),
    reg VARCHAR(255),
    flight_no VARCHAR(255),
    route VARCHAR(255),
    type VARCHAR(255),
    category VARCHAR(255),
    altitude INT,
    heading INT,
    speed INT,
    vert_rate INT,
    selected_altitude INT,
    lat DOUBLE,
    lon DOUBLE,
    barometer DOUBLE,
    polar_distance DOUBLE,
    polar_bearing DOUBLE,
    is_adsb BOOLEAN,
    is_on_ground BOOLEAN,
    last_seen_time DATETIME,
    pos_update_time DATETIME,
    bds40seen_time DATETIME
);
