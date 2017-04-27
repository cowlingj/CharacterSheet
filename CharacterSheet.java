import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowAdapter;

public class CharacterSheet extends JFrame implements ActionListener
{
  
  // JPanels for label, attribute, and description images
  private JPanel labelJPanel = new JPanel();
  private JPanel attributeJPanel = new JPanel();
  private JPanel descriptionJPanel = new JPanel();

  // Lists for labels, attributes, and descriptions
  private List<Label> labelList = new ArrayList<Label>();
  private List<Attribute> attributeList = new ArrayList<Attribute>();
  private List<Description> descriptionList = new ArrayList<Description>();

  public CharacterSheet()
  {
    // set up frame with 3 columns
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(new GridLayout(0, 3));
    setTitle("Character Sheet");
    Container contents = getContentPane();

    // add label button
    JButton addLabelJButton = new JButton("Add Label");
    contents.add(addLabelJButton);
    labelJPanel.setLayout(new GridLayout(0,1));
    addLabelJButton.addActionListener(this);

    // add attribute button
    JButton addAttributeJButton = new JButton("Add Attribute");
    contents.add(addAttributeJButton);
    attributeJPanel.setLayout(new GridLayout(0,1));
    addAttributeJButton.addActionListener(this);

    // Add description button
    JButton addDescriptionJButton = new JButton("Add Description");
    contents.add(addDescriptionJButton);
    descriptionJPanel.setLayout(new GridLayout(0,1));
    addDescriptionJButton.addActionListener(this);

    // add JPanels to JFrame
    contents.add(new JScrollPane(labelJPanel));
    contents.add(new JScrollPane(attributeJPanel));
    contents.add(new JScrollPane(descriptionJPanel));

    pack();
  }

  // create and show the window
  public static void main(String[] args)
  {
    new CharacterSheet().setVisible(true);
  }

  // add a Field to the relevant list and the image to the JPanel
  public void actionPerformed(ActionEvent event)
  {
    JButton source = (JButton) event.getSource();

    switch (source.getText())
    {
      case "Add Label":
        new AddFieldWindow("label", this);
        break;
      case "Add Attribute":
        new AddFieldWindow("attribute", this);
        break;
      case "Add Description":
        new AddFieldWindow("description", this);
        break;
      
    }
  }

  public void addField(String name, String type)
  {

System.out.println("Adding Field: " + type + ", called: " + name);

    switch (type)
    {
      case "label":
        Label label = new Label(name);
        labelList.add(label);
        labelJPanel.add(label.getImage());
        pack();
        break;
      case "attribute":
        Attribute attribute = new Attribute(name);
        attributeList.add(attribute);
        attributeJPanel.add(attribute.getImage());
        pack();
        break;
      case "description":
        Description description = new Description(name);
        descriptionList.add(description);
        descriptionJPanel.add(description.getImage());
        pack();
        break;
    }
  }

}

class AddFieldWindow extends JFrame implements ActionListener
{

  private JTextField nameField = new JTextField(20);
  private String type;
  CharacterSheet characterSheet;

  public AddFieldWindow(String requiredType, CharacterSheet requiredCharacterSheet)
  {
    type = requiredType;
    characterSheet = requiredCharacterSheet;

    // set up frame
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setLayout(new FlowLayout());
    setTitle(type + " Name");
    Container contents = getContentPane();
    contents.add(nameField);
    JButton confirmJButton = new JButton("Confirm");
    confirmJButton.addActionListener(this);
    contents.add(confirmJButton);
    pack();
    setVisible(true);
  }

  public void actionPerformed(ActionEvent event)
  {
    if (! this.nameField.getText().equals(""))
      characterSheet.addField(this.nameField.getText(), type);
    dispose();
  }
}