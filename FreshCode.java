// Primary Coder: Dan Avila(danthecodingman)
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.text.DecimalFormat;
import javax.swing.UIManager.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
public class FreshCode extends JFrame
{
    private double cost;
    private double interest;
    private double downPayment;
    private double years;
    private double compound;
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JTextField field;
    private JTextField f;
    private JTextField y;
    private JTextField d;
    
    public FreshCode()
    {
        initUI();        
    }
    
    public final void initUI() 
    {
        setLayout(null);
        
        ImageIcon icon = new ImageIcon("Calc.jpg");
        
        JLabel item = new JLabel("Item Cost:");
        item.setBounds(10,50,80,20);
        
        JLabel pInterest = new JLabel("Percent Interest:");
        pInterest.setBounds(10,80,100,50);
        
        JLabel payment = new JLabel("Down Payment:");
        payment.setBounds(10,120,100,50);
        
        JLabel year = new JLabel("Years:");
        year.setBounds(10,160,100,50);
        
        JLabel iType = new JLabel("Compound");
        iType.setBounds(10,200,100,50);
        
        JLabel iType2 = new JLabel("Frequency:");
        iType2.setBounds(10,215,100,50);
        
        JLabel ans = new JLabel();
        ans.setBounds(50,280,500,50);
        
        JLabel ans2 = new JLabel();
        ans2.setBounds(85,300,500,50);
        
        //cost
        field = new JTextField();
        field.setBounds(120,50,80,30);
        field.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    button.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                }
            }
        });
        
        //interest
        f = new JTextField();
        f.setBounds(120,95,80,30);    
        f.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    button.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                }
            }
        });
        
        d = new JTextField();
        d.setBounds(120,135,80,30);
        d.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    button.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                }
            }
        });
        
        y = new JTextField();
        y.setBounds(120,175,80,30);
        y.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    button.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                }                
            }
        });
        
        button = new JButton("Continuously");
        button.setBounds(98,210,125,25);
        button.setEnabled(true);
        button.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {                
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    String costText = field.getText();
                    cost = Integer.parseInt(costText);
                    
                    ans2.setText("");
                    
                    String interestText = f.getText();
                    interest = Double.parseDouble(interestText);                
                    
                    String downPaymentText = d.getText();
                    downPayment = Double.parseDouble(downPaymentText);
                    
                    String yearText = y.getText();
                    years = Double.parseDouble(yearText);
                    
                    double payment = (cost - downPayment) * Math.exp((years * interest/100));
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    if(downPayment > cost)
                    {
                        ans.setText("Down payment cannot be more");
                        ans2.setText("than the item cost.");
                    }
                    else
                    {
                        ans.setText("You owe: $" + df.format(payment/(12 * years)) + " a month for " + years + " years");
                    }
                }
                else
                {
                    ans.setText("You must complete all fields.");
                }
            }
        });
        
        button2 = new JButton("Monthly");
        button2.setBounds(98,235,125,25);
        button2.setEnabled(true);
        button2.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    String costText = field.getText();
                    cost = Integer.parseInt(costText);
      
                    ans2.setText("");
                    
                    String interestText = f.getText();
                    interest = Double.parseDouble(interestText);                
                    
                    String downPaymentText = d.getText();
                    downPayment = Double.parseDouble(downPaymentText);
                    
                    String yearText = y.getText();
                    years = Double.parseDouble(yearText);
                    
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    
                    double numberToUse = (cost - downPayment) * Math.pow(1 + (((interest/100)/(12))), (12.0 * years));
                    
                    if(downPayment > cost)
                    {
                        ans.setText("Down payment cannot be more");
                        ans2.setText("than the item cost.");
                    }
                    else
                    {
                        ans.setText("You owe: $" + df.format(numberToUse/(12 * years)) + " a month for " + years + " years");
                    }
                }
                else
                {
                    ans.setText("You must complete all fields.");
                }
            }
        });
        
                
        button3 = new JButton("Yearly");
        button3.setBounds(98,260,125,25);
        button3.setEnabled(true);
        button3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                if(field.getText().length() > 0 && f.getText().length() > 0 && d.getText().length() > 0 && y.getText().length() > 0)
                {
                    String costText = field.getText();
                    cost = Integer.parseInt(costText);
                    
                    ans2.setText("");
                    
                    String interestText = f.getText();
                    interest = Double.parseDouble(interestText);                
                    
                    String downPaymentText = d.getText();
                    downPayment = Double.parseDouble(downPaymentText);
                    
                    String yearText = y.getText();
                    years = Double.parseDouble(yearText);
                    
                    double payment = (cost - downPayment) * Math.exp((years * interest/100));
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    
                    double bigDog = Math.pow((1 + interest/100), years);
                    
                    double coolGuy = (cost - downPayment) * bigDog;
                
                    if(downPayment > cost)
                    {
                        ans.setText("Down payment cannot be more");
                        ans2.setText("than the item cost.");
                    }
                    else
                    {
                        ans.setText("You owe: $" + df.format(coolGuy/(years * 12)) + " a month for " + years + " years");
                    }
                }
                else
                {
                    ans.setText("You must complete all fields.");
                }
            }                    
        });
        
        setTitle("Loan Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(field);
        add(item);
        add(pInterest);
        add(f);
        add(payment);
        add(d);
        add(year);
        add(y);
        add(button);
        add(button2);
        add(button3);
        add(ans);
        add(ans2);
        add(iType);
        add(iType2);
    }
    
    
    public static void main (String[] args)
    {                
        SwingUtilities.invokeLater(new Runnable() 
        {

            public void run() 
            {
            try {
                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {

            }
                FreshCode f = new FreshCode();
                f.setVisible(true);
            }
        });
    }
}
