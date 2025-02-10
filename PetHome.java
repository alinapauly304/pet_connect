import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetHome {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pet Adoption Portal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);

        // Title Label
        JLabel titleLabel = new JLabel("Powered by Petfinder\nAdopt your new best friend", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(128, 0, 128));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        frame.add(titleLabel, BorderLayout.NORTH);

        // Filter Panel with reduced width
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        filterPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        filterPanel.add(new JLabel("Animal Type:"));
        filterPanel.add(new JComboBox<>(new String[]{"Any", "Dog", "Cat", "Rabbit"}));
        filterPanel.add(new JLabel("Size:"));
        filterPanel.add(new JComboBox<>(new String[]{"Any", "Small", "Medium", "Large"}));
        filterPanel.add(new JButton("More Filters"));
        
        frame.add(filterPanel, BorderLayout.CENTER);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 3, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(createPetPanel("Kingsley", "Dog", "Pit Bull Terrier", "Adult - Medium"));
        mainPanel.add(createPetPanel("Pepper", "Cat", "Domestic Short Hair", "Senior - Medium"));
        mainPanel.add(createPetPanel("Chase", "Dog", "Australian Cattle Dog", "Young - Medium"));
        mainPanel.add(createPetPanel("Tobie", "Dog", "Retriever Mix", "Young - Medium"));
        mainPanel.add(createPetPanel("Bella", "Dog", "Labrador", "3 years"));
        mainPanel.add(createPetPanel("Milo", "Cat", "Persian", "2 years"));

        frame.add(mainPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private static JPanel createPetPanel(String name, String type, String breed, String age) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(name));
        panel.setBackground(Color.WHITE);

        JLabel imageLabel = new JLabel(new ImageIcon("placeholder.jpg"));
        JLabel detailsLabel = new JLabel("<html>Type: " + type + "<br>Breed: " + breed + "<br>Age: " + age + "</html>", SwingConstants.CENTER);
        detailsLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JButton adoptButton = new JButton("Adopt " + name);
        adoptButton.setBackground(new Color(50, 205, 50));
        adoptButton.setForeground(Color.WHITE);
        adoptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "You have adopted " + name + "!", "Adoption Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        panel.add(imageLabel, BorderLayout.NORTH);
        panel.add(detailsLabel, BorderLayout.CENTER);
        panel.add(adoptButton, BorderLayout.SOUTH);

        return panel;
    }
}
