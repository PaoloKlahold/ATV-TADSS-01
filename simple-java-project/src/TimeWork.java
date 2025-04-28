public class TimeWork {
    public int actualTime = 0;

    public void setActualTime(int time) {
        if (time > actualTime) {
            this.actualTime = time;
        }
    }

    public int getActualTime() {
        return actualTime;
    }
}
