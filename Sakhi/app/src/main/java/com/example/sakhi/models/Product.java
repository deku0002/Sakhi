package com.example.sakhi.models;

public class Product {
    private int id;
    private String name;
    private String description;
    private String priceRange;
    private float rating;
    private int reviewCount;
    private String emoji;

    public Product() {}

    public Product(int id, String name, String description, String priceRange,
                   float rating, int reviewCount, String emoji) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priceRange = priceRange;
        this.rating = rating;
        this.reviewCount = reviewCount;
        this.emoji = emoji;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getPriceRange() { return priceRange; }
    public void setPriceRange(String priceRange) { this.priceRange = priceRange; }

    public float getRating() { return rating; }
    public void setRating(float rating) { this.rating = rating; }

    public int getReviewCount() { return reviewCount; }
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount; }

    public String getEmoji() { return emoji; }
    public void setEmoji(String emoji) { this.emoji = emoji; }
}