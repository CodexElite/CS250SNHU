import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TopFiveDestinationList {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TopDestinationListFrame topDestinationListFrame = new TopDestinationListFrame();
                topDestinationListFrame.setTitle("Top 5 Destination List");
                topDestinationListFrame.setVisible(true);
            }
        });
    }
}


class TopDestinationListFrame extends JFrame {
    private DefaultListModel listModel;

    public TopDestinationListFrame() {
        super("Top Five Destination List");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(900, 750);

        listModel = new DefaultListModel();

     // Image published by PhilipC @ https://upload.wikimedia.org/wikipedia/commons/b/b6/TheOldPort.jpg
        addDestinationNameAndPicture("        1. Portland, ME – Portland offers a charming coastal experience, with plenty to do in the historic Old Port district, known for its cobblestone streets, unique boutiques, seafood restaurants, and scenic waterfront views!", new ImageIcon(getClass().getResource("/resources/TheOldPort.jpg")));
        // Image published by Katie Rommel-Esham @ https://commons.wikimedia.org/wiki/File:Cinderella_Castle.jpg
        addDestinationNameAndPicture("                               2. Orlando, FL - A fantastic destination with plenty to explore, including Universal Studios, the Orlando Science Center, and the iconic Walt Disney World Resort!", new ImageIcon(getClass().getResource("/resources/OrlandoFL.jpg")));
        // Image published by U.S. Air Force Tech. Sgt. Andy Dunaway @ https://commons.wikimedia.org/wiki/File:WashMonument_WhiteHouse.jpg
        addDestinationNameAndPicture("3. Washington, DC - A top destination filled with diverse museums covering various aspects of history, along with iconic landmarks like the U.S. Capitol, the White House, and so much more!", new ImageIcon(getClass().getResource("/resources/WashingtonDC.jpg")));
        // Image published by Dietmar Rabich @ https://commons.wikimedia.org/wiki/File:Las_Vegas_(Nevada,_USA),_Fabulous_Las_Vegas_--_2012_--_6263.jpg
        addDestinationNameAndPicture("                               4. Las Vegas, NV - Las Vegas is an exciting destination full of energy, featuring countless hotels, casinos, and museums—all set against a stunning nighttime skyline!", new ImageIcon(getClass().getResource("/resources/LasVegasNV.jpg")));
        // Image published by Davide Mauro @ https://commons.wikimedia.org/wiki/File:Orante_1.jpg
        addDestinationNameAndPicture("5. Sicily, Italy – Sicily is a captivating destination rich in history and culture, offering stunning coastlines, ancient ruins like the Valley of the Temples, vibrant markets, and charming towns such as Taormina and Palermo—perfect for exploring the heart of the Mediterranean!", new ImageIcon(getClass().getResource("/resources/Orante_1.jpg")));
        
        JList list = new JList(listModel);
        // Sets the background color of the list element
        list.setBackground(Color.green);
        JScrollPane scrollPane = new JScrollPane(list);

        TextAndIconListCellRenderer renderer = new TextAndIconListCellRenderer(2);

        list.setCellRenderer(renderer);
        
        // Added label before list that states my name
        JLabel nameLabel = new JLabel("Developer: Joshua Conklin");
        
        getContentPane().add(nameLabel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

    }

    private void addDestinationNameAndPicture(String text, Icon icon) {
        TextAndIcon tai = new TextAndIcon(text, icon);
        listModel.addElement(tai);
    }
}


class TextAndIcon {
    private String text;
    private Icon icon;

    public TextAndIcon(String text, Icon icon) {
        this.text = text;
        this.icon = icon;
    }

    public String getText() {
        return text;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}


class TextAndIconListCellRenderer extends JLabel implements ListCellRenderer {
    private static final Border NO_FOCUS_BORDER = new EmptyBorder(1, 1, 1, 1);

    private Border insideBorder;

    public TextAndIconListCellRenderer() {
        this(0, 0, 0, 0);
    }

    public TextAndIconListCellRenderer(int padding) {
        this(padding, padding, padding, padding);
    }

    public TextAndIconListCellRenderer(int topPadding, int rightPadding, int bottomPadding, int leftPadding) {
        insideBorder = BorderFactory.createEmptyBorder(topPadding, leftPadding, bottomPadding, rightPadding);
        setOpaque(true);
    }

    public Component getListCellRendererComponent(JList list, Object value,
    int index, boolean isSelected, boolean hasFocus) {
        // The object from the combo box model MUST be a TextAndIcon.
        TextAndIcon tai = (TextAndIcon) value;

        // Sets text and icon on 'this' JLabel.
        setText(tai.getText());
        setIcon(tai.getIcon());

        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }

        Border outsideBorder;

        if (hasFocus) {
            outsideBorder = UIManager.getBorder("List.focusCellHighlightBorder");
        } else {
            outsideBorder = NO_FOCUS_BORDER;
        }

        setBorder(BorderFactory.createCompoundBorder(outsideBorder, insideBorder));
        setComponentOrientation(list.getComponentOrientation());
        setEnabled(list.isEnabled());
        setFont(list.getFont());

        return this;
    }

    // The following methods are overridden to be empty for performance
    // reasons. If you want to understand better why, please read:
    //
    // http://java.sun.com/javase/6/docs/api/javax/swing/DefaultListCellRenderer.html#override

    public void validate() {}
    public void invalidate() {}
    public void repaint() {}
    public void revalidate() {}
    public void repaint(long tm, int x, int y, int width, int height) {}
    public void repaint(Rectangle r) {}
}