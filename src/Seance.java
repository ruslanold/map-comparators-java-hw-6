import java.util.Objects;

public class Seance implements Comparable<Seance>{

    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(){ }

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = this.calcEndTime(this.startTime,this.movie.getDuration());
    }

    private Time calcEndTime(Time start, Time duration){
        int endMin = start.getMin() + duration.getMin();
        int endHour = start.getHour() + duration.getHour();

        return new Time(endMin,endHour);
    }

    @Override
    public int compareTo(Seance seance) {
        int min = this.startTime.getMin() - seance.getStartTime().getMin();
        int hour = this.startTime.getHour() - seance.getStartTime().getHour();

        if(hour != 0){
            return hour;
        }else if(min != 0){
            return min;
        }
        return 0;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) && Objects.equals(startTime, seance.startTime) && Objects.equals(endTime, seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    @Override
    public String toString() {
        return "Seance{" +
                "movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
