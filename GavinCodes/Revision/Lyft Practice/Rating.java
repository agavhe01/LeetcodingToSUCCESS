class Rating {
    Long rideId;
    Long ratingFromUserId;
    Long rating;

    public Rating(Long rideId, Long ratingFromUserId, Long rating) {
        this.rideId = rideId;
        this.ratingFromUserId = ratingFromUserId;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating {" +
                "rideId = " + rideId +
                ", ratingFromUserId = " + ratingFromUserId +
                ", rating = " + rating +
                '}';
    }
}