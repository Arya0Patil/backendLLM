package com.prepwizard.demo.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String code;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "course_price")
    private Double coursePrice;

    @Column(name = "discounted_price")
    private Double discountedPrice;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "course_priority")
    private Integer coursePriority = 0;

    @Column(name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "validity_days", nullable = false)
    private Integer validityDays;

    @Column(name = "created_at", updatable = false, insertable = false)
    private LocalDateTime createdAt;

}

