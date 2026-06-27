

/**
 * Представление времени в формате ЧЧ.ММ.СС.
 */
public class Time {
    private final int hours;
    private final int minutes;
    private final int seconds;

    private static final int SECONDS_PER_DAY = 86_400;
    private static final int SECONDS_PER_HOUR = 3_600;
    private static final int SECONDS_PER_MINUTE = 60;

    /**
     * Создаёт объект времени из общего количества секунд.
     * Значение автоматически приводится к диапазону 0–86399.
     *
     * @param seconds секунды с начала отсчёта
     */
    public Time(int seconds) {
        int remainingSeconds = seconds % SECONDS_PER_DAY;

        if (remainingSeconds < 0) {
            remainingSeconds += SECONDS_PER_DAY;
        }

        this.hours = remainingSeconds / SECONDS_PER_HOUR;
        int remainder = remainingSeconds % SECONDS_PER_HOUR;
        this.minutes = remainder / SECONDS_PER_MINUTE;
        this.seconds = remainder % SECONDS_PER_MINUTE;
    }


    /**
     * Форматирует время как ЧЧ.ММ.СС с ведущими нулями.
     *
     * @return отформатированная строка
     */
    @Override
    public String toString() {
        return String.format("%02d.%02d.%02d",
                this.hours, this.minutes, this.seconds
        );
    }
}
