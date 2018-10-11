package murach.games;

import java.util.Random;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class NumberGame {
    private int upperLimit;
    private int number;
    private int guessCount;
    private LocalDateTime start;
    private LocalDateTime end;
    
    public NumberGame() {
        this(50);        
    }
    
    public NumberGame(int upperLimit) {
        this.upperLimit = upperLimit;
        Random random = new Random();
        number = random.nextInt(upperLimit - 1) + 1;
        guessCount = 1;
        
    }

    public int getNumber() {
        return number;
    }

    public int getGuessCount() {
        return guessCount;
    }
    
    public int getUpperLimit() {
        return upperLimit;
    }
    
    public void incrementGuessCount() {
        guessCount = guessCount + 1;
    }
    public LocalDateTime getDateTimeStart(){
        return start;
    }
    public LocalDateTime getDateTimeEnd(){
        return end;
    }
    public void setDateTimeStart(){
        start = LocalDateTime.now();
    }
    public void setDateTimeEnd(){
        end = LocalDateTime.now();
    }
    public long getSecondsTime(){
        long temp3 = start.toInstant(ZoneOffset.UTC).getEpochSecond();
        long temp4 = end.toInstant(ZoneOffset.UTC).getEpochSecond();
        return temp4-temp3;
    }
}