package com.guilhermebaltazar.demo.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import com.guilhermebaltazar.demo.enums.LiveStatus;

import jakarta.persistence.*;

@Entity
@Table(name = "lives")
public class Live {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String liveName;

    @Column(nullable = false)
    private String channelName;

    @Column(nullable = false)
    private LocalDateTime liveDate;

    @Column(nullable = false)
    private String liveLink;

    @Column(nullable = false)
    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LiveStatus liveStatus;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public LocalDateTime getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(LocalDateTime liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LiveStatus getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(LiveStatus liveStatus) {
        this.liveStatus = liveStatus;
    }

    // hashCode and equals
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Live other = (Live) obj;
        return Objects.equals(id, other.id);
    }
}
