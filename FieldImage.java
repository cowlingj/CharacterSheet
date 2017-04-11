import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FieldImage extends JFrame implements ActionListener
{
  
  Field model;

  public FieldImage(Field requiredField)
  {
    model = requiredField;

    switch model.getType()
    {
      case "Label":
        labelImage()
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
  {}

  public String toString()
  {
    return "Field Type: " + model.getType() + "\n"
             + "Field Name: " + model.getName() + "\n"
             + "Field Value: " + model.getValue() + "\n"
             + "Field Highlighted: " + model.getHighlighted().toString();
  }

  public _____ labelImage()

}