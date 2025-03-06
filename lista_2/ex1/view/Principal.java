package lista_2.ex1.view;

import lista_2.ex1.controller.RedesController;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        RedesController cont = new RedesController();
        int x = 0;
        do
        {
            x = Integer.parseInt(JOptionPane.showInputDialog("Insira o numero referente ao comando 1 - IP 2 - PING 9 - FIM"));

            switch (x)
            {
                case 1:
                    cont.ip();
                    break;
                case 2:
                    cont.ping();
                    break;
                default:
                    break;
            }
        } while (x != 9);
    }
}
