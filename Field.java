public abstract class Field
{

  private String name;
  private String value = null;
  private FieldImage image;
  private String type;

  public String getName()
  {
    return name;
  }

  public void setName(String requiredName)
  {
    name = requiredName;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String requiredValue)
  {
    value = requiredValue;
  }

  public FieldImage getImage()
  {
    return image;    
  }

  public void setImage()
  {
    image = new FieldImage(this);
  }

  public String getType()
  {
    return type;
  }

  public void setType(String requiredType)
  {
    type = requiredType;
  }

}

class Label extends Field
{
  public Label(String requiredName)
  {
    setName(requiredName);
    setType("Label");
    setImage();
  }

}

class Attribute extends Field
{
  public Attribute(String requiredName)
  {
    setName(requiredName);
    setType("Attribute");
    setImage();
  }
}

class Description extends Field
{

  public Description(String requiredName)
  {
    setName(requiredName);
    setType("Description");
    setImage();
  }

}