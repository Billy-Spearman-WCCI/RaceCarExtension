public interface Contestant {
    float getDistanceTravelled();
    void setPosition(int position);
    void turn();
    void accelerate();
    void move();
    void outputPosition();

    // When computing places, we give extra credit to contestants who have flair
    float getStyleCreditDistance();
}
