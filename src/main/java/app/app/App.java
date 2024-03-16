package app.app;

import java.sql.Connection;
import java.util.Scanner;

import app.config.MYSQLConnection;

public class App {
	private static Scanner reader = new Scanner(System.in);
	public static void main(String[] args) {
		boolean run = true;
			try {
				run = runApplication();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public static boolean runApplication() throws Exception {
		

		 Connection connection = MYSQLConnection.getConnection();
		    if (connection != null) {
		        System.out.println("Conexión exitosa");
		        return true;
		    } else {
		        System.out.println("No se pudo establecer la conexión" + connection);
		        return false;
		    }
		

		}

	}




