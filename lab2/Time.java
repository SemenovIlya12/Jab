public class Time {
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;

    public Time(int seconds) {
        while (seconds >= 86400) {
            seconds -= 86400;
        }

        this.hours = seconds / 3600;
        seconds -= this.hours * 3600;
        this.minutes = seconds/60;
        seconds -= this.minutes *60;
        this.hours = seconds;
    }


    @Override
    public String toString() {
        return (this.hours < 9 ? "0" + this.hours : this.hours) + "." + (this.minutes < 9 ? "0" + this.minutes : this.minutes) + "." + (this.seconds < 9 ? "0" + this.seconds : this.seconds);
    }
}
