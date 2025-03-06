package lista_2.ex1.controller;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class RedesController {
    public RedesController()
    {
        super();
    }

    private String nomeOs()
    {
        return  System.getProperty("os.name");
    }
    public void ip()
    {
        String cmd = "";
        if (nomeOs().contains("Windows"))
            cmd = "IPCONFIG";
        else
            cmd = "iconfig";

        String[] vetCmd = cmd.split(" ");

        try
        {
            Process p  = Runtime.getRuntime().exec(vetCmd);

            InputStream inp_s = p.getInputStream();
            InputStreamReader inp_r = new InputStreamReader(inp_s);
            BufferedReader bf_r = new BufferedReader(inp_r);

            String line = bf_r.readLine();
            while (line != null)
            {
                if (line.contains("IPv4"))
                {
                    System.out.println(line);
                }
                if (line.contains("Sufixo DNS"))
                {
                    System.out.println(line);
                }
                line = bf_r.readLine();
            }
            bf_r.close();
            inp_r.close();
            inp_s.close();
        }
        catch  (IOException e)
        {
                System.out.println(e.getMessage());
        }
    }

    public void ping()
    {
        String cmd = "";
        if (nomeOs().contains("Windows"))
            cmd = "ping -4 -n 10 www.google.com.br";
        else
            cmd = "ping -4 -c 10 www.gsoogle.com.br";

        String[] vetCmd = cmd.split(" ");

        try
        {
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
        catch  (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
