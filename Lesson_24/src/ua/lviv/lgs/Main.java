package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	static void menuForAdminOrUser() {
		System.out.println("¬вед≥ть 1 €кщо ви адм≥н≥стратор");
		System.out.println("¬вед≥ть 2 €кщо ви в≥дв≥дувач");
		Scanner sc = new Scanner(System.in);
		while (true) {
			switch (sc.next()) {
			case "1": {
				System.out.println("якщо ви адм≥н≥стратор, то введ≥ть лог≥н");
				sc = new Scanner(System.in);
				String login = sc.next();
				if (login.equalsIgnoreCase("Admin")) {
					System.out.println("ѕрив≥т, адм≥н≥строт, гарного вам дн€");
					menuForAdmin();
				} else {
					System.out.println("Ќеправильний лог≥н");
				}
				break;
			}
			case "2": {
				System.out.println("ƒобрий день в≥дв≥дувач!!!");
				menuForUser();
				break;
			}
			}
		}
		
	}

	static void menuForAdmin() {
		System.out.println("¬вед≥ть 1 дл€ того, щоб додати ф≥льм в ф≥льмотеку");
		System.out.println("¬вед≥ть 2 дл€ того, щоб перев≥рити всю ф≥льмотеку");
		System.out.println("¬вед≥ть 3 дл€ того, щоб додати сеанс");
		System.out.println("¬вед≥ть 4 дл€ того, щоб видалити сеанс");
		System.out.println("¬вед≥ть 5 дл€ того, щоб видалити ф≥льм з ф≥льмотеки");
		
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));

		while (true) {
			switch (sc.next()) {
			case "1": {
				sc = new Scanner(System.in);
				System.out.println("¬вед≥ть назву ф≥льма");
				String title = sc.next();
				System.out.println("¬вед≥ть к≥льк≥сть годин, ск≥льки буде йти ф≥льм");
				int hour = sc.nextInt();
				System.out.println("¬вед≥ть к≥льк≥сть хвилин, ск≥льки буде йти ф≥льм");
				int min = sc.nextInt();
				cinema.addMovie(title, hour, min);
				break;
			}
			case "2": {
				for (Movie cin : cinema.moviesLibrary) {
					System.out.println(cin);
				}
				break;
			}
			case "3":{
				sc = new Scanner(System.in);
				System.out.println("¬вед≥ть день тижн€ в €кий хочете додати сеанс");
				String daysOfWeek = sc.next();
				System.out.println("¬вед≥ть назву ф≥льма");
				String movieName = sc.next();
				System.out.println("¬вед≥ть к≥льк≥сть годин, ск≥льки буде йти ф≥льм");
				int movieHour = sc.nextInt();
				System.out.println("¬вед≥ть к≥льк≥сть хвилин, ск≥льки буде йти ф≥льм");
				int movieMin = sc.nextInt();
				System.out.println("¬вед≥ть о котр≥й годин≥ буде починатис€ сеанс");
				int seanceHour = sc.nextInt();
				System.out.println("¬вед≥ть о котр≥й хвилин≥ буде починатис€ сеанс");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "4": {
				sc = new Scanner(System.in);
				System.out.println("¬вед≥ть день тижн€ з €кого хочете видалити сеанс");
				String daysOfWeek = sc.next();
				System.out.println("¬вед≥ть назву ф≥льму в сеанс≥");
				String movieName = sc.next();
				System.out.println("¬вед≥ть к≥льк≥сть годин, ск≥льки йде ф≥льм");
				int movieHour = sc.nextInt();
				System.out.println("¬вед≥ть к≥льк≥сть хвилин, ск≥льки йде ф≥льм");
				int movieMin = sc.nextInt();
				System.out.println("¬вед≥ть о котр≥й годин≥ починатЇтьс€ сеанс");
				int seanceHour = sc.nextInt();
				System.out.println("¬вед≥ть о котр≥й хвилин≥ починатЇтьс€ сеанс");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "5": {
				sc = new Scanner(System.in);
				System.out.println("¬вед≥ть назву ф≥льма, €кого хочете видалити з ф≥льмотеки");
				String title = sc.next();
				cinema.removeMovie(null);
			}
			}
		}
	}

	static void menuForUser() {
		System.out.println("¬вед≥ть 1 дл€ того, щоб подивитис€ всю ф≥льмотеку");
		System.out.println("¬вед≥ть 2 дл€ того, щоб перегл€нути вс≥ сеанси");
		
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));
		
		while (true) {
			switch (sc.next()) {
			case "1": {
				for (Movie cin : cinema.moviesLibrary) {
					System.out.println(cin);
				}
				break;
			}
			case "2": {
				for(Entry<Days, Schedule> entry : cinema.schedules.entrySet()) {
					System.out.println(entry);
				}
				break;
			}
			}
		}
		
		
	}

	public static void main(String[] args) {
		menuForAdminOrUser();

	}

}
