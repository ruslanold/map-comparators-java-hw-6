public class Index {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(new Time(0, 8), new Time(0, 22));
        Schedule schedule = new Schedule();

        Movie vikings = new Movie("vikings", new Time(15,1));
        Movie boys = new Movie("boys", new Time(20,1));
        Movie halo4 = new Movie("halo4", new Time(30,1));
        Movie okTenStudents = new Movie("okTenStudents", new Time(0,1));

        Seance seance1 = new Seance(vikings, new Time(20, 8));
        Seance seance2 = new Seance(boys, new Time(20, 9));
        Seance seance3 = new Seance(halo4, new Time(10, 10));
        Seance seance4 = new Seance(okTenStudents, new Time(30, 22));
        Seance seance5 = new Seance(halo4, new Time(00, 18));


        schedule.addSeance(seance1);
        schedule.addSeance(seance2);
        schedule.addSeance(seance3);
        schedule.addSeance(seance4);

        cinema.addSeances(DaysOfWeek.MONSDAY, schedule);
        System.out.println(cinema.getAllSchedule());

        cinema.addSeance(seance5, DaysOfWeek.MONSDAY);
        System.out.println(cinema.getAllSchedule());

        cinema.removeMovie(vikings);
        System.out.println(cinema.getAllSchedule());

        cinema.removeSeance(seance5, DaysOfWeek.MONSDAY);
        System.out.println(cinema.getAllSchedule());

    }
}
