package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCalculadora {
	public static void main(String[] args) {
		Socket sckCliente;
		InputStream canalDeEntrada;
		OutputStream canalDeSaida;
		PrintWriter saida;
		BufferedReader entrada;
		
		
		try {
			sckCliente = new Socket("127.0.0.1", 4000);
			canalDeEntrada = sckCliente.getInputStream();
			canalDeSaida = sckCliente.getOutputStream();

			entrada = new BufferedReader(new InputStreamReader(canalDeEntrada));
			saida = new PrintWriter(canalDeSaida, true);
			saida.println("1");
			saida.println("2");
			saida.println("1");
			saida.println("");
			for (;;) {
				String s = entrada.readLine();
				if (s == null)
					break;
				System.out.println(s);
			}

			sckCliente.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
