package com.zmeev.redisproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "call_sign")
    private String callsign;

    private String squawk;
    private String reg;

    @Column(name = "flight_no")
    private String flightno;

    private String route;
    private String type;
    private String category;

    private int altitude, heading, speed;
    @Column(name = "vert_rate")
    @JsonProperty("vert_rate")
    private int vertRate;
    @Column(name = "selected_altitude")
    @JsonProperty("selected_altitude")
    private int selectedAltitude;

    private double lat, lon, barometer;

    @Column(name = "polar_distance")
    @JsonProperty("polar_distance")
    private double polarDistance;

    @Column(name = "polar_bearing")
    @JsonProperty("polar_bearing")
    private double polarBearing;

    @Column(name = "is_adsb")
    @JsonProperty("is_adsb")
    private boolean isADSB;

    @Column(name = "is_on_ground")
    @JsonProperty("is_on_ground")
    private boolean isOnGround;

    @Column(name = "last_seen_time")
    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;

    @Column(name = "pos_update_time")
    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;
}

