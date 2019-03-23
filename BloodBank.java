import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class BloodBank{


    Connection con;
    Statement st;
    ResultSet rs;
 
    public static void main(String[] args) throws Exception {

        JLabel l1,l2,l3,l4,l5;
        JTextField t1,t2,t3,t5;

       JFrame f=new JFrame("Blood Bank Stock");

//textfield start
        t1=new JTextField();
        t1.setBounds(150,25, 350,25);
        f.add(t1);
        t2=new JTextField();
        t2.setBounds(150,50, 350,25);
        f.add(t2);
        t3=new JTextField();
        t3.setBounds(150,75, 350,25);
        f.add(t3);
        t5=new JTextField();
        t5.setBounds(150,125, 350,25);
        f.add(t5);

//label start

        l1=new JLabel("Blood Bank");
        l1.setBounds(0,25, 150,25);
        l2=new JLabel("Red Cell Concentration");
        l2.setBounds(0,50, 150,25);
        l3=new JLabel("F.F Plasma");
        l3.setBounds(0,75, 150,25);
        l4=new JLabel("Blood Type");
        l4.setBounds(0,100, 150,25);
        l5=new JLabel("Stock Date Entry");
        l5.setBounds(0,125, 150,25);
        //l6=new JLabel("Gender");
        //l6.setBounds(0,150, 150,25);
        f.add(l1); f.add(l2);f.add(l3); f.add(l4);f.add(l5);
        //f.add(l6);
        String blood[]={"A+","AB-","O-","AB+","O+"};
        JComboBox cb=new JComboBox<String>(blood);
        cb.setBounds(150, 100,350,25);
        f.add(cb);

//label end


//button start
        JButton b1=new JButton("submit");
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
             try {
                 Class.forName("com.mysql.cj.jdbc.Driver");
                 System.out.println("start");
				 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bloodbank","rbk@28","glorytogod@7");
                 String Blood_Bank=t1.getText();
                 String Red_Cell_Concentration=t2.getText();
                 String F_F_Plasma=t3.getText();
                 String Blood_Type=cb.getSelectedItem().toString();
                 String Stock_Date_Entry=t5.getText();
                 PreparedStatement val  = con.prepareStatement("INSERT INTO `hello`" + "(`Blood_Bank`,`Red_Cell_Concentration`,`F_F_Plasma`,`Blood_Type`,`Stock_Date_Entry`)" +"VALUES(?,?,?,?,?)");
                 val.setString(1,Blood_Bank);
                 val.setString(2,Red_Cell_Concentration);
                 val.setString(3,F_F_Plasma);
                 val.setString(4,Stock_Date_Entry);
                 val.setString(5,Blood_Type);
                 val.executeUpdate();
             }
      catch(Exception exc){
           System.out.println(exc.getMessage());
                }
            }
        });
        b1.setBounds(50,250,150,30);
        f.add(b1);
//button end
/*radio button

        JRadioButton jRadioButton1 = new JRadioButton();
        jRadioButton1.setText("Male");
        jRadioButton1.setBounds(155, 150, 120, 50);
        f.add(jRadioButton1);
        JRadioButton jRadioButton2 = new JRadioButton();
        jRadioButton2.setText("Female");
        jRadioButton2.setBounds(255, 150, 120, 50);
        f.add(jRadioButton2);
//radio button end*/
        //dropdown list

        f.setSize(500,500);
        f.setLayout(null);
        f.setVisible(true);

    }
}







	