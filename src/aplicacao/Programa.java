package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.Empregado;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<Empregado> list = new ArrayList<>();

		System.out.print("Quantos empregados serão cadastrados? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Empregado #" + i + ": ");

			System.out.print("Id: ");
			int id = sc.nextInt();
			while (existeId(list, id)==true) {
				System.out.print("Id já existente. Tente novamente: ");
				id = sc.nextInt();
			}

			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salário: ");
			double salario = sc.nextDouble();
			list.add(new Empregado(id, nome, salario));
		}

		System.out.println();
		System.out.print("Informe o Id do funcionário que terá seu salário modificado: ");
		int id = sc.nextInt();
		Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("Esse Id não existe!");
		} else {
			System.out.print("Informe o percentual: ");
			double percentual = sc.nextDouble();
			emp.ajusteSalario(percentual);
		}

		System.out.println();
		System.out.println("Lista de Empregados:");
		for (Empregado obj : list) {
			System.out.println(obj);
		}
		sc.close();
	}

	public static boolean existeId(List<Empregado> list, int id) {
		Empregado emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
}
