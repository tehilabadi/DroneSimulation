import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimulationWindow {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationWindow window = new SimulationWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SimulationWindow() {
		initialize();
	}

	public static JLabel info_label;
	public static boolean return_home = false;
	boolean toogleStop = true;
	private void initialize() {
		frame = new JFrame();
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int height = dim.height;
		int width = dim.width;
		frame.setSize(width, height - 20);
		frame.setTitle("Drone Simulator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(true);

		
		
		/*
		 * Stop\Resume
		 */
	
		JButton stopBtn = new JButton("Start/Pause");

		stopBtn.setBackground(Color.lightGray);
		stopBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  if(toogleStop) {
					  CPU.stopAllCPUS();
				  } else {
					  CPU.resumeAllCPUS();
				  }
				  toogleStop = !toogleStop;
			  }
		});
		stopBtn.setBounds(width-200, 50,140, 30);
		frame.getContentPane().add(stopBtn);
		/*
		 * Speeds
		 */
		
		
		JButton speedBtn1 = new JButton("speedUp");
		speedBtn1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.speedUp();
			  }
		});
		speedBtn1.setBounds(width-250, 100,100, 30);
		frame.getContentPane().add(speedBtn1);
		
		JButton speedBtn2 = new JButton("speedDown");
		speedBtn2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.speedDown();
			  }
		});
		speedBtn2.setBounds(width-150, 100,100, 30);
		frame.getContentPane().add(speedBtn2);
		
		/*
		 * Spins
		 */
		
		JButton spinBtn1 = new JButton("spin180");
		spinBtn1.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(180);
			  }
		});
		spinBtn1.setBounds(width-250, 150,80, 30);
		frame.getContentPane().add(spinBtn1);
		
		JButton spinBtn2 = new JButton("spin90");
		spinBtn2.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(90);
			  }
		});
		spinBtn2.setBounds(width-170, 150,80, 30);
		frame.getContentPane().add(spinBtn2);
		
		JButton spinBtn3 = new JButton("spin60");
		spinBtn3.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(60);
			  }
		});
		spinBtn3.setBounds(width-90, 150,80, 30);
		frame.getContentPane().add(spinBtn3);
		
		JButton spinBtn4 = new JButton("spin45");
		spinBtn4.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(60);
			  }
		});
		spinBtn4.setBounds(width-250, 200,80, 30);
		frame.getContentPane().add(spinBtn4);
		
		JButton spinBtn5 = new JButton("spin30");
		spinBtn5.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(30);
			  }
		});
		spinBtn5.setBounds(width-170, 200,80, 30);
		frame.getContentPane().add(spinBtn5);
		
		JButton spinBtn6 = new JButton("spin-30");
		spinBtn6.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-30);
			  }
		});
		spinBtn6.setBounds(width-90, 200,80, 30);
		frame.getContentPane().add(spinBtn6);
		
		JButton spinBtn7 = new JButton("spin-45");
		spinBtn7.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-45);
			  }
		});
		spinBtn7.setBounds(width-250, 250,80, 30);
		frame.getContentPane().add(spinBtn7);
		
		JButton spinBtn8 = new JButton("spin-60");
		spinBtn8.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.spinBy(-60);
			  }
		});
		spinBtn8.setBounds(width-170, 250,80, 30);
		frame.getContentPane().add(spinBtn8);
		
		/*
		 * Toogle real map
		 */
		
		JButton toogleMapBtn = new JButton("toogle Map");
		toogleMapBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  toogleRealMap = !toogleRealMap;
			  }
		});
		toogleMapBtn.setBounds(width-250, 300,120, 30);
		frame.getContentPane().add(toogleMapBtn);
		
		/*
		 * Toogle AI
		 */
		
		JButton toogleAIBtn = new JButton("toogle AI");
		toogleAIBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  toogleAI = !toogleAI;
			  }
		});
		toogleAIBtn.setBounds(width-130, 300,120, 30);
		frame.getContentPane().add(toogleAIBtn);
		
		/*
		 * RETURN TO HOME
		 */
		

		JButton returnBtn = new JButton("Return Home");
		returnBtn.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  return_home = !return_home;
				  algo1.speedDown();
				  algo1.spinBy(180, true, new Func() {
						@Override
						public void method() {
							algo1.speedUp();
						}
					});
			  }
		});
		returnBtn.setBounds(width-250, 350,120, 30);
		frame.getContentPane().add(returnBtn);
		
		JButton Graph = new JButton("Open Graph");
		Graph.addActionListener(new ActionListener()
		{
			  public void actionPerformed(ActionEvent e)
			  {
				  algo1.mGraph.drawGraph();
			  }
		});
		Graph.setBounds(width-130, 350,120, 30);
		frame.getContentPane().add(Graph);
		
		/*
		 * Info label 
		 */
		
		
		info_label = new JLabel();
		info_label.setBounds(width-250, height-300, 300, 200);
		frame.getContentPane().add(info_label);

		time_label = new JLabel();
		time_label.setBounds(width-250, height-360, 300, 200);
		frame.getContentPane().add(time_label);

		/*
		 * Info label 
		 */
		info_label2 = new JLabel();
		info_label2.setBounds(width-250, height-400, 300, 200);
		frame.getContentPane().add(info_label2);

		main();
	}
	public JLabel info_label2;
	public JLabel time_label;
	public static boolean toogleRealMap = true;
	public static boolean toogleAI = false;

	public static double time = 0.0;
	public static double startTime = 0.0;

	public static AutoAlgo1 algo1;
	
	
	public void main() {
		int map_num = 4;
		Point[] startPoints = {
				new Point(100,50),
				new Point(50,60),
				new Point(73,68),
				new Point(84,73),
				new Point(92,100)};
		
		Map map = new Map("DroneSimulator/Maps/p1" + map_num + ".png",startPoints[map_num-1]);
		
		algo1 = new AutoAlgo1(map);
		
		Painter painter = new Painter(algo1);
		painter.setBounds(0, 0, 2000, 2000);
		frame.getContentPane().add(painter);
		
		CPU painterCPU = new CPU(200,"painter"); // 60 FPS painter
		painterCPU.addFunction(frame::repaint);
		painterCPU.play();
		
		algo1.play();
		
		CPU updatesCPU = new CPU(60,"updates");
		updatesCPU.addFunction(algo1.drone::update);
		updatesCPU.play();
		startTime = System.nanoTime();
		CPU infoCPU = new CPU(6,"update_info");
		infoCPU.addFunction(this::updateInfo);
		infoCPU.play();
	}
	
	public void updateInfo(int deltaTime) {
		double endTime   = System.nanoTime();
		time = (endTime - startTime)/1000000000;
		if(time > 240 && !return_home){
			return_home = true;
		}
		info_label.setText(algo1.drone.getInfoHTML());
		info_label2.setText("<html>" + String.valueOf(algo1.counter) + " <BR>isRisky:" + String.valueOf(algo1.is_risky) + 
				"<BR>" + String.valueOf(algo1.risky_dis) + "</html>");
		time_label.setText("<html>" +"<BR>time:" + String.valueOf(time) + "<BR>return home:" + String.valueOf(return_home) + "</html>");
	}
	
	public void stopCPUS() {
		CPU.stopAllCPUS();
	}
	
	public void resumseCPUS() {
		CPU.stopAllCPUS();
	}
}
