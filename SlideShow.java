import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class SlideShow extends JFrame {

	//Declare Variables
	private JPanel slidePane;
	private JPanel textPane;
	private JPanel buttonPane;
	private CardLayout card;
	private CardLayout cardText;
	private JButton btnPrev;
	private JButton btnNext;
	private JLabel lblSlide;
	private JLabel lblTextArea;

	/**
	 * Create the application.
	 */
	public SlideShow() throws HeadlessException {
		initComponent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initComponent() {
		//Initialize variables to empty objects
		card = new CardLayout();
		cardText = new CardLayout();
		slidePane = new JPanel();
		textPane = new JPanel();
		textPane.setBackground(Color.PINK);	//changed color from blue to pink to make descriptions more visible ~Tammy
		textPane.setBounds(5, 470, 790, 50);
		textPane.setVisible(true);
		buttonPane = new JPanel();
		btnPrev = new JButton();
		btnNext = new JButton();
		lblSlide = new JLabel();
		lblTextArea = new JLabel();

		//Setup frame attributes
		setSize(800, 600);
		setLocationRelativeTo(null);
		setTitle("Top 5 Detox and Wellness Destinations");	//Updated after product owner review revealed new focus~Tammy
		getContentPane().setLayout(new BorderLayout(10, 50));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Setting the layouts for the panels
		slidePane.setLayout(card);
		textPane.setLayout(cardText);
		
		//logic to add each of the slides and text
		for (int i = 1; i <= 5; i++) {
			lblSlide = new JLabel();
			lblTextArea = new JLabel();
			lblSlide.setText(getResizeIcon(i));
			lblTextArea.setText(getTextDescription(i));
			slidePane.add(lblSlide, "card" + i);
			textPane.add(lblTextArea, "cardText" + i);
		}

		getContentPane().add(slidePane, BorderLayout.CENTER);
		getContentPane().add(textPane, BorderLayout.SOUTH);

		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

		btnPrev.setText("Previous");
		btnPrev.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goPrevious();
			}
		});
		buttonPane.add(btnPrev);

		btnNext.setText("Next");
		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				goNext();
			}
		});
		buttonPane.add(btnNext);

		getContentPane().add(buttonPane, BorderLayout.SOUTH);
	}

	/**
	 * Previous Button Functionality
	 */
	private void goPrevious() {
		card.previous(slidePane);
		cardText.previous(textPane);
	}
	
	/**
	 * Next Button Functionality
	 */
	private void goNext() {
		card.next(slidePane);
		cardText.next(textPane);
	}

	/**
	 * Method to get the images
	 */
	private String getResizeIcon(int i) {
		String image = ""; 
		if (i==1){	//new focus is detox and wellness focused locations~Tammy
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Amangiri_Resort,_Utah.jpg") + "'</body></html>";	//updated based on new focus~Tammy
		} else if (i==2){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/AyanaResort_Bali.jpg") + "'</body></html>";	//updated based on new focus~Tammy
		} else if (i==3){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/California_Japanese_Garden.jpg") + "'</body></html>";	//updated based on new focus~Tammy
		} else if (i==4){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Tabacon_Hot_Springs,_Costa_Rica.jpg") + "'</body></html>";	//updated based on new focus~Tammy
		} else if (i==5){
			image = "<html><body><img width= '800' height='500' src='" + getClass().getResource("/resources/Tulum,_Mexico_Sanara.jpg") + "'</body></html>";		//updated based on new focus~Tammy
		}
		return image;
	}
	
	/**
	 * Method to get the text values
	 */
	private String getTextDescription(int i) {
		String text = ""; 
		//updated each if and else if statement to reflect new location info with concentration on detox and wellness destinations ~Tammy
		if (i==1){
			text = "<html><body><font size='5'>#1 Amangiri Resort, Utah </font> <br>Inside you will find a floatation therapy pavilion, sprawling pools, and terraces to relax from while admiring the surrounding rugged beauty. .</body></html>";
		} else if (i==2){
			text = "<html><body><font size='5'>#2 Ayana Resort, Bali </font> <br>AYANA Resort offers luxurious rooms overlooking bali's most beautiful and secluded white sand beaches of Jimbaran Bay.</body></html>";
		} else if (i==3){
			text = "<html><body><font size='5'>#3 Japanese Garden, California </font> <br>In the midst of the busy San Fernando Valley lies an oasis – a dry Zen meditation garden, a “wet-strolling” garden, and a tea garden.</body></html>";
		} else if (i==4){
			text = "<html><body><font size='5'>#4 Tabacon Hot Springs, Costa Rica </font> <br>Tumbling waterfalls, luxury spa and dining options, and the dramatic backdrop of Arenal Volcano offers true peace.</body></html>";
		} else if (i==5){
			text = "<html><body><font size='5'>#5 Sanara, Tulum Mexico </font> <br>Tulum is famous for its ruins but is also known for its beaches and beach cabañas that offer one the chance to relax and heal.</body></html>";
		}
		return text;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				SlideShow ss = new SlideShow();
				ss.setVisible(true);
			}
		});
	}
}