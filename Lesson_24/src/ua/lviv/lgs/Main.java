package ua.lviv.lgs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Main {

	static void menuForAdminOrUser() {
		System.out.println("������ 1 ���� �� �����������");
		System.out.println("������ 2 ���� �� ��������");
		Scanner sc = new Scanner(System.in);
		while (true) {
			switch (sc.next()) {
			case "1": {
				System.out.println("���� �� �����������, �� ������ ����");
				sc = new Scanner(System.in);
				String login = sc.next();
				if (login.equalsIgnoreCase("Admin")) {
					System.out.println("�����, ���������, ������� ��� ���");
					menuForAdmin();
				} else {
					System.out.println("������������ ����");
				}
				break;
			}
			case "2": {
				System.out.println("������ ���� ��������!!!");
				menuForUser();
				break;
			}
			}
		}
		
	}

	static void menuForAdmin() {
		System.out.println("������ 1 ��� ����, ��� ������ ����� � ����������");
		System.out.println("������ 2 ��� ����, ��� ��������� ��� ����������");
		System.out.println("������ 3 ��� ����, ��� ������ �����");
		System.out.println("������ 4 ��� ����, ��� �������� �����");
		System.out.println("������ 5 ��� ����, ��� �������� ����� � ����������");
		
		Scanner sc = new Scanner(System.in);
		Cinema cinema = new Cinema(new TreeMap<Days, Schedule>(), new ArrayList<Movie>(), new Time(10, 0), new Time(22, 0));

		while (true) {
			switch (sc.next()) {
			case "1": {
				sc = new Scanner(System.in);
				System.out.println("������ ����� ������");
				String title = sc.next();
				System.out.println("������ ������� �����, ������ ���� ��� �����");
				int hour = sc.nextInt();
				System.out.println("������ ������� ������, ������ ���� ��� �����");
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
				System.out.println("������ ���� ����� � ���� ������ ������ �����");
				String daysOfWeek = sc.next();
				System.out.println("������ ����� ������");
				String movieName = sc.next();
				System.out.println("������ ������� �����, ������ ���� ��� �����");
				int movieHour = sc.nextInt();
				System.out.println("������ ������� ������, ������ ���� ��� �����");
				int movieMin = sc.nextInt();
				System.out.println("������ � ����� ����� ���� ���������� �����");
				int seanceHour = sc.nextInt();
				System.out.println("������ � ����� ������ ���� ���������� �����");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "4": {
				sc = new Scanner(System.in);
				System.out.println("������ ���� ����� � ����� ������ �������� �����");
				String daysOfWeek = sc.next();
				System.out.println("������ ����� ������ � �����");
				String movieName = sc.next();
				System.out.println("������ ������� �����, ������ ��� �����");
				int movieHour = sc.nextInt();
				System.out.println("������ ������� ������, ������ ��� �����");
				int movieMin = sc.nextInt();
				System.out.println("������ � ����� ����� ����������� �����");
				int seanceHour = sc.nextInt();
				System.out.println("������ � ����� ������ ����������� �����");
				int seanceMin = sc.nextInt();
				cinema.addSeance(new Seance(new Movie(movieName, new Time(movieHour, movieMin)), new Time(seanceHour, seanceMin), new Time(0, 0)), daysOfWeek);
				break;
			}
			case "5": {
				sc = new Scanner(System.in);
				System.out.println("������ ����� ������, ����� ������ �������� � ����������");
				String title = sc.next();
				cinema.removeMovie(null);
			}
			}
		}
	}

	static void menuForUser() {
		System.out.println("������ 1 ��� ����, ��� ���������� ��� ����������");
		System.out.println("������ 2 ��� ����, ��� ����������� �� ������");
		
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
