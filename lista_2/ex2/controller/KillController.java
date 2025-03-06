package lista_2.ex2.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
    public KillController ()
    {
        super();
    }

    private String nomeOs()
    {
        return System.getProperty("os.name");
    }

    public void listaProcesso()
    {
        String cmd = "";
        if (nomeOs().contains("Windows"))
            cmd = "TASKLIST /FO TABLE";
        else
            cmd = "ps -ef";

        String[] vetCmd = cmd.split(" ");

        try {
            Process p  = Runtime.getRuntime().exec(vetCmd);

            InputStream inp_s = p.getInputStream();
            InputStreamReader inp_r = new InputStreamReader(inp_s);
            BufferedReader bf_r = new BufferedReader(inp_r);

            String line = bf_r.readLine();
            while (line != null)
            {
                System.out.println(line);
                line = bf_r.readLine();
            }
            bf_r.close();
            inp_r.close();
            inp_s.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void mataPid(String pid)
    {
        String cmd = "";
        if (nomeOs().contains("Windows"))
            cmd = "TASKKILL /PID";
        else
            cmd = "kill -9";

        int conv_pid = 0;

        StringBuilder buffer = new StringBuilder();

        conv_pid = Integer.parseInt(pid);

        buffer.append(cmd);
        buffer.append(" ");
        buffer.append(conv_pid);

        String[] vetCmd = buffer.toString().split(" ");

        try {
            Runtime.getRuntime().exec(vetCmd);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void mataNome(String nome)
    {
        {
            String cmd = "";
            if (nomeOs().contains("Windows"))
                cmd = "TASKKILL /IM";
            else
                cmd = "pkill -f";


            StringBuilder buffer = new StringBuilder();

            buffer.append(cmd);
            buffer.append(" ");
            buffer.append(nome);

            String[] vetCmd = buffer.toString().split(" ");

            try {
                Runtime.getRuntime().exec(vetCmd);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
