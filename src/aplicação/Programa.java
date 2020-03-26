package aplicação;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Produtos;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Produtos> list = new ArrayList<>();

		String caminho = "C:\\Users\\geek\\Desktop\\curso de java\\produtos.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String aux = br.readLine();

			while (aux != null) {
				String[] dados = aux.split(";");

				list.add(new Produtos(dados[0], Double.parseDouble(dados[1]), Integer.parseInt(dados[2])));
				aux = br.readLine();
			}
			boolean pasta = new File(sc.nextLine() + sc.nextLine()).mkdir();
			try (BufferedWriter bw = new BufferedWriter(
					new FileWriter("C:\\Users\\geek\\Desktop\\curso de java\\sumary\\sumary.csv"))) {
				for (int i = 0; i < list.size(); i++) {
					bw.write(list.get(i).toString());
					bw.newLine();

				}
				for (Produtos x : list) {
					System.out.println(x);
				}

			} catch (IOException e) {
				e.getStackTrace();

			}

		} catch (IOException e) {
			e.getStackTrace();

		}

		sc.close();
	}
}
