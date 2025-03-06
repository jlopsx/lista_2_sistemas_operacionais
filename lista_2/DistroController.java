package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {
	public DistroController()
	{
		super();
	}
	
	private String nomeOs() {
		return System.getProperty("os.name");
	}
	
	public void exibeDistro() {
		if (!nomeOs().contains("Linux"))
			System.out.println("Sistema operacional não é linux");
		else {
			String cmd = "cat /etc/os-release";
			String[] vetCmd = cmd.split(" ");
			try
		{
			Process p = Runtime.getRuntime().exec(vetCmd);
			
			InputStream ip_s = p.getInputStream();
			InputStreamReader ipr_s = new InputStreamReader(ip_s);
			BufferedReader bf_r = new BufferedReader(ipr_s);
			String line = bf_r.readLine();
			
			while (line != null)
			{
				System.out.println(line);
				line = bf_r.readLine();
			}
			bf_r.close();
			ipr_s.close();
			ip_s.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	}
}
