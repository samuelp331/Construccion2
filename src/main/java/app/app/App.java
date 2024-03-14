package app.app;

import java.sql.Connection;
import java.util.Scanner;

import app.config.MYSQLConnection;
import app.controller.LoginController;

public class App {
	private static Scanner scanner = new Scanner(System.in);
	private static LoginController loginController = new LoginController();
	public static void main(String[] args) {
		boolean run = true;
			try {
				run = runApplication();
				Connection con = MYSQLConnection.getConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
	}

	public static boolean runApplication() throws Exception {
		
		
		String menu = "ingrese \n1.Para iniciar sesion \n2.Para cerrar la aplicacion";
		System.out.println(menu);
		String option = scanner.nextLine();
		switch (option) {
		case "1": {
			loginController.login();
			return true;
		}
		case "2": {
			return false;
		}
		default: {
			System.out.print("ingrese una opcion valida");
			return true;
		}

		}

		 /*Connection connection = MYSQLConnection.getConnection();
		    if (connection != null) {
		        System.out.println("Conexión exitosa");
		        return true;
		    } else {
		        System.out.println("No se pudo establecer la conexión" + connection);
		        return false;
		    }*/
		

		}

	}




