package com.company.app.view;

import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.company.app.controller.ControllerInterface;
import com.company.app.model.BPMObserver;
import com.company.app.model.BeatModelInterface;
import com.company.app.model.BeatObserver;
import com.company.app.view.beatanimation.BeatAnimationStrategy;
import com.company.app.view.beatanimation.BlinkingDoubleColorBeatAnimationStrategy;
import com.company.app.view.beatanimation.triplecolor.BlinkingTripleColorBeatAnimationStrategy;

import javax.swing.JButton;

public class DJView implements BPMObserver, BeatObserver {

	private JFrame frame;

	private JPanel menuPanel;

	private JMenuBar menuBar;

	private JMenu mnNewMenu;

	private JMenuItem startMenuItem;

	private JMenuItem stopMenuItem;

	private JMenuItem quitMenuItem;

	private JPanel contentPanel;

	private JPanel inputBPMPanel;

	private JLabel enterBPMLabel;

	private JTextField enterBPMtextField;

	private JPanel setButtonPanel;

	private JButton setBPMButton;

	private JPanel bpmControllsPanel;

	private JButton increaseBPMButton;

	private JButton decreaseBPMButton;

	private JPanel beatPanel;

	private JPanel animationSelectPanel;

	private JPanel outputBPMPanel;

	private JLabel outputBPMTextLabel;

	private JLabel outputBPMValueLabel;

	private ControllerInterface controller;

	private BeatModelInterface beatModel;

	private BeatAnimationStrategy beatAnimationStrategy;

	public DJView(ControllerInterface controller, BeatModelInterface beatModel) {
		this.controller = controller;
		this.beatModel = beatModel;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		createFrame();
		createMenuPanel();
		createContentPanel();
		createInputBPMPanel();
		createSetButtonPanel();
		createBPMControllsPanel();
		createBeatPanel();
		createSelectAnimaitonPanel();
		createOutputBPMPanel();
		showFrame();
	}

	/**
	 * Launch the application.
	 */
	private void showFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void createFrame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
	}

	private void createMenuPanel() {
		menuPanel = new JPanel();
		frame.getContentPane().add(menuPanel, BorderLayout.NORTH);
		menuPanel.setLayout(new GridLayout(0, 1, 0, 0));

		menuBar = new JMenuBar();
		menuPanel.add(menuBar);

		mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		startMenuItem = new JMenuItem("Start");

		mnNewMenu.add(startMenuItem);
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
				disableStartMenuItem();
				enableStopMenuItem();
			}
		});

		stopMenuItem = new JMenuItem("Stop");
		mnNewMenu.add(stopMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
				disableStopMenuItem();
				enableStartMenuItem();
			}
		});

		quitMenuItem = new JMenuItem("Quit");
		mnNewMenu.add(quitMenuItem);
		quitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		enableStartMenuItem();
		disableStopMenuItem();
	}

	private void createContentPanel() {
		contentPanel = new JPanel();
		frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
	}

	private void createInputBPMPanel() {
		inputBPMPanel = new JPanel();
		contentPanel.add(inputBPMPanel);
		inputBPMPanel.setLayout(new GridLayout(0, 2, 0, 0));

		enterBPMLabel = new JLabel("Enter BPM:");
		inputBPMPanel.add(enterBPMLabel);

		enterBPMtextField = new JTextField();
		inputBPMPanel.add(enterBPMtextField);
		enterBPMtextField.setColumns(10);
	}

	private void createSetButtonPanel() {
		setButtonPanel = new JPanel();
		contentPanel.add(setButtonPanel);
		setButtonPanel.setLayout(new GridLayout(0, 1, 0, 0));

		setBPMButton = new JButton("Set");
		setButtonPanel.add(setBPMButton);
		setBPMButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String bpmString = enterBPMtextField.getText();
				try {
					int bpm = Integer.parseInt(bpmString);
					beatModel.setBPM(bpm);
				} catch (NumberFormatException ex) {
					System.out.println("Nmber format exception, exception: " + ex);
				} finally {
					enterBPMtextField.setText("");
				}
			}
		});
	}

	private void createBPMControllsPanel() {
		bpmControllsPanel = new JPanel();
		contentPanel.add(bpmControllsPanel);
		bpmControllsPanel.setLayout(new GridLayout(0, 2, 0, 0));

		decreaseBPMButton = new JButton("<<");
		bpmControllsPanel.add(decreaseBPMButton);
		decreaseBPMButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.decreaseBPM();
			}
		});

		increaseBPMButton = new JButton(">>");
		bpmControllsPanel.add(increaseBPMButton);
		increaseBPMButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.increaseBPM();
			}
		});
	}

	private void createBeatPanel() {
		beatPanel = new JPanel();
		contentPanel.add(beatPanel);
		beatPanel.setLayout(new GridLayout(1, 0, 0, 0));
	}

	private void createSelectAnimaitonPanel() {
		animationSelectPanel = new JPanel();
		contentPanel.add(animationSelectPanel);
		animationSelectPanel.setLayout(new GridLayout(1, 0, 0, 0));

		JMenuBar menuBar = new JMenuBar();
		animationSelectPanel.add(menuBar);

		JMenu mnNewMenu = new JMenu("Select Animation");
		menuBar.add(mnNewMenu);

		JMenuItem blinkMenuItem = new JMenuItem("Blinking");
		blinkMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beatAnimationStrategy = new BlinkingDoubleColorBeatAnimationStrategy();
			}
		});
		mnNewMenu.add(blinkMenuItem);

		JMenuItem progresMenuItem = new JMenuItem("Triple blinking");
		progresMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				beatAnimationStrategy = new BlinkingTripleColorBeatAnimationStrategy();
			}
		});
		mnNewMenu.add(progresMenuItem);
	}

	private void createOutputBPMPanel() {
		outputBPMPanel = new JPanel();
		contentPanel.add(outputBPMPanel);
		outputBPMPanel.setLayout(new GridLayout(0, 2, 0, 0));

		outputBPMTextLabel = new JLabel("current BPM:");
		outputBPMPanel.add(outputBPMTextLabel);

		outputBPMValueLabel = new JLabel("0");
		outputBPMPanel.add(outputBPMValueLabel);
		frame.pack();
	}

	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}

	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
	}

	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}

	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}

	@Override
	public void updateBeat(BeatModelInterface beatModelInterface) {
		if (beatAnimationStrategy != null) {
			beatAnimationStrategy.paintAnimation(beatPanel);
		} else {
			System.out.println(" animation strategy is null");
		}
	}

	@Override
	public void updateBPM(BeatModelInterface beatModelInterface) {
		outputBPMValueLabel.setText(beatModelInterface.getBPM() + "");
	}
}
