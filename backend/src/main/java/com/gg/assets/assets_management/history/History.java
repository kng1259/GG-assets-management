package com.gg.assets.assets_management.history;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gg.assets.assets_management.asset.Asset;
import com.gg.assets.assets_management.user.User;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "histories")
@Data
@NoArgsConstructor
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime time;

    @NonNull
    private String action;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    @JsonIgnoreProperties("department")
    private User user;

    @ManyToOne
    @NonNull
    @JoinColumn(name = "asset_id")
    @ToString.Exclude
    @JsonIgnoreProperties("department")
    private Asset asset;

    public History(Asset asset, String action) {
        this.asset = asset;
        this.action = action;
    }

    public History(User user, Asset asset, String action) {
        this.user = user;
        this.asset = asset;
        this.action = action;
    }

}
