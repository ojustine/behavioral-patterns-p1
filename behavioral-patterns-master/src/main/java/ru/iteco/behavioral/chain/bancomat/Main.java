package ru.iteco.behavioral.chain.bancomat;

/**
 * Main.
 *
 * @author Ilya_Sukhachev
 */
public class Main {

    public static void main(String[] args) {
        Bancomat bancomat = new Bancomat();
        System.out.println(bancomat.validate("100 euros"));
        System.out.println(bancomat.cash("2100 rubles"));
        System.out.println(bancomat.cash("2100 euros"));
        System.out.println(bancomat.cash("450 dollars"));

    }
}
