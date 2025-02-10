import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetDetailPage {
    public PetDetailPage(String name, String type, String breed, String age, String shelter) {
        JFrame frame = new JFrame(name + " - Pet Details");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        // Title
        JLabel titleLabel = new JLabel(name, SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Pet Image
        JLabel imageLabel = new JLabel(new ImageIcon("placeholder.jpg"), SwingConstants.CENTER);
        frame.add(imageLabel, BorderLayout.CENTER);

        // Pet Details
        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(4, 1, 10, 10));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsPanel.add(new JLabel("Type: " + type));
        detailsPanel.add(new JLabel("Breed: " + breed));
        detailsPanel.add(new JLabel("Age: " + age));
        detailsPanel.add(new JLabel("Shelter: " + shelter));
        frame.add(detailsPanel, BorderLayout.WEST);

        // Adopt Button
        JButton adoptButton = new JButton("Adopt " + name);
        adoptButton.setFont(new Font("Arial", Font.BOLD, 16));
        adoptButton.setBackground(new Color(50, 205, 50));
        adoptButton.setForeground(Color.WHITE);
        adoptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "You have adopted " + name + "!", "Adoption Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        frame.add(adoptButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PetDetailPage("Bella", "Dog", "Labrador", "3 years", "Happy Paws Shelter");
    }
}
