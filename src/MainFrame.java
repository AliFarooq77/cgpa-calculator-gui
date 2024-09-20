import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JComboBox cb1;
    private JPanel panel1;
    private JComboBox cb2;
    private JButton calculateButton;
    private JLabel lbl_1;
    private JTextField tf1;
    static String semesterLimit = "1";
    static String noOfCourses;
    MainFrame(){
        setContentPane(panel1);
        setTitle("CGPA Calculator");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 230);
        setLocationRelativeTo(null);
        setVisible(true);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int semesterLimit = Integer.parseInt(tf1.getText());
                int noOfCourses = 0;
                int creditHours = 0;
                double gradePoint = 0;
                double weight = 0;
                double weightSum = 0;
                int creditSum = 0;
                double GPA = 0;

                for (int i = 1; i < semesterLimit; i++) {
                    String semester = "Semester " + i + "\n";
                    noOfCourses = Integer.parseInt(JOptionPane.showInputDialog(semester + "Enter the number of courses: "));
                    for (int j = 1; j <= noOfCourses; j++) {
                        String course = "Course #" + j + "\n";
                        creditHours = Integer.parseInt(JOptionPane.showInputDialog(course + "Credit hours: "));
                        gradePoint = Double.parseDouble(JOptionPane.showInputDialog(course + "G.P (Grade Point): "));
                        weight = creditHours * gradePoint;
                        weightSum += weight;
                        creditSum += creditHours;
                    }
                }

                GPA = weightSum / creditSum;
                JOptionPane.showMessageDialog(null, "GPA: " + GPA);
            }
        });
    }
}
