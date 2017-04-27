import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FieldImage extends JPanel implements ActionListener
{
  
  Field model;

  public FieldImage(Field requiredField)
  {
    model = requiredField;

    switch (model.getType())
    {
      case "Label":
        labelImage();
        break;
      case "Attribute":
        attributeImage();
        break;
      case "Description":
        descriptionImage();
        break;
    }
  }

  public void actionPerformed(ActionEvent event)
  {
    System.out.println("Button Clicked");
  }

  public String toString()
  {
    return "Field Type: " + model.getType() + "\n"
             + "Field Name: " + model.getName() + "\n"
             + "Field Value: " + model.getValue();
  }

  public void labelImage()
  {
    JTextField nameImage = new JTextField(20);
    JTextField bodyImage = new JTextField(20);
    add(nameImage);
    add(bodyImage);
  }

  public void descriptionImage()
  {
    JTextField nameImage = new JTextField(20);
    JTextArea bodyImage = new JTextArea(10, 20);
    add(nameImage);
    add(new JScrollPane(bodyImage));
  }

  public void attributeImage()
  {
    JTextField nameImage = new JTextField(20);
    JTextField bodyImage = new JTextField(20);
    add(nameImage);
    add(bodyImage);
    JButton attributeButton = new JButton("Calc");
    add(attributeButton);

    attributeButton.addActionListener(this);
  }

}