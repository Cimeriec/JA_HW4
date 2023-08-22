package example3;

import java.time.*;


public class Main {
    public static void main(String[] args) {
        LocalDateTime birthday = LocalDateTime.of(1978, Month.JULY, 8, 12, 0);
        LocalDateTime now = LocalDateTime.now();
        Period p = Period.between(birthday.toLocalDate(), now.toLocalDate());
        Duration d = Duration.between(birthday.toLocalTime(), now.toLocalTime());
        System.out.println();
        int hour = (int) (d.getSeconds()) / 60 / 60;
        int min = (int) (d.getSeconds()) / 60 - hour * 60;
        int sec = (int) (d.getSeconds()) - (((hour * 60) + min) * 60);
        System.out.printf("Вам виповнилося %s років, %s місяці, %s днів, %s години, %s хвилин та %s секунд", p.getYears(), p.getMonths(), p.getDays(), hour, min, sec);
    }
}
