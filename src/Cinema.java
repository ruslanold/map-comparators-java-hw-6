import java.util.*;

public class Cinema {

    private Map<DaysOfWeek, Schedule> allSchedule;
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        this.allSchedule = new TreeMap<DaysOfWeek, Schedule>();
        this.open = open;
        this.close = close;
    }

    public Map<DaysOfWeek, Schedule> getAllSchedule() {
        return allSchedule;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    private boolean checkValidTimeSeanse(Seance seance){
        int startSeanceInSeconds = (seance.getStartTime().getHour() * 3600) + (seance.getStartTime().getMin() * 60);
        int endSeanceInSeconds = (seance.getEndTime().getHour() * 3600) + (seance.getEndTime().getMin() * 60);

        int openCinemaInSeconds = (this.open.getHour() * 3600) + (this.open.getMin() * 60);
        int closeCinemaInSeconds = (this.close.getHour() * 3600) + (this.close.getMin() * 60);

        if (startSeanceInSeconds > openCinemaInSeconds && endSeanceInSeconds < closeCinemaInSeconds){
            return true;
        }
        return false;

    }

    public void addSeance(Seance seance, DaysOfWeek day){
        Boolean timeValid = this.checkValidTimeSeanse(seance);

        if (timeValid) {

            if (!this.allSchedule.containsKey(day)) {
                Schedule schedule = new Schedule();
                schedule.addSeance(seance);
                this.allSchedule.put(day, schedule);
            }

            Set<DaysOfWeek> keys = this.allSchedule.keySet();
            for (DaysOfWeek key:keys) {
                if(key.equals(day)){
                    this.allSchedule.get(key).addSeance(seance);
                }
            }

        }

    }

    public void addSeances(DaysOfWeek day, Schedule schedule){
        Set<Seance> seances = schedule.getSeances();

        for (Seance seance:seances) {
            this.addSeance(seance, day);
        }

    }

    public void removeMovie(Movie movie) {
        Set<DaysOfWeek> days = this.allSchedule.keySet();

        for (DaysOfWeek day : days) {
            Set<Seance> seances = this.allSchedule.get(day).getSeances();
            Iterator<Seance> iterator = seances.iterator();

            while (iterator.hasNext()) {
                Seance seance = iterator.next();
                if(seance.getMovie().equals(movie)){
                    iterator.remove();
                }
            }

        }

    }

    @Override
    public String toString() {
        return "Cinema{" +
                "allSchedule=" + allSchedule +
                ", open=" + open +
                ", close=" + close +
                '}';
    }

    public void removeSeance(Seance seance, DaysOfWeek day){
        Set<DaysOfWeek> keys = this.allSchedule.keySet();

        for (DaysOfWeek key : keys) {
            if(key.equals(day)){
                this.allSchedule.get(key).removeSeance(seance);
            }
        }

    }

}
