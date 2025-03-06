package lista_2.ex2.view;

import lista_2.ex2.controller.KillController;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        KillController kc = new KillController();
        String cmd = "";
        int esc = 0;

        do {
            esc = Integer.parseInt(JOptionPane.showInputDialog("Insira o que deseja fazer 1- Kill p/PID 2- Kill p/Nome 3 - listar processos 9- encerrar"));
            switch (esc)
            {
                case 1:
                    cmd = JOptionPane.showInputDialog("Insira o PID: ");
                    kc.mataPid(cmd);
                    break;
                case 2:
                    cmd = JOptionPane.showInputDialog("Insira o nome: ");
                    kc.mataNome(cmd);
                case 3:
                    kc.listaProcesso();
                default:
                    break;
            }
        } while (esc != 9);
    }
}
